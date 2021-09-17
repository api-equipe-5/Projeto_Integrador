import { Request, Response } from "express";
import roles from "../constants/roles";
import Projetos from "../models/Projetos";
import Tarefas from "../models/Tarefas";
import Usuarios from "../models/Usuarios";
import { projeto } from "../types/Projeto";
import { usuario } from "../types/Usuarios";

class ProjectsController {
  async show(request: Request, response: Response) {
    const { id } = request.params;
    const project = await Projetos.query().where("id", id).first();

    return response.status(200).send(project);
  }

  async list(request: Request, response: Response) {
    const projects = await Projetos.query().select("*");

    return response.send(projects);
  }

  async listHoursByProject(request: Request, response: Response) {
    const project: projeto[] = await Projetos.query().select("*");

    let hours: any[] = [];

    for (let i = 0; i < project.length; i++) {
      const hour: any = await Tarefas.query()
        .sum("horas")
        .where("id_projeto", project[i].id);

      const joinHourProject = {
        ...hour[0],
        project: project[i],
      };

      hours = [...hours, joinHourProject];
    }

    return response.json(hours);
  }
}

export default ProjectsController;
