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
-- Table structure for table `contaluz`
--

DROP TABLE IF EXISTS `contaluz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contaluz` (
  `ContaLuzID` int NOT NULL,
  `ContaLuzValorTotal` varchar(30) NOT NULL,
  `ContaLuzDataVencimento` varchar(30) NOT NULL,
  `ContaLuzMes` varchar(30) NOT NULL,
  `ContaLuzEmissao` varchar(30) NOT NULL,
  `ContaLuzAnterior` varchar(30) NOT NULL,
  `ContaLuzAtual` varchar(30) NOT NULL,
  `ContaLuzDiasFaturamento` int NOT NULL,
  `ContaLuzStatus` varchar(30) NOT NULL,
  `ContaLuzPrevisaoProximaLuz` varchar(30) NOT NULL,
  `ContaLuzValorFornecedor` varchar(30) DEFAULT NULL,
  `ContaLuzDataFaturamento` varchar(30) NOT NULL,
  `ContaLuzQtdkWh` varchar(30) NOT NULL,
  `ContaLuzAviso` varchar(30) NOT NULL,
  `ContaLuzFiscalMulta` varchar(30) NOT NULL,
  `ContaLuzFiscalJurosMulta` varchar(30) NOT NULL,
  `ContaLuzFiscalTipoFornecimento` varchar(30) NOT NULL,
  `ContaLuzFiscalModalidadeTarifaria` varchar(30) NOT NULL,
  PRIMARY KEY (`ContaLuzID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contaluz`
--

LOCK TABLES `contaluz` WRITE;
/*!40000 ALTER TABLE `contaluz` DISABLE KEYS */;
INSERT INTO `contaluz` VALUES (70,'70','70','70','70','70','70',70,'70','70','70','70','70','70','70','70','70','70'),(4555,'80','5','5','5','5','5',5,'5','5',NULL,'5','5','5','5','5','5','5'),(8080,'900','80','70','70','70','70',70,'70','050','0','50','03','5555','80','80','5','5'),(44404,'200','10/Mar','Março','01/Mar','31','10',31,'Ativo','01/Abr','09','Março','21','S/A','S/A','S/A','Bivolt','Residencial'),(70007,'200','05/Jan','Janeiro','01/Jan','01/Dez','29/Jan',31,'Ativo','01/Fev','200','30/Dez','31','S/A','S/A','S/A','Residencial','Convencional');
/*!40000 ALTER TABLE `contaluz` ENABLE KEYS */;
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
