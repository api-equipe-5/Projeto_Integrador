import { Model } from "objection";
import connection from "../database/connection";
import { projeto as ProjetosType } from "../types/Projeto";
import Usuarios from "./Usuarios";
import { v4 as uuidv4 } from "uuid";

Model.knex(connection);

interface Projetos extends ProjetosType {}

class Projetos extends Model {
  static get tableName() {
    return "projetos";
  }

  $beforeInsert() {
    this.id = uuidv4();
  }

  static get idColumn() {
    return "id";
  }

  static get jsonSchema() {
    return {
      type: "object",

      properties: {
        id: { type: "string" },
        projetoNome: { type: "string", minLength: 1, maxLength: 255 },
      },
    };
  }
}

export default Projetos;
