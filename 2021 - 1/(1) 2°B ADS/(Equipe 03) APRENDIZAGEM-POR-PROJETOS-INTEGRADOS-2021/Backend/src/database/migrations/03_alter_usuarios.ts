import Knex from "knex";

export async function up(knex: Knex) {
  return knex.schema.alterTable("usuarios", (table) => {
    table.string("senha");
  });
}

export async function down(knex: Knex) {
  return knex.schema.dropTable("usuarios");
}
