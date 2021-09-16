import { Model } from "objection";
import connection from "../database/connection";
import { tarefa as TarefasType } from "../types/Tarefas";
import Usuarios from "./Usuarios";
import Projetos from "./Projetos";

Model.knex(connection);

interface Tarefas extends TarefasType {}

class Tarefas extends Model {
  static get tableName() {
    return "tarefas";
  }

  static get idColumn() {
    return "id";
  }

  static get jsonSchema() {
    return {
      type: "object",

      properties: {
        id: { type: "string" },
        status: { type: "string", minLength: 1, maxLength: 255 },
        horas: { type: "float", minLength: 1, maxLength: 255 },
        id_usuario: { type: "string", minLength: 1, maxLength: 255 },
        id_projeto: { type: "string", minLength: 1, maxLength: 255 },
        dataInicio: { type: "string", minLength: 1, maxLength: 255 },
        concluido: { type: "boolean" },
        descricao: { type: "string", minLength: 1, maxLength: 255 },
      },
    };
  }

  static relationMappings = {
    users: {
      relation: Model.HasOneRelation,
      modelClass: Usuarios,
      join: {
        from: "projetos.id_usuario",
        to: "usuarios.id",
      },
    },
    projects: {
      relation: Model.HasOneRelation,
      modelClass: Projetos,
      join: {
        from: "projetos.id_projeto",
        to: "projetos.id",
      },
    },
  };
}

export default Tarefas;
