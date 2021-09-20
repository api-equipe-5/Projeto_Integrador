CREATE DATABASE  IF NOT EXISTS `ong` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `ong`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: ong
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `participantes`
--

DROP TABLE IF EXISTS `participantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participantes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `aluno` varchar(45) NOT NULL,
  `data de nascimento` date DEFAULT NULL,
  `responsável` varchar(45) NOT NULL,
  `data de nascimento responsável` date DEFAULT NULL,
  `endereço` varchar(50) NOT NULL,
  `email` varchar(40) NOT NULL,
  `telefone` varchar(12) DEFAULT NULL,
  `turma` enum('1','2','3','4','5','6','7') NOT NULL,
  `período` enum('manhã','tarde') DEFAULT NULL,
  `cpf` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `participantes`
--

LOCK TABLES `participantes` WRITE;
/*!40000 ALTER TABLE `participantes` DISABLE KEYS */;
/*!40000 ALTER TABLE `participantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voluntário de apoio`
--

DROP TABLE IF EXISTS `voluntário de apoio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voluntário de apoio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `data de nascimento` date DEFAULT NULL,
  `cpf` varchar(15) NOT NULL,
  `endereço` varchar(50) NOT NULL,
  `email` varchar(40) NOT NULL,
  `telefone` varchar(12) DEFAULT NULL,
  `período` set('manhã','tarde','manhã e tarde') DEFAULT NULL,
  `características` text NOT NULL,
  `objetivos` text NOT NULL,
  `horários disponíveis` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `voluntário de apoio`
--

LOCK TABLES `voluntário de apoio` WRITE;
/*!40000 ALTER TABLE `voluntário de apoio` DISABLE KEYS */;
/*!40000 ALTER TABLE `voluntário de apoio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voluntário específico`
--

DROP TABLE IF EXISTS `voluntário específico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voluntário específico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `data de nascimento` date DEFAULT NULL,
  `cpf` varchar(15) NOT NULL,
  `endereço` varchar(50) NOT NULL,
  `email` varchar(40) NOT NULL,
  `telefone` varchar(12) DEFAULT NULL,
  `currículo` longblob NOT NULL,
  `certificado` longblob,
  `experiência` varchar(15) NOT NULL,
  `horários disponíveis` varchar(10) NOT NULL,
  `características` text NOT NULL,
  `objetivos` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
--
-- Dumping data for table `voluntário específico`
--

LOCK TABLES `voluntário específico` WRITE;
/*!40000 ALTER TABLE `voluntário específico` DISABLE KEYS */;
/*!40000 ALTER TABLE `voluntário específico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-15 11:59:29
