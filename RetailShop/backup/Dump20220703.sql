-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: adv_prgm_retail
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `CATEGORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CATEGORY_NAME` varchar(45) NOT NULL,
  `CATEGORY_DESC` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CATEGORY_ID`),
  UNIQUE KEY `CATEGORY_ID_UNIQUE` (`CATEGORY_ID`),
  UNIQUE KEY `CATEGORY_NAME_UNIQUE` (`CATEGORY_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (22,'Drinks','Drink DESC'),(23,'Chips','desc'),(24,'Vegetables','veg desc');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `item` (
  `ITEM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ITEM_NAME` varchar(45) NOT NULL,
  `ITEM_DESC` varchar(45) DEFAULT NULL,
  `ITEM_SPECIFY_CODE` int(11) NOT NULL,
  `ITEM_CATEGORY_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ITEM_ID`),
  UNIQUE KEY `ITEM_SPECIFY_CODE_UNIQUE` (`ITEM_SPECIFY_CODE`),
  KEY `item_idx` (`ITEM_CATEGORY_ID`),
  CONSTRAINT `item` FOREIGN KEY (`ITEM_CATEGORY_ID`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Pepsi','',1,22),(2,'coke-cool','desc',2,22);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_rate`
--

DROP TABLE IF EXISTS `item_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `item_rate` (
  `ITEM_RATE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RATE_ITEM_ID` int(11) NOT NULL,
  `ITEM_RATE` double NOT NULL,
  `RATE_CREATED_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ITEM_RATE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_rate`
--

LOCK TABLES `item_rate` WRITE;
/*!40000 ALTER TABLE `item_rate` DISABLE KEYS */;
INSERT INTO `item_rate` VALUES (1,1,10,'2022-07-03 05:10:14'),(2,2,45,'2022-07-03 05:39:29'),(3,2,55,'2022-07-03 05:52:16');
/*!40000 ALTER TABLE `item_rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'adv_prgm_retail'
--

--
-- Dumping routines for database 'adv_prgm_retail'
--
/*!50003 DROP PROCEDURE IF EXISTS `insert_update_item_proc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_update_item_proc`(IN pItemID int, IN pItemName varchar(45),
                                                               IN pItemDesc varchar(45), IN pSpecifyCode int,
                                                               IN pCategoryId int, IN pRate double, OUT rRes BOOLEAN,
                                                               OUT rMsg varchar(50))
BEGIN
    DECLARE item_key INTEGER DEFAULT 0;
    DECLARE lCount INTEGER DEFAULT 0;
    DECLARE lRate DOUBLE DEFAULT 0.0;
    SET rRes := true;
    SET rMsg := '';

    IF pItemID = 0 then

        select count(ITEM_ID) into lCount from item where ITEM_SPECIFY_CODE = pSpecifyCode;

        IF lCount = 0 and pItemID >0 then
            INSERT INTO item(ITEM_NAME, ITEM_DESC, ITEM_SPECIFY_CODE, ITEM_CATEGORY_ID)
            VALUES (pItemName, pItemDesc, pSpecifyCode, pCategoryId);

            select ITEM_ID
            into item_key
            from item
            order by ITEM_ID desc
            limit 1;

            IF item_key > 0 then
                INSERT INTO item_rate(RATE_ITEM_ID, ITEM_RATE) VALUES (item_key, pRate);
            else
                SET rRes := false;
                SET rMsg := 'Unable to add item!!!';
            end if;
        else
            SET rRes := false;
            SET rMsg := 'Specific code already exists!!!';
        end if;
    else
        update item
        set ITEM_NAME = pItemName, ITEM_DESC = pItemDesc, ITEM_SPECIFY_CODE = pSpecifyCode
        where ITEM_ID = pItemID;

        select ITEM_RATE into lRate from item_rate where RATE_ITEM_ID = pItemID;
        IF pRate != lRate then
            INSERT INTO item_rate(RATE_ITEM_ID, ITEM_RATE) VALUES (pItemID, pRate);
        end if;
    end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-03 11:52:46
