import * as Knex from "knex";

export async function seed(knex: Knex): Promise<void> {
  await knex("role").del();
  await knex("role").insert([
    { id: "0", nome: "Gestor" },
    { id: "1", nome: "CEO" },
  ]);
}
