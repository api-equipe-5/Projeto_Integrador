-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: projeto_integrador
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `desenvolvedores`
--

DROP TABLE IF EXISTS `desenvolvedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `desenvolvedores` (
  `desenvolvedor` varchar(50) NOT NULL,
  `Status` varchar(45) NOT NULL,
  `Especialidade` varchar(45) NOT NULL,
  PRIMARY KEY (`desenvolvedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `desenvolvedores`
--

LOCK TABLES `desenvolvedores` WRITE;
/*!40000 ALTER TABLE `desenvolvedores` DISABLE KEYS */;
INSERT INTO `desenvolvedores` VALUES ('Felipe','Disponível','Front End'),('Gabriel','Indisponível','Full Stack'),('Nathan','Disponível','Back End');
/*!40000 ALTER TABLE `desenvolvedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gantt_links`
--

DROP TABLE IF EXISTS `gantt_links`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gantt_links` (
  `id` int NOT NULL AUTO_INCREMENT,
  `source` int NOT NULL,
  `target` int NOT NULL,
  `type` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gantt_links`
--

LOCK TABLES `gantt_links` WRITE;
/*!40000 ALTER TABLE `gantt_links` DISABLE KEYS */;
/*!40000 ALTER TABLE `gantt_links` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projetos_e_tarefas`
--

DROP TABLE IF EXISTS `projetos_e_tarefas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projetos_e_tarefas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `dependências` varchar(255) DEFAULT NULL,
  `desenvolvedor` varchar(50) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `progresso` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `desenvolvedor_idx` (`desenvolvedor`),
  CONSTRAINT `desenvolvedor` FOREIGN KEY (`desenvolvedor`) REFERENCES `desenvolvedores` (`desenvolvedor`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projetos_e_tarefas`
--

LOCK TABLES `projetos_e_tarefas` WRITE;
/*!40000 ALTER TABLE `projetos_e_tarefas` DISABLE KEYS */;
INSERT INTO `projetos_e_tarefas` VALUES (1,'Projeto Cliente','Sem Dependência','Felipe','2020-07-13 01:00:00','2020-07-13 17:00:00',60),(2,'Definir Tecnologias','Projeto Cliente','Felipe','2020-07-13 01:00:00','2020-07-13 09:00:00',50),(3,'Montar MER','Projeto Cliente','Felipe','2020-07-13 02:00:00','2020-07-13 09:00:00',100),(4,'Montar DER','Projeto Cliente','Gabriel','2020-07-13 03:00:00','2020-07-13 09:00:00',100),(5,'Reunião','Projeto Cliente','Gabriel','2020-07-13 16:00:00','2020-07-13 17:00:00',0),(6,'Web Bot','Sem Dependência','Gabriel','2020-07-12 01:00:00','2020-07-13 11:00:00',90),(7,'Definir Tecnologias','WebBot','Nathan','2020-07-13 01:00:00','2020-07-13 09:00:00',100),(8,'Montar MER','WebBot','Nathan','2020-07-12 01:00:00','2020-07-13 11:00:00',100),(9,'Montar DER','WebBot','Nathan','2020-07-13 01:00:00','2020-07-13 10:00:00',100);
/*!40000 ALTER TABLE `projetos_e_tarefas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'projeto_integrador'
--

--
-- Dumping routines for database 'projeto_integrador'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-12 20:35:28
