import Knex from "knex";
import Jira from "../../../mocks/data/jira";
import Trello from "../../../mocks/data/trello";
import { removeDeplicatedProject } from "../../helpers/RemoveDuplicatedProject";
import Projetos from "../../models/Projetos";
import { projeto } from "../../types/Projeto";

export async function seed(knex: Knex): Promise<void> {
  await knex("projetos").del();
  let projects: any[] = [];

  Jira.forEach((data: any) => {
    let project: { projetoNome: string } = { projetoNome: "" };

    project.projetoNome = data.project;

    projects = [...projects, project];
  });

  Trello.forEach((data: any) => {
    let project: { projetoNome: string } = { projetoNome: "" };

    project.projetoNome = data.project;

    projects = [...projects, project];
  });

  const finalProjects = await removeDeplicatedProject(projects);

  let projectsArray: projeto[] = [];
  for (let i = 0; i < finalProjects.length; i++) {
    projectsArray = [...projectsArray, finalProjects[i]];
    await Projetos.query().insert(projectsArray[i]);
  }
}
