/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.34-log : Database - mg_xiushang
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mg_xiushang` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `mg_xiushang`;

/*Table structure for table `rel_images_user` */

DROP TABLE IF EXISTS `rel_images_user`;

CREATE TABLE `rel_images_user` (
  `user_id` varchar(36) NOT NULL,
  `images` varchar(255) DEFAULT NULL,
  KEY `FKt9l6pmv1gwcept6pcya4x07y9` (`user_id`),
  CONSTRAINT `FKt9l6pmv1gwcept6pcya4x07y9` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `rel_images_user` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL,
  `created_by_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` int(11) DEFAULT NULL,
  `updated_by_id` varchar(36) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `head_portrait` longtext,
  `init_recommend` tinyint(4) DEFAULT NULL,
  `last_login_client` varchar(255) DEFAULT NULL,
  `last_login_date` datetime DEFAULT NULL,
  `latitude` decimal(20,8) DEFAULT NULL,
  `login_name` varchar(255) DEFAULT NULL,
  `longitude` decimal(20,8) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sys_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
