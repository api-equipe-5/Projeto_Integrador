DROP TABLE IF EXISTS "Curso";

CREATE TABLE IF NOT EXISTS "Curso" (
  "idCurso" SERIAL PRIMARY KEY,
  "nomeCurso" VARCHAR(45) NOT NULL,
  "idUsuario_fk" INT NOT NULL,
  CONSTRAINT "fk_Curso_Usuario"
    FOREIGN KEY ("idUsuario_fk")
    REFERENCES "user_account" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

DROP TABLE IF EXISTS "Matriculas";

CREATE TABLE IF NOT EXISTS "Matriculas" (
  "idMatriculas" SERIAL PRIMARY KEY,
  "idCurso_fk" INT NOT NULL,
  "idUsuario_fk" INT NOT NULL,
  CONSTRAINT "fk_Matriculas_Curso1"
    FOREIGN KEY ("idCurso_fk")
    REFERENCES "Curso" ("idCurso")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_Matriculas_Usuario1"
    FOREIGN KEY ("idUsuario_fk")
    REFERENCES "user_account" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);