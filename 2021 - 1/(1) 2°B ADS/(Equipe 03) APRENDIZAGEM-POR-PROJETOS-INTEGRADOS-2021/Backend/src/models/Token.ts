import { Model } from "objection";
import connection from "../database/connection";
import { token as TokenType } from "../types/Token";

Model.knex(connection);

interface Token extends TokenType {}

class Token extends Model {
  static get tableName() {
    return "token";
  }

  static get jsonSchema() {
    return {
      type: "object",

      properties: {
        id: { type: "string" },
        token: { type: "string", minLength: 1, maxLength: 255 },
        id_usuario: { type: "string", minLength: 1, maxLength: 255 },
      },
    };
  }
}

export default Token;
