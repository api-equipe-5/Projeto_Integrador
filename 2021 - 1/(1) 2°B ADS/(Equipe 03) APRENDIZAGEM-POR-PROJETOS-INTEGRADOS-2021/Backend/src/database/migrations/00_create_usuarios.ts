import Knex from "knex";

export async function up(knex: Knex) {
  return knex.schema.createTable("usuarios", (table) => {
    table.string("id").primary(); //código já vem da GSW
    table.string("imagem").notNullable();
    table.string("nome").notNullable();
    table.string("sobrenome").notNullable();
    table.string("email").notNullable();
  });
}

export async function down(knex: Knex) {
  return knex.schema.dropTable("usuarios");
}
