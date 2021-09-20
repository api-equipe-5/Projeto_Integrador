import { Model } from "objection";
import connection from "../database/connection";
import { Role as RoleType } from "../types/Role";

Model.knex(connection);

interface Role extends RoleType {}

class Role extends Model {
  static get tableName() {
    return "role";
  }

  static get jsonSchema() {
    return {
      type: "object",

      properties: {
        id: { type: "string" },
        nome: { type: "string", minLength: 1, maxLength: 255 },
      },
    };
  }
}

export default Role;
