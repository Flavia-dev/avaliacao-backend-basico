CREATE DATABASE  IF NOT EXISTS `cidadao` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cidadao`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: cidadao
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `logradouros`
--

DROP TABLE IF EXISTS `logradouros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logradouros` (
  `Municipio` varchar(50) NOT NULL,
  `Estado` varchar(2) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logradouros`
--

LOCK TABLES `logradouros` WRITE;
/*!40000 ALTER TABLE `logradouros` DISABLE KEYS */;
INSERT INTO `logradouros` VALUES ('São Tomé das Letras','MG',32),('Aparecida','SP',33),('Manaus','AM',34),('Marechal Deodoro','AL',35),('Feira de Santana','BA',36),('Macapá','AP',37),('Uruguaiana','RS',38),('Araraquara','SP',39),('Parati','RJ',40),('Aparecida','SP',41),('Manaus','AM',42),('Aparecida','SP',43),('Manaus','AM',44);
/*!40000 ALTER TABLE `logradouros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoas`
--

DROP TABLE IF EXISTS `pessoas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoas` (
  `Nome` varchar(50) NOT NULL,
  `Idade` varchar(2) DEFAULT NULL,
  `id_logradouro` int DEFAULT NULL,
  KEY `id_logradouro` (`id_logradouro`),
  CONSTRAINT `pessoas_ibfk_1` FOREIGN KEY (`id_logradouro`) REFERENCES `logradouros` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoas`
--

LOCK TABLES `pessoas` WRITE;
/*!40000 ALTER TABLE `pessoas` DISABLE KEYS */;
INSERT INTO `pessoas` VALUES ('Antonio Carlos','43',32),('Cláudia Pereira','20',33),('José dos Santos','30',34),('Thomas Bloch','22',35),('Maria Aparecida','35',36),('Diego da Silva','29',37),('Valentina de Sá','28',38),('Leonardo Souza','30',39),('Miguel Pereira','33',40),('Cláudia Pereira','20',41),('José dos Santos','30',42),('Cláudia Pereira','20',43),('José dos Santos','30',44);
/*!40000 ALTER TABLE `pessoas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'cidadao'
--

--
-- Dumping routines for database 'cidadao'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-23 13:15:30
