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
-- Table structure for table `doações`
--

DROP TABLE IF EXISTS `doações`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doações` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  `descrição` text,
  `comprovante` longblob NOT NULL,
  `anonimo` varchar(3) DEFAULT 'Não',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doações`
--

LOCK TABLES `doações` WRITE;
/*!40000 ALTER TABLE `doações` DISABLE KEYS */;
/*!40000 ALTER TABLE `doações` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participantes`
--

LOCK TABLES `participantes` WRITE;
/*!40000 ALTER TABLE `participantes` DISABLE KEYS */;
INSERT INTO `participantes` VALUES (1,'Felipe Santos','0000-00-00','Rogério Santos','0000-00-00','R. Machado Campos, 432','rogsantos@outlook.com','','','','45665789102'),(2,'kslajldskj','0000-00-00','TAsjskjklsdjl','0000-00-00','dskfljdkljsfldkf','skajdkdsal@hotmail.com','','','','213456587896');
/*!40000 ALTER TABLE `participantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projetos`
--

DROP TABLE IF EXISTS `projetos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projetos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `objetivos` text NOT NULL,
  `diferencial` text NOT NULL,
  `características` text NOT NULL,
  `envolvidos` text NOT NULL,
  `anexo` longblob,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projetos`
--

LOCK TABLES `projetos` WRITE;
/*!40000 ALTER TABLE `projetos` DISABLE KEYS */;
INSERT INTO `projetos` VALUES (1,'abc','def','ghi','jhl',_binary 'ADM III - prof. Geraldo.pdf');
/*!40000 ALTER TABLE `projetos` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voluntário de apoio`
--

LOCK TABLES `voluntário de apoio` WRITE;
/*!40000 ALTER TABLE `voluntário de apoio` DISABLE KEYS */;
INSERT INTO `voluntário de apoio` VALUES (1,'Fernanda C. Silva','0000-00-00','58967842310','R. Lourenço Paes, 337','fernandasilva@hotmail.com','',NULL,'Empatia, responsabilidade, proatividade e motivação para ajudar pessoas.','Pretendo ajudar o maior número de pessoas possível.','10:00 até 18:00');
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
  `experiência` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `horários disponíveis` varchar(10) NOT NULL,
  `características` text NOT NULL,
  `objetivos` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voluntário específico`
--

LOCK TABLES `voluntário específico` WRITE;
/*!40000 ALTER TABLE `voluntário específico` DISABLE KEYS */;
INSERT INTO `voluntário específico` VALUES (1,'Marcela Rodrigues','0000-00-00','54678912352','R. Bernardo Luís, 839','marcrodrigues@hotmail.com','',_binary 'Currículo.pdf',_binary 'Certificado.pdf','Fiz licenciatur','9:00 até 1','Sou muito proativa e busco sempre dar o melhor aos meus alunos.','Minha meta é poder ajudar cada vez mais crianças.');
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

-- Dump completed on 2021-05-12 11:18:44
