import * as Knex from "knex";
import { admin } from "../../../mocks/data/admin";
import Jira from "../../../mocks/data/jira";
import Trello from "../../../mocks/data/trello";
import roles from "../../constants/roles";
import generateHash from "../../helpers/generateHash";
import { removeDeplicated } from "../../helpers/RemoveDuplicated";
import Usuarios from "../../models/Usuarios";
import { usuario } from "../../types/Usuarios";
import { v4 as uuidv4 } from "uuid";

export async function seed(knex: Knex): Promise<void> {
  await knex("usuarios").del();

  let users: usuario[] = [];

  Jira.forEach((dado: any) => {
    let myUser: usuario = {
      id: "",
      imagem: "",
      nome: "",
      sobrenome: "",
      email: "",
      senha: "",
      id_role: "0",
    };

    myUser.id = dado.user.id;
    myUser.imagem = dado.user.avatar;
    myUser.nome = dado.user.first_name;
    myUser.sobrenome = dado.user.last_name;
    myUser.email = dado.user.email;
    myUser.senha = generateHash();

    users = [...users, myUser];
  });

  Trello.forEach((dado: any) => {
    let myUser: usuario = {
      id: "",
      imagem: "",
      nome: "",
      sobrenome: "",
      email: "",
      senha: "",
      id_role: "0",
    };

    myUser.id = dado.user._id;
    myUser.imagem = dado.user.avatar;
    myUser.nome = dado.user.userName;
    myUser.sobrenome = dado.user.userLastName;
    myUser.email = dado.user.userEmail;
    myUser.senha = generateHash();

    users = [...users, myUser];
  });

  const ceo: usuario = {
    id: uuidv4(),
    imagem: admin.imagem,
    nome: admin.nome,
    sobrenome: admin.sobrenome,
    email: admin.email,
    senha: generateHash(),
    id_role: roles.ID_CEO,
  };

  const totalUsers = users.concat(ceo);
  const finalUsers = await removeDeplicated(totalUsers);

  for (let i = 0; i < finalUsers.length; i++) {
    await Usuarios.query().insert(finalUsers[i]);
  }

  console.log(finalUsers);
}
