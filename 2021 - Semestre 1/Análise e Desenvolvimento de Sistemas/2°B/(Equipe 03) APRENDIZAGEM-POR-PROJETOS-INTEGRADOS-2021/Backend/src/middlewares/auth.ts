import jwt from "jsonwebtoken";
import { Request, Response, NextFunction } from "express";

const auth = (req: Request, res: Response, next: NextFunction) => {
  const token = req.headers.authorization?.split(" ")[1] || "";
  const decodedToken = jwt.decode(token);

  if (decodedToken) {
    res.locals.tokenData = decodedToken;
    next();
  } else {
    res.status(401).send("Não autorizado!");
  }
};

export default auth;
