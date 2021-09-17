import Knex from "knex";

export async function up(knex: Knex) {
  return knex.schema.alterTable("projetos", (table) => {
    table.dropColumn("id_usuario");
  });
}

export async function down(knex: Knex) {
  return knex.schema.dropTable("projetos");
}
