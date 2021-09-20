import Knex from "knex";

export async function up(knex: Knex) {
  return knex.schema.createTable("projetos", (table) => {
    table.string("id").primary(); //código já vem da GSW
    table.string("status").notNullable();
    table.float("horas").notNullable();
  });
}

export async function down(knex: Knex) {
  return knex.schema.dropTable("projetos");
}
