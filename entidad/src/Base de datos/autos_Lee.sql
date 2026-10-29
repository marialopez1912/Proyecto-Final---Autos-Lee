-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: autos_lee
-- ------------------------------------------------------
-- Server version	9.4.0

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
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `Id_Administrador` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Apellido_Paterno` varchar(45) NOT NULL,
  `Apellido_Materno` varchar(45) DEFAULT NULL,
  `Correo_Electronico` varchar(45) NOT NULL,
  `Numero_Telefonico` varchar(45) NOT NULL,
  `Usuario` varchar(255) NOT NULL,
  `Contrasenia` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_Administrador`),
  UNIQUE KEY `Usuario_UNIQUE` (`Usuario`),
  UNIQUE KEY `Contrasenia_UNIQUE` (`Contrasenia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auto`
--

DROP TABLE IF EXISTS `auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auto` (
  `Id_Auto_Sistema` int NOT NULL AUTO_INCREMENT,
  `Marca` varchar(60) NOT NULL,
  `Modelo` varchar(60) NOT NULL,
  `Version` varchar(60) NOT NULL,
  `Anio` year NOT NULL,
  `VIN` varchar(17) NOT NULL,
  `Placa` varchar(45) NOT NULL,
  `Carroceria` varchar(200) NOT NULL,
  `Tipo_Motor` varchar(200) NOT NULL,
  `Cilindros` int NOT NULL,
  `Potencia_Maxima` varchar(45) NOT NULL,
  `Transmision` varchar(200) NOT NULL,
  `Frenos` varchar(200) NOT NULL,
  `Suspension` varchar(200) NOT NULL,
  `Precio_Compra` decimal(10,2) NOT NULL,
  `Porcentaje_Ganancia` decimal(5,2) NOT NULL,
  `Precio_Venta` decimal(10,2) NOT NULL,
  `Tipo_Combustible` varchar(60) NOT NULL,
  `Administrador_Id_Administrador` int NOT NULL,
  PRIMARY KEY (`Id_Auto_Sistema`,`Administrador_Id_Administrador`),
  UNIQUE KEY `VIN_UNIQUE` (`VIN`),
  UNIQUE KEY `Id_Auto_Sistema_UNIQUE` (`Id_Auto_Sistema`),
  KEY `fk_Auto_Administrador1_idx` (`Administrador_Id_Administrador`),
  CONSTRAINT `fk_Auto_Administrador1` FOREIGN KEY (`Administrador_Id_Administrador`) REFERENCES `administrador` (`Id_Administrador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

LOCK TABLES `auto` WRITE;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auto_equipamiento`
--

DROP TABLE IF EXISTS `auto_equipamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auto_equipamiento` (
  `Equipamiento` varchar(1000) NOT NULL,
  `Auto_Id_Auto_Sistema` int NOT NULL,
  PRIMARY KEY (`Equipamiento`,`Auto_Id_Auto_Sistema`),
  KEY `fk_Auto_Equipamiento_Auto1_idx` (`Auto_Id_Auto_Sistema`),
  CONSTRAINT `fk_Auto_Equipamiento_Auto1` FOREIGN KEY (`Auto_Id_Auto_Sistema`) REFERENCES `auto` (`Id_Auto_Sistema`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto_equipamiento`
--

LOCK TABLES `auto_equipamiento` WRITE;
/*!40000 ALTER TABLE `auto_equipamiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `auto_equipamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auto_seguridad`
--

DROP TABLE IF EXISTS `auto_seguridad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auto_seguridad` (
  `Sistema_Seguridad` varchar(1000) NOT NULL,
  `Auto_Id_Auto_Sistema` int NOT NULL,
  PRIMARY KEY (`Sistema_Seguridad`,`Auto_Id_Auto_Sistema`),
  KEY `fk_Auto_Seguridad_Auto1_idx` (`Auto_Id_Auto_Sistema`),
  CONSTRAINT `fk_Auto_Seguridad_Auto1` FOREIGN KEY (`Auto_Id_Auto_Sistema`) REFERENCES `auto` (`Id_Auto_Sistema`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto_seguridad`
--

LOCK TABLES `auto_seguridad` WRITE;
/*!40000 ALTER TABLE `auto_seguridad` DISABLE KEYS */;
/*!40000 ALTER TABLE `auto_seguridad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cita` (
  `Id_Cita` int NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `Usuario_Id_Usuario` int NOT NULL,
  `Auto_Id_Auto_Sistema` int NOT NULL,
  `Auto_Administrador_Id_Administrador` int NOT NULL,
  `Administrador_Id_Administrador` int NOT NULL,
  PRIMARY KEY (`Id_Cita`,`Usuario_Id_Usuario`,`Auto_Id_Auto_Sistema`,`Auto_Administrador_Id_Administrador`,`Administrador_Id_Administrador`),
  KEY `fk_Cita_Usuario1_idx` (`Usuario_Id_Usuario`),
  KEY `fk_Cita_Auto1_idx` (`Auto_Id_Auto_Sistema`,`Auto_Administrador_Id_Administrador`),
  KEY `fk_Cita_Administrador1_idx` (`Administrador_Id_Administrador`),
  CONSTRAINT `fk_Cita_Administrador1` FOREIGN KEY (`Administrador_Id_Administrador`) REFERENCES `administrador` (`Id_Administrador`),
  CONSTRAINT `fk_Cita_Auto1` FOREIGN KEY (`Auto_Id_Auto_Sistema`, `Auto_Administrador_Id_Administrador`) REFERENCES `auto` (`Id_Auto_Sistema`, `Administrador_Id_Administrador`),
  CONSTRAINT `fk_Cita_Usuario1` FOREIGN KEY (`Usuario_Id_Usuario`) REFERENCES `usuario` (`Id_Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita`
--

LOCK TABLES `cita` WRITE;
/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `Id_Compra` int NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `Precio_Final` decimal(10,2) NOT NULL,
  `Auto_Id_Auto_Sistema` int NOT NULL,
  `Auto_Administrador_Id_Administrador` int NOT NULL,
  `Usuario_Id_Usuario` int NOT NULL,
  PRIMARY KEY (`Id_Compra`,`Auto_Id_Auto_Sistema`,`Auto_Administrador_Id_Administrador`,`Usuario_Id_Usuario`),
  KEY `fk_Compra_Auto1_idx` (`Auto_Id_Auto_Sistema`,`Auto_Administrador_Id_Administrador`),
  KEY `fk_Compra_Usuario1_idx` (`Usuario_Id_Usuario`),
  CONSTRAINT `fk_Compra_Auto1` FOREIGN KEY (`Auto_Id_Auto_Sistema`, `Auto_Administrador_Id_Administrador`) REFERENCES `auto` (`Id_Auto_Sistema`, `Administrador_Id_Administrador`),
  CONSTRAINT `fk_Compra_Usuario1` FOREIGN KEY (`Usuario_Id_Usuario`) REFERENCES `usuario` (`Id_Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `defecto`
--

DROP TABLE IF EXISTS `defecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `defecto` (
  `Id_Defecto` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(1000) NOT NULL,
  `Tipo` enum('Mecanico','Estetico') NOT NULL,
  `Auto_Id_Auto_Sistema` int NOT NULL,
  `Auto_Administrador_Id_Administrador` int NOT NULL,
  PRIMARY KEY (`Id_Defecto`,`Auto_Id_Auto_Sistema`,`Auto_Administrador_Id_Administrador`),
  KEY `fk_Defecto_Auto1_idx` (`Auto_Id_Auto_Sistema`,`Auto_Administrador_Id_Administrador`),
  CONSTRAINT `fk_Defecto_Auto1` FOREIGN KEY (`Auto_Id_Auto_Sistema`, `Auto_Administrador_Id_Administrador`) REFERENCES `auto` (`Id_Auto_Sistema`, `Administrador_Id_Administrador`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `defecto`
--

LOCK TABLES `defecto` WRITE;
/*!40000 ALTER TABLE `defecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `defecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gasto`
--

DROP TABLE IF EXISTS `gasto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gasto` (
  `Id_Gasto` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(1000) NOT NULL,
  `Tipo` enum('Mecanico','Estetico') NOT NULL,
  `Monto` decimal(10,2) NOT NULL,
  `Auto_Id_Auto_Sistema` int NOT NULL,
  `Auto_Administrador_Id_Administrador` int NOT NULL,
  PRIMARY KEY (`Id_Gasto`,`Auto_Id_Auto_Sistema`,`Auto_Administrador_Id_Administrador`),
  KEY `fk_Gasto_Auto1_idx` (`Auto_Id_Auto_Sistema`,`Auto_Administrador_Id_Administrador`),
  CONSTRAINT `fk_Gasto_Auto1` FOREIGN KEY (`Auto_Id_Auto_Sistema`, `Auto_Administrador_Id_Administrador`) REFERENCES `auto` (`Id_Auto_Sistema`, `Administrador_Id_Administrador`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gasto`
--

LOCK TABLES `gasto` WRITE;
/*!40000 ALTER TABLE `gasto` DISABLE KEYS */;
/*!40000 ALTER TABLE `gasto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `Id_Usuario` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Apellido_Paterno` varchar(45) NOT NULL,
  `Apellido_Materno` varchar(45) DEFAULT NULL,
  `Correo_Electronico` varchar(45) NOT NULL,
  `Usuario` varchar(255) NOT NULL,
  `Contrasenia` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_Usuario`),
  UNIQUE KEY `Contrasenia_UNIQUE` (`Contrasenia`),
  UNIQUE KEY `Usuario_UNIQUE` (`Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vista_auto_costos`
--

DROP TABLE IF EXISTS `vista_auto_costos`;
/*!50001 DROP VIEW IF EXISTS `vista_auto_costos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_auto_costos` AS SELECT 
 1 AS `Id_Auto_Sistema`,
 1 AS `Gastos_Totales`,
 1 AS `Costo_Total`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vista_auto_costos`
--

/*!50001 DROP VIEW IF EXISTS `vista_auto_costos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_auto_costos` AS select `a`.`Id_Auto_Sistema` AS `Id_Auto_Sistema`,ifnull(sum(`g`.`Monto`),0) AS `Gastos_Totales`,(`a`.`Precio_Compra` + ifnull(sum(`g`.`Monto`),0)) AS `Costo_Total` from (`auto` `a` left join `gasto` `g` on((`g`.`Auto_Id_Auto_Sistema` = `a`.`Id_Auto_Sistema`))) group by `a`.`Id_Auto_Sistema`,`a`.`Precio_Compra` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-10-28 19:28:55
