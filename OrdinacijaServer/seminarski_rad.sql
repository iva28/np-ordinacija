/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 8.0.31 : Database - seminarski_rad
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarski_rad` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `seminarski_rad`;

/*Table structure for table `jelo` */

DROP TABLE IF EXISTS `jelo`;

CREATE TABLE `jelo` (
  `jeloId` bigint NOT NULL AUTO_INCREMENT,
  `naziv` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cena` decimal(10,0) NOT NULL,
  `kolicina` int NOT NULL,
  `tip_id` bigint NOT NULL,
  `kuvar_id` bigint NOT NULL,
  PRIMARY KEY (`jeloId`),
  UNIQUE KEY `naziv` (`naziv`),
  KEY `tip_id` (`tip_id`),
  KEY `kuvar_id` (`kuvar_id`),
  CONSTRAINT `jelo_ibfk_1` FOREIGN KEY (`tip_id`) REFERENCES `tipjela` (`tipId`),
  CONSTRAINT `jelo_ibfk_2` FOREIGN KEY (`kuvar_id`) REFERENCES `kuvar` (`kuvarId`)
) ENGINE=InnoDB AUTO_INCREMENT=306 DEFAULT CHARSET=latin1;

/*Data for the table `jelo` */

insert  into `jelo`(`jeloId`,`naziv`,`cena`,`kolicina`,`tip_id`,`kuvar_id`) values 
(1,'musaka',1200,200,3,1),
(4,'grašak',550,300,1,3),
(5,'rol viršla',110,100,3,1),
(8,'gibanica',80,100,2,2),
(9,'batak',700,350,3,2),
(11,'mango piletina',1200,350,3,2),
(14,'karfiol sa sirom',665,200,2,1),
(15,'pačetina',2000,122,3,1),
(16,'kupus salata',300,100,1,3),
(17,'sladoled',440,200,4,3),
(18,'teleća čorba',400,150,3,1),
(19,'potaž od paradajza',480,150,1,3),
(20,'sarma',367,200,3,2),
(21,'pire kropmpir',340,100,2,3),
(22,'kus kus',200,200,1,3),
(29,'slatki kupus',467,200,4,3),
(30,'pomodoro pasta',222,222,4,2),
(31,'potaž',400,200,1,3),
(32,'piletina',345,120,3,2),
(33,'tuna',400,200,3,2),
(34,'pileća salata',500,200,4,1),
(35,'grilovan brokoli',100,100,1,2),
(43,'baklava',280,100,1,1),
(44,'kropir pire',300,150,1,1),
(47,'hleb',50,150,1,1),
(53,'boranija',50,150,2,1),
(59,'cvekla',50,20,2,1),
(68,'keleraba slatka',340,120,2,1);

/*Table structure for table `kuvar` */

DROP TABLE IF EXISTS `kuvar`;

CREATE TABLE `kuvar` (
  `kuvarId` bigint NOT NULL AUTO_INCREMENT,
  `ime` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `prezime` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `adresa` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telefon` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`kuvarId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `kuvar` */

insert  into `kuvar`(`kuvarId`,`ime`,`prezime`,`adresa`,`telefon`) values 
(1,'Milo','Milić','Adresa 1','0665656'),
(2,'Tara','Tarić','Adresa 2','0665657'),
(3,'Srna','Srnić','Adresa 3','06676863');

/*Table structure for table `nutricionista` */

DROP TABLE IF EXISTS `nutricionista`;

CREATE TABLE `nutricionista` (
  `nutricionistaId` bigint NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `prezime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ordinacijaId` bigint NOT NULL,
  PRIMARY KEY (`nutricionistaId`),
  KEY `ordinacijaId` (`ordinacijaId`),
  CONSTRAINT `nutricionista_ibfk_1` FOREIGN KEY (`ordinacijaId`) REFERENCES `ordinacija` (`ordinacijaId`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `nutricionista` */

insert  into `nutricionista`(`nutricionistaId`,`ime`,`prezime`,`username`,`password`,`ordinacijaId`) values 
(1,'Iva','Stanišić','iva28','iva28',1),
(2,'Nikola','Nikov','niko2','niko2',1),
(3,'Marija ','Marić','marija','marija',3),
(4,'Toma','Tomić','toma','toma',4),
(5,'Ana','Ankov','ana','ana',2);

/*Table structure for table `ordinacija` */

DROP TABLE IF EXISTS `ordinacija`;

CREATE TABLE `ordinacija` (
  `ordinacijaId` bigint NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) NOT NULL,
  `adresa` varchar(50) NOT NULL,
  PRIMARY KEY (`ordinacijaId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `ordinacija` */

insert  into `ordinacija`(`ordinacijaId`,`naziv`,`adresa`) values 
(1,'Ordinacija 1','Adresa 1'),
(2,'Ordinacija 2','Adresa 2'),
(3,'Ordinacija 3','Adresa 3'),
(4,'Ordinacija 4','Adresa 4');

/*Table structure for table `pacijent` */

DROP TABLE IF EXISTS `pacijent`;

CREATE TABLE `pacijent` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `prezime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telefon` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pol` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=331 DEFAULT CHARSET=latin1;

/*Data for the table `pacijent` */

insert  into `pacijent`(`id`,`ime`,`prezime`,`email`,`telefon`,`pol`) values 
(3,'Maja','Majović','maja@gmail.com','06555455','ženski'),
(25,'Petra','Petrović','petra@gmail.com','0677667','ženski'),
(31,'Luka','Lukov','luka@gmail.com','06533721','muški'),
(32,'Todor','Todorović','todor@gmail.com','06534362','muški'),
(39,'Anica','Todorović','ana@todorov.com','06755222','ženski'),
(45,'Sofija','Takov','sofija@gmail.com','06652612','ženski'),
(48,'Petar','Lukov','lukov@gmail.com','066736422','muški'),
(49,'Maja','Sakin','sakin@gmail.com','06765372','ženski'),
(51,'Janko','Mirić','janko@gmail.com','066526728','muški'),
(55,'Anja','Tadilić','anja@gmail.com','06625632','ženski'),
(56,'Aleksa','Nikolić','aleksa@gmail.com','066567234','muški'),
(57,'Marija','Savić','marija@gmail.com','06652753','ženski'),
(58,'Tara','Morava','tara@gmail.com','06653627','ženski'),
(59,'Miona','Ćorović','miona@gmail.com','06652663','ženski'),
(322,'Mirko','Spasić','spasic@gmail.com','06788827','muški');

/*Table structure for table `planishrane` */

DROP TABLE IF EXISTS `planishrane`;

CREATE TABLE `planishrane` (
  `planishraneId` bigint NOT NULL AUTO_INCREMENT,
  `datum` date NOT NULL,
  `cena` decimal(10,0) NOT NULL,
  `pacijentId` bigint NOT NULL,
  `nutricionistaId` bigint NOT NULL,
  `brojDana` int NOT NULL,
  PRIMARY KEY (`planishraneId`),
  KEY `pacijentId` (`pacijentId`),
  KEY `nutricionistaId` (`nutricionistaId`),
  CONSTRAINT `planishrane_ibfk_1` FOREIGN KEY (`pacijentId`) REFERENCES `pacijent` (`id`),
  CONSTRAINT `planishrane_ibfk_2` FOREIGN KEY (`nutricionistaId`) REFERENCES `nutricionista` (`nutricionistaId`)
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=latin1;

/*Data for the table `planishrane` */

insert  into `planishrane`(`planishraneId`,`datum`,`cena`,`pacijentId`,`nutricionistaId`,`brojDana`) values 
(74,'2023-03-15',79640,3,1,22),
(75,'2023-06-16',166702,51,1,34),
(76,'2022-12-14',736524,48,5,123),
(83,'2023-03-15',79640,3,1,22),
(182,'2023-06-17',166920,59,1,26);

/*Table structure for table `stavkaplanaishrane` */

DROP TABLE IF EXISTS `stavkaplanaishrane`;

CREATE TABLE `stavkaplanaishrane` (
  `rb` bigint NOT NULL AUTO_INCREMENT,
  `cena` decimal(10,0) NOT NULL,
  `kolicina` int NOT NULL,
  `planishraneId` bigint NOT NULL,
  `jelo_id` bigint DEFAULT NULL,
  PRIMARY KEY (`rb`,`planishraneId`),
  KEY `jelo_id` (`jelo_id`),
  KEY `planIshrane_id` (`planishraneId`),
  CONSTRAINT `stavkaplanaishrane_ibfk_2` FOREIGN KEY (`jelo_id`) REFERENCES `jelo` (`jeloId`),
  CONSTRAINT `stavkaplanaishrane_ibfk_3` FOREIGN KEY (`planishraneId`) REFERENCES `planishrane` (`planishraneId`)
) ENGINE=InnoDB AUTO_INCREMENT=642 DEFAULT CHARSET=latin1;

/*Data for the table `stavkaplanaishrane` */

insert  into `stavkaplanaishrane`(`rb`,`cena`,`kolicina`,`planishraneId`,`jelo_id`) values 
(344,2400,2,74,1),
(345,1020,3,74,68),
(346,200,4,74,59),
(347,1035,3,75,32),
(348,1468,4,75,20),
(349,300,3,75,35),
(350,2100,7,75,16),
(351,800,2,76,18),
(352,2000,4,76,34),
(353,1868,4,76,29),
(354,1320,3,76,17),
(367,2400,2,83,1),
(368,1020,3,83,68),
(369,200,4,83,59),
(622,1000,2,182,34),
(623,1020,3,182,68),
(624,2200,5,182,17),
(625,2200,4,182,4);

/*Table structure for table `tipjela` */

DROP TABLE IF EXISTS `tipjela`;

CREATE TABLE `tipjela` (
  `tipId` bigint NOT NULL AUTO_INCREMENT,
  `vrsta` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`tipId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `tipjela` */

insert  into `tipjela`(`tipId`,`vrsta`) values 
(1,'vegansko'),
(2,'vegeterijansko'),
(3,'sa mesom'),
(4,'bez glutena');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
