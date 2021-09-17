import Knex from "knex";

export async function up(knex: Knex) {
  return knex.schema.createTable("tarefas", (table) => {
    table.string("id").primary(); //código já vem da GSW
    table.string("status").notNullable();
    table.string("id_usuario");
    table.foreign("id_usuario").references("id").inTable("usuarios");
    table.float("horas").notNullable();
    table.string("dataInicio");
    table.boolean("concluido");
    table.string("id_projeto");
    table.foreign("id_projeto").references("id").inTable("projetos");
    table.string("descricao");
  });
}

export async function down(knex: Knex) {
  return knex.schema.dropTable("tarefas");
}
