import Knex from "knex";

export async function up(knex: Knex) {
  return knex.schema.alterTable("projetos", (table) => {
    table.string("id_usuario");
    table.foreign("id_usuario").references("id").inTable("usuarios");
    table.string("dataInicio");
    table.string("projetoNome");
    table.boolean("concluido");
    table.string("descricao");
  });
}

export async function down(knex: Knex) {
  return knex.schema.dropTable("projetos");
}
