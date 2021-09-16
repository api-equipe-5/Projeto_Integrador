import { Request, Response } from "express";
import knex from "../database/connection";
import Projetos from "../models/Projetos";
import Usuarios from "../models/Usuarios";
import roles from "../constants/roles";

const getData = async (projectId: any, userId?: string) => {
  let data;

  if (userId) {
    data = await knex("tarefas")
      .join("usuarios", "usuarios.id", "tarefas.id_usuario")
      .select(
        "tarefas.id",
        "tarefas.concluido",
        "tarefas.status",
        "tarefas.descricao",
        "tarefas.horas"
      )

      .where("id_projeto", projectId)
      .where("id_usuario", userId);
  } else {
    data = await knex("tarefas")
      .join("usuarios", "usuarios.id", "tarefas.id_usuario")
      .select(
        "tarefas.id",
        "tarefas.concluido",
        "tarefas.status",
        "tarefas.descricao",
        "tarefas.horas"
      )

      .where("id_projeto", projectId);
  }

  const projeto = await Projetos.query()
    .select("*")
    .where("id", projectId)
    .first();

  const tasks = {
    project: projeto.projetoNome,
    tasks: data,
  };

  return tasks;
};

const getStats = async (projectId: any, userId?: any) => {
  let stats: {
    IN_PROGRESS: number;
    QA_TESTING: number;
    QA_DEPLOYING: number;
    RELEASE_TO_PROD: number;
    FOR_TEST: number;
    PROD_DEPLOYING: number;
    DONE: number;
  } = {
    IN_PROGRESS: 0,
    QA_TESTING: 0,
    QA_DEPLOYING: 0,
    RELEASE_TO_PROD: 0,
    FOR_TEST: 0,
    PROD_DEPLOYING: 0,
    DONE: 0,
  };

  let data;

  if (userId) {
    data = await knex("tarefas")
      .join("usuarios", "usuarios.id", "tarefas.id_usuario")
      .select(
        "tarefas.id",
        "tarefas.concluido",
        "tarefas.status",
        "tarefas.descricao",
        "tarefas.horas"
      )
      .where("id_projeto", projectId)
      .where("id_usuario", userId);
  } else {
    data = await knex("tarefas")
      .join("usuarios", "usuarios.id", "tarefas.id_usuario")
      .select(
        "tarefas.id",
        "tarefas.concluido",
        "tarefas.status",
        "tarefas.descricao",
        "tarefas.horas"
      )
      .where("id_projeto", projectId);
  }

  stats.IN_PROGRESS = data.filter(
    (element) => element.status === "IN_PROGRESS"
  ).length;
  stats.QA_TESTING = data.filter(
    (element) => element.status === "QA_TESTING"
  ).length;
  stats.QA_DEPLOYING = data.filter(
    (element) => element.status === "QA_DEPLOYING"
  ).length;
  stats.RELEASE_TO_PROD = data.filter(
    (element) => element.status === "RELEASE_TO_PROD"
  ).length;
  stats.FOR_TEST = data.filter(
    (element) => element.status === "FOR_TEST"
  ).length;
  stats.PROD_DEPLOYING = data.filter(
    (element) => element.status === "PROD_DEPLOYING"
  ).length;
  stats.DONE = data.filter((element) => element.status === "DONE").length;

  return stats;
};

class DataController {
  async listar(request: Request, response: Response) {
    const userId = response.locals.tokenData.id;
    const projectId = request.headers.projectid || "";
    const user = await Usuarios.query().select("*").where("id", userId).first();
    const { colab_id }: any = request.headers || "";

    let tasks;
    let stats;

    if (user.id_role === roles.ID_GESTOR) {
      if (userId && projectId) {
        tasks = await getData(projectId, userId);
        stats = await getStats(projectId, userId);

        return response.status(200).json({ stats, tasks });
      } else {
        return response.status(404).json({
          message: "Necessário informar projeto.",
        });
      }
    } else {
      if (userId && projectId) {
        if (colab_id) {
          tasks = await getData(projectId, colab_id);
          stats = await getStats(projectId, colab_id);
        } else {
          tasks = await getData(projectId);
          stats = await getStats(projectId);
        }

        return response.status(200).json({ stats, tasks });
      } else {
        return response.status(404).json({
          message: "Necessário informar projeto.",
        });
      }
    }
  }
}

export default DataController;
