CREATE DATABASE  IF NOT EXISTS `abc_job_ad` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `abc_job_ad`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: abc_job_ad
-- ------------------------------------------------------
-- Server version	5.6.42-log

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
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `education` (
  `username` varchar(50) NOT NULL,
  `eduId` int(11) NOT NULL AUTO_INCREMENT,
  `qualification` varchar(50) NOT NULL,
  `institute` varchar(50) NOT NULL,
  `countrySch` varchar(50) NOT NULL,
  `yearGrad` varchar(50) NOT NULL,
  `grade` varchar(50) NOT NULL,
  PRIMARY KEY (`eduId`),
  KEY `username` (`username`),
  CONSTRAINT `education_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` VALUES ('riyah',2,'gh','gh','gh','1212','3.5'),('riyah',4,'zx','zx','zx','1212','12'),('erza',5,'ACWD Advanced Web Developer','Lithan Academy','Singapore','2018','4');
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experience`
--

DROP TABLE IF EXISTS `experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `experience` (
  `username` varchar(50) NOT NULL,
  `expId` int(11) NOT NULL AUTO_INCREMENT,
  `compName` varchar(50) NOT NULL,
  `compAddr` varchar(50) NOT NULL,
  `countryComp` varchar(50) NOT NULL,
  `yearsExp` varchar(50) NOT NULL,
  `jobRole` varchar(50) NOT NULL,
  PRIMARY KEY (`expId`),
  KEY `username` (`username`),
  CONSTRAINT `experience_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experience`
--

LOCK TABLES `experience` WRITE;
/*!40000 ALTER TABLE `experience` DISABLE KEYS */;
INSERT INTO `experience` VALUES ('riyah',2,'wsx','wsx','wsx','12','wsx'),('erza',3,'Lifelong Institute','Paya Lebar ','Singapore','2','Front-End Developer');
/*!40000 ALTER TABLE `experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `friends` (
  `username` varchar(50) NOT NULL,
  `friendsId` int(11) NOT NULL AUTO_INCREMENT,
  `friendsName` varchar(50) NOT NULL,
  PRIMARY KEY (`friendsId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends`
--

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;
INSERT INTO `friends` VALUES ('riyah',5,'erza'),('erza',6,'riyah');
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobadd`
--

DROP TABLE IF EXISTS `jobadd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `jobadd` (
  `username` varchar(50) NOT NULL,
  `jobCode` int(11) NOT NULL AUTO_INCREMENT,
  `jobTitle` varchar(50) NOT NULL,
  `jobDesc` varchar(250) NOT NULL,
  `countryJob` varchar(50) NOT NULL,
  `closeDate` varchar(50) NOT NULL,
  PRIMARY KEY (`jobCode`),
  KEY `username` (`username`),
  CONSTRAINT `jobadd_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobadd`
--

LOCK TABLES `jobadd` WRITE;
/*!40000 ALTER TABLE `jobadd` DISABLE KEYS */;
INSERT INTO `jobadd` VALUES ('riyah',7,'Java Developer','Create website for clients','Singapore','2019-04-03'),('riyah',8,'Junior Developer','Create website using Java.','Japan','2019-08-25'),('erza',10,'Junior Developer','Create website using Java.','USA','2019-08-27'),('andyboy',11,'Junior Developer','Create website using Java.','USA','2019-08-27');
/*!40000 ALTER TABLE `jobadd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `gender` char(6) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `phoneNum` varchar(10) NOT NULL,
  `addrName` varchar(50) NOT NULL,
  `stName` varchar(50) NOT NULL,
  `countryName` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `confirmPass` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Andy','Chan','andycjh@gmail.com','Male','1993-01-21','98712345','Hell','12 North Light Street','Singapore','andyboy','abc','abc'),('Cana','Alberona','nursyazriyah95@gmail.com','Female','1212-12-12','98457325','Bb','West','Singapore','cana','cana','cana'),('Elfman','Strauss','nursyazriyah95@gmail.com','Male','1212-12-12','98765432','Bb','West','Singapore','elfman','elfman','elfman'),('Erza','Scarlet','nursyazriyah95@gmail.com','Female','1982-04-20','98765432','7857 Nova Circle','Erie Park','United States','erza','erza','erza'),('Gajeel','Redfox','nursyazriyah95@gmail.com','Male','1984-10-27','95623415','67 Kinsman Junction','Susan Avenue','United Kingdom','gajeel','gajeel','gajeel'),('Gray','Fullbuster','nursyazriyah95@gmail.com','Male','1988-12-20','94658712','3 Oxford Pass','Warbler Center','Sweden','gray','gray','gray'),('Jellal','Frenandes','nursyazriyah95@gmail.com','Male','1997-05-19','98765431','5308 Bluestem Way','Del Mar Point','Brazil','jellal','jellal','jellal'),('Juvia','Lockser','systemsC307@gmail.com','Female','1997-04-30','98745678','43 Arrowood Terrace','Logan Center','Australia','juvia','juvia','juvia'),('Laxus','Dreyar','nursyazriyah95@gmail.com','Male','1992-01-03','94134564','904 Thompson Road','Meadow Valley Drive','Tokyo','laxus','laxus','laxus'),('Levy','McGarden','nursyazriyah95@gmail.com','Female','1986-04-29','98765412','27 Stephen Point','Myrtle Parkway','Sweden','levy','levy','levy'),('Lisanna','Strauss','nursyazriyah95@gmail.com','Female','1212-12-12','98765423','Bb','West','Singapore','lisanna','lisanna','lisanna'),('Lucy','Heartfilia','nastoi@hotmail.com','Female','1997-10-22','98741233','2 Little Fleur Alley','Comanche Parkway','New Zealand','lucy','lucy','lucy'),('Makarov','Dreyar','nursyazriyah95@gmail.com','Male','1212-12-12','98745623','Bb','West','Singapore','makarov','makarov','makarov'),('Mirajane','Strauss','nursyazriyah@live.com','Female','1983-04-06','97845123','10 Dapin Crossing','Granby Parkway','Tokyo','mirajane','mirajane','mirajane'),('Natsu','Dragneel','nursyazriyah95@gmail.com','Male','1989-06-23','98451234','81 Roth Alley','Havey Place','New Zealand','natsu','natsu','natsu'),('Riyah','Mohammed','nursyazriyah95@gmail.com','Female','1995-01-31','98714725','Bukit Batok West 416','Avenue 5','Singapore','riyah','riyah','riyah'),('Wendy','Marvel','nursyazriyah95@gmail.com','Female','1212-12-12','94587623','Bb','West','Singapore','wendy','wendy','wendy');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'abc_job_ad'
--

--
-- Dumping routines for database 'abc_job_ad'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-26 21:00:51
