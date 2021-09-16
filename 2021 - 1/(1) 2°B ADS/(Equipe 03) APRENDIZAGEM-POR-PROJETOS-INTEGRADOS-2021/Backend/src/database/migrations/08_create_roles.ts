import Knex from "knex";

export async function up(knex: Knex) {
  return knex.schema.createTable("role", (table) => {
    table.string("id").primary();
    table.string("nome").notNullable();
  });
}

export async function down(knex: Knex) {
  return knex.schema.dropTable("role");
}
