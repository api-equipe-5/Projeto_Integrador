import { Request, Response } from "express";
import roles from "../constants/roles";
import Tarefas from "../models/Tarefas";
import Usuarios from "../models/Usuarios";
import { usuario } from "../types/Usuarios";

class UsersController {
  async index(request: Request, response: Response) {
    const users: usuario[] = await Usuarios.query().select("*");

    users.forEach((user: any) => {
      delete user.senha;
    });

    const filteredUsers = users.filter((user) => user.id_role !== roles.ID_CEO);

    return response.send({ filteredUsers });
  }

  async listHoursByUser(request: Request, response: Response) {
    const users: usuario[] = await Usuarios.query().select("*");
    users.forEach((user: any) => {
      delete user.senha;
    });

    const filteredUsers = users.filter((user) => user.id_role !== roles.ID_CEO);

    let hours: any[] = [];

    for (let i = 0; i < filteredUsers.length; i++) {
      const hour: any = await Tarefas.query()
        .sum("horas")
        .where("id_usuario", filteredUsers[i].id);

      const joinUserHour = {
        ...hour[0],
        user: filteredUsers[i],
      };

      hours = [...hours, joinUserHour];
    }

    return response.json(hours);
  }
}

export default UsersController;
