import { Request, Response } from "express";
import generateToken from "../helpers/generateToken";
import Usuarios from "../models//Usuarios";
import Token from "../models/Token";
import bcrypt from "bcrypt";

class Auth {
  async signIn(req: Request, res: Response) {
    try {
      const { email, senha } = req.body;

      const userData = await Usuarios.query().where("email", email).first();

      if (!userData) {
        return res.status(404).json({
          message: "Email não encontrado!",
        });
      }

      bcrypt.compare(senha, userData.senha).then(async (result) => {
        if (result) {
          const token = await generateToken({ id: userData.id });

          const existentToken = await Token.query()
            .where("id_usuario", userData.id)
            .first();

          if (existentToken) {
            await Token.query().where("id_usuario", userData.id).update({
              token,
            });
          } else {
            await Token.query().insert({
              token,
              id_usuario: userData.id,
            });
          }

          userData.senha = "";

          return res.status(200).json({
            user: userData,
            token,
          });
        } else {
          return res.status(401).json({
            message: "Não autorizado!",
          });
        }
      });
    } catch (error) {
      return res.status(500).json({
        message: "Ocorreu um erro!",
      });
    }
  }
}

export default Auth;
