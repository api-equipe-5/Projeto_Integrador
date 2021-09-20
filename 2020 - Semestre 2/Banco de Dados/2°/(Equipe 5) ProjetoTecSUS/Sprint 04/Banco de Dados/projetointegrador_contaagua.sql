-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: projetointegrador
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `contaagua`
--

DROP TABLE IF EXISTS `contaagua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contaagua` (
  `ContaAguaRGI` int NOT NULL,
  `ContaAguaNConta` int NOT NULL,
  `ContaAguaGrupo` int NOT NULL,
  `ContaAguaMesRef` varchar(15) NOT NULL,
  `ContaAguaTipoLigacao` varchar(30) NOT NULL,
  `ContaAguaTipoFaturamento` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ContaAguaConsumo` int DEFAULT NULL,
  `ContaAguaDataLeituraAtual` varchar(30) NOT NULL,
  `ContaAguaLeituraAtual` varchar(15) NOT NULL,
  `ContaAguaDataLeituraAnterior` varchar(30) NOT NULL,
  `ContaAguaLeituraAnterior` varchar(15) NOT NULL,
  `ContaAguaObservacao` varchar(100) NOT NULL,
  `ContaAguaValorAgua` varchar(15) NOT NULL,
  `ContaAguaValorEsgoto` varchar(15) NOT NULL,
  `ContaAguaValorTotal` varchar(15) NOT NULL,
  PRIMARY KEY (`ContaAguaRGI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contaagua`
--

LOCK TABLES `contaagua` WRITE;
/*!40000 ALTER TABLE `contaagua` DISABLE KEYS */;
INSERT INTO `contaagua` VALUES (4040,7070,40,'40','40','04',4,'04','04','04','04','40','04','04','04'),(20002,20,220,'2002','020','20',20,'20','20','20','2','20','02','0','20'),(44552,20,20,'20','20','20',20,'20','02','02','02','20','02','02','20'),(77444,502554,30,'Janeiro','Casa','Pago',50,'20/08','25','20/07','25','S/A','200','50','250'),(888080,870500,20,'Março','Casa','Pago',57,'20/08','25','20/07','25','S/A','200','50','250');
/*!40000 ALTER TABLE `contaagua` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-29  3:14:38
