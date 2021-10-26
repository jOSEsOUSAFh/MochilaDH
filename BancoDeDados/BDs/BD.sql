CREATE DATABASE  IF NOT EXISTS `universoleitura` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `universoleitura`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: universoleitura
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `associados`
--

DROP TABLE IF EXISTS `associados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `associados` (
  `cod_ID` int NOT NULL AUTO_INCREMENT,
  `rg` char(7) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `sobre_nome` varchar(50) DEFAULT NULL,
  `endereço` varchar(50) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `estado` char(2) DEFAULT NULL,
  PRIMARY KEY (`cod_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `associados`
--

LOCK TABLES `associados` WRITE;
/*!40000 ALTER TABLE `associados` DISABLE KEYS */;
INSERT INTO `associados` VALUES (1,'1233215','José Almir','SOUSA','cajazeiras','Salvador','BA');
/*!40000 ALTER TABLE `associados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autores`
--

DROP TABLE IF EXISTS `autores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autores` (
  `codAutor` int NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `sobre_nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codAutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autores`
--

LOCK TABLES `autores` WRITE;
/*!40000 ALTER TABLE `autores` DISABLE KEYS */;
/*!40000 ALTER TABLE `autores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editoras`
--

DROP TABLE IF EXISTS `editoras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editoras` (
  `codLivros` int NOT NULL,
  `razão_social` varchar(100) DEFAULT NULL,
  `telefone` char(11) DEFAULT NULL,
  PRIMARY KEY (`codLivros`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editoras`
--

LOCK TABLES `editoras` WRITE;
/*!40000 ALTER TABLE `editoras` DISABLE KEYS */;
INSERT INTO `editoras` VALUES (11,'DaEsqueina','75997200967'),(12,'FUTURA','71997200967'),(13,'Dahora','75997200967'),(15,'SARAIVA','75997200967'),(16,'CULTURA','75997200967');
/*!40000 ALTER TABLE `editoras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emprestimos`
--

DROP TABLE IF EXISTS `emprestimos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emprestimos` (
  `codigo` int NOT NULL,
  `codAssoc` int DEFAULT NULL,
  `datas` date DEFAULT NULL,
  `prazo_devolucao` date DEFAULT NULL,
  `data_devolucao` date DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_emprestimos` (`codAssoc`),
  CONSTRAINT `FK_emprestimos` FOREIGN KEY (`codAssoc`) REFERENCES `associados` (`cod_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emprestimos`
--

LOCK TABLES `emprestimos` WRITE;
/*!40000 ALTER TABLE `emprestimos` DISABLE KEYS */;
/*!40000 ALTER TABLE `emprestimos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emprestimos_exemplares`
--

DROP TABLE IF EXISTS `emprestimos_exemplares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emprestimos_exemplares` (
  `codigo` int NOT NULL,
  `cod_emprestimo` int DEFAULT NULL,
  `cod_exemplar` int DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_codEmprestimo` (`cod_emprestimo`),
  KEY `FK_exemplares` (`cod_exemplar`),
  CONSTRAINT `FK_codEmprestimo` FOREIGN KEY (`cod_emprestimo`) REFERENCES `emprestimos` (`codigo`),
  CONSTRAINT `FK_exemplares` FOREIGN KEY (`cod_exemplar`) REFERENCES `exemplares` (`codigoEX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emprestimos_exemplares`
--

LOCK TABLES `emprestimos_exemplares` WRITE;
/*!40000 ALTER TABLE `emprestimos_exemplares` DISABLE KEYS */;
/*!40000 ALTER TABLE `emprestimos_exemplares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exemplares`
--

DROP TABLE IF EXISTS `exemplares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exemplares` (
  `codigoEX` int NOT NULL,
  `cod_livro` int DEFAULT NULL,
  `sinistro` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`codigoEX`),
  CONSTRAINT `FK_codLivro` FOREIGN KEY (`codigoEX`) REFERENCES `livros` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exemplares`
--

LOCK TABLES `exemplares` WRITE;
/*!40000 ALTER TABLE `exemplares` DISABLE KEYS */;
/*!40000 ALTER TABLE `exemplares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livros`
--

DROP TABLE IF EXISTS `livros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `livros` (
  `cod` int NOT NULL,
  `cod_ISBN` varchar(13) DEFAULT NULL,
  `titulo` varchar(50) DEFAULT NULL,
  `ano_criacao` date DEFAULT NULL,
  `cod_autor` int DEFAULT NULL,
  `publicacao` date DEFAULT NULL,
  `cod_editora` int DEFAULT NULL,
  PRIMARY KEY (`cod`),
  KEY `FK_codAutor` (`cod_autor`),
  KEY `FK_codEditora` (`cod_editora`),
  CONSTRAINT `FK_codAutor` FOREIGN KEY (`cod_autor`) REFERENCES `autores` (`codAutor`),
  CONSTRAINT `FK_codEditora` FOREIGN KEY (`cod_editora`) REFERENCES `editoras` (`codLivros`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livros`
--

LOCK TABLES `livros` WRITE;
/*!40000 ALTER TABLE `livros` DISABLE KEYS */;
/*!40000 ALTER TABLE `livros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefone`
--

DROP TABLE IF EXISTS `telefone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefone` (
  `telefone_id` int NOT NULL AUTO_INCREMENT,
  `telefone_socio` varchar(100) DEFAULT NULL,
  `codAssoc` int DEFAULT NULL,
  PRIMARY KEY (`telefone_id`),
  KEY `FK_codAssoc` (`codAssoc`),
  CONSTRAINT `FK_codAssoc` FOREIGN KEY (`codAssoc`) REFERENCES `associados` (`cod_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefone`
--

LOCK TABLES `telefone` WRITE;
/*!40000 ALTER TABLE `telefone` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefone` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-21  3:25:53
