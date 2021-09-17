import Knex from "knex";
import Jira from "../../../mocks/data/jira";
import Trello from "../../../mocks/data/trello";
import Projetos from "../../models/Projetos";
import Tarefas from "../../models/Tarefas";
import { tarefa } from "../../types/Tarefas";

export async function seed(knex: Knex): Promise<void> {
  await knex("tarefas").del();
  const projetos = await Projetos.query().select("*");

  let tasks: tarefa[] = [];

  Jira.forEach((task) => {
    let completeTask: tarefa = {
      id: "",
      status: "",
      horas: "",
      id_usuario: "",
      dataInicio: "",
      id_projeto: "",
      concluido: false,
      descricao: "",
    };

    projetos.forEach((project) => {
      task.project === project.projetoNome
        ? ((completeTask.id_usuario = task.user.id),
          (completeTask.id = task.id),
          (completeTask.concluido = task.finished),
          (completeTask.id_projeto = project.id),
          (completeTask.descricao = task.cardDescription),
          (completeTask.status = task.status),
          (completeTask.dataInicio = task.startedAt),
          (completeTask.horas = task.amountHours || 0))
        : null;
    });

    tasks = [...tasks, completeTask];
  });

  Trello.forEach((task) => {
    let completeTask: tarefa = {
      id: "",
      status: "",
      horas: "",
      id_usuario: "",
      dataInicio: "",
      id_projeto: "",
      concluido: false,
      descricao: "",
    };

    projetos.forEach((project) => {
      task.project === project.projetoNome
        ? ((completeTask.id_usuario = task.user._id),
          (completeTask.id = task._id),
          (completeTask.concluido = task.isFinished),
          (completeTask.id_projeto = project.id),
          (completeTask.descricao = task.cardDescription),
          (completeTask.status = task.status),
          (completeTask.dataInicio = task.startedAt),
          (completeTask.horas = task.hours || 0))
        : null;
    });

    tasks = [...tasks, completeTask];
  });

  for (let i = 0; i < tasks.length; i++) {
    await Tarefas.query().insert(tasks[i]);
  }
}
