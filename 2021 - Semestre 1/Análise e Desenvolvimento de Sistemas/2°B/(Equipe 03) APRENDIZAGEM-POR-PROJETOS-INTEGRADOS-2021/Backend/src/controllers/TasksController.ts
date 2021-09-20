import { Request, Response } from "express";
import Tarefas from "../models/Tarefas";

class TasksController {
  async create(request: Request, response: Response) {}

  async read(request: Request, response: Response) {
    const { id } = request.params;
    const task = await Tarefas.query().select("*").where("id", id).first();

    return response.status(200).json(task);
  }

  async update(request: Request, response: Response) {
    const { status } = request.body;
    const { id } = request.params;

    await Tarefas.query().where("id", id).update({ status });
    const task = await Tarefas.query()
      .select("status", "descricao")
      .where("id", id)
      .first();

    return response.status(200).json({
      message: "Atualizado com sucesso",
      task,
    });
  }

  async delete(request: Request, response: Response) {
    const { id } = request.params;
    await Tarefas.query().delete().where("id", id);

    return response.status(200).json({
      message: "Deletado com sucesso",
    });
  }
}

export default TasksController;
