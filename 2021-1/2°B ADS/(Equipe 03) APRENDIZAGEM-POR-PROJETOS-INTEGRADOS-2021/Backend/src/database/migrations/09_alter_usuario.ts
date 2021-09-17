import Knex from "knex";

export async function up(knex: Knex) {
  return knex.schema.alterTable("usuarios", (table) => {
    table.string("id_role").defaultTo(0);
    table.foreign("id_role").references("id").inTable("role");
  });
}

export async function down(knex: Knex) {
  return knex.schema.dropTable("usuarios");
}
