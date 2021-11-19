-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema 01API
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema 01API
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `01API` DEFAULT CHARACTER SET utf8 ;
USE `01API` ;

-- -----------------------------------------------------
-- Table `01API`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `01API`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `01API`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nomeUsuario` VARCHAR(45) NOT NULL,
  `emailUsuario` VARCHAR(45) NOT NULL,
  `senhaUsuario` VARCHAR(45) NOT NULL,
  `Professor` TINYINT NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `01API`.`Curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `01API`.`Curso` ;

CREATE TABLE IF NOT EXISTS `01API`.`Curso` (
  `idCurso` INT NOT NULL AUTO_INCREMENT,
  `nomeCurso` VARCHAR(45) NOT NULL,
  `idUsuario_fk` INT NOT NULL,
  PRIMARY KEY (`idCurso`),
  INDEX `fk_Curso_Usuario_idx` (`idUsuario_fk` ASC) ,
  CONSTRAINT `fk_Curso_Usuario`
    FOREIGN KEY (`idUsuario_fk`)
    REFERENCES `01API`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `01API`.`Aula`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `01API`.`Aula` ;

CREATE TABLE IF NOT EXISTS `01API`.`Aula` (
  `idAula` INT NOT NULL AUTO_INCREMENT,
  `nomeAula` VARCHAR(45) NOT NULL,
  `conteudo` VARCHAR(45) NOT NULL,
  `idCurso_fk` INT NOT NULL,
  PRIMARY KEY (`idAula`),
  INDEX `fk_Aula_Curso1_idx` (`idCurso_fk` ASC) ,
  CONSTRAINT `fk_Aula_Curso1`
    FOREIGN KEY (`idCurso_fk`)
    REFERENCES `01API`.`Curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `01API`.`Matriculas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `01API`.`Matriculas` ;

CREATE TABLE IF NOT EXISTS `01API`.`Matriculas` (
  `idMatriculas` INT NOT NULL AUTO_INCREMENT,
  `idCurso_fk` INT NOT NULL,
  `idUsuario_fk` INT NOT NULL,
  PRIMARY KEY (`idMatriculas`),
  INDEX `fk_Matriculas_Curso1_idx` (`idCurso_fk` ASC) ,
  INDEX `fk_Matriculas_Usuario1_idx` (`idUsuario_fk` ASC) ,
  CONSTRAINT `fk_Matriculas_Curso1`
    FOREIGN KEY (`idCurso_fk`)
    REFERENCES `01API`.`Curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Matriculas_Usuario1`
    FOREIGN KEY (`idUsuario_fk`)
    REFERENCES `01API`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `01API`.`Avaliacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `01API`.`Avaliacao` ;

CREATE TABLE IF NOT EXISTS `01API`.`Avaliacao` (
  `idAvaliacao` INT NOT NULL AUTO_INCREMENT,
  `Nota` INT NOT NULL,
  `idUsuario_fk` INT NOT NULL,
  `idAula_fk` INT NOT NULL,
  PRIMARY KEY (`idAvaliacao`),
  INDEX `fk_Avaliacao_Usuario1_idx` (`idUsuario_fk` ASC) ,
  INDEX `fk_Avaliacao_Aula1_idx` (`idAula_fk` ASC) ,
  CONSTRAINT `fk_Avaliacao_Usuario1`
    FOREIGN KEY (`idUsuario_fk`)
    REFERENCES `01API`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Avaliacao_Aula1`
    FOREIGN KEY (`idAula_fk`)
    REFERENCES `01API`.`Aula` (`idAula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
