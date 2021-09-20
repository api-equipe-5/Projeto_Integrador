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
/*!50503 SET NAMES utf8mb4 */;
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
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participantes`
--

LOCK TABLES `participantes` WRITE;
/*!40000 ALTER TABLE `participantes` DISABLE KEYS */;
INSERT INTO `participantes` VALUES (1,'Lara Oliveira Borges',NULL,'Fátima Oliveira',NULL,'Rua 8, 550 - Bosque dos Ypês','oliveira.fatima@gmail.com',NULL,'3',NULL,'12343214589'),(2,'Luisa Batista Campos',NULL,'Carlos Batista Filho',NULL,'Rua Maria Eugênia Gusmão, 338 - Jd.Ismênia','carlosbfilho@gmail.com',NULL,'3',NULL,'55549277602'),(3,'Gabriel da Silva',NULL,'Rafael da Silva',NULL,'Av. dos Evangélicos, 321 - Campo dos Alemães','rafaelegabriel@gmail.com',NULL,'2',NULL,'11122255578');
/*!40000 ALTER TABLE `participantes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-27 20:51:26
