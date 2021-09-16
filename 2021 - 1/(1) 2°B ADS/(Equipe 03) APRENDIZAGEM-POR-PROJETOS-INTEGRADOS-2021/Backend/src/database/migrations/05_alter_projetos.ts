import Knex from "knex";

export async function up(knex: Knex) {
  return knex.schema.alterTable("projetos", (table) => {
    table.dropColumn("dataInicio");
    table.dropColumn("concluido");
    table.dropColumn("descricao");
    table.dropColumn("horas");
    table.dropColumn("status");
  });
}

export async function down(knex: Knex) {
  return knex.schema.dropTable("projetos");
}
