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

insert  into `rel_images_user`(`user_id`,`images`) values ('f6b3c15c-ffd3-4c57-91ff-116a3550011d','https://profile-avatar.csdnimg.cn/9f172825429145ebada87e523f725279_web_yueqiang.jpg!3');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` varchar(36) NOT NULL,
  `created_by_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` int(11) DEFAULT NULL,
  `updated_by_id` varchar(36) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sys_role` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL,
  `created_by_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `deleted` int(11) DEFAULT NULL,
  `updated_by_id` varchar(36) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `cn_date1` datetime DEFAULT NULL,
  `cn_date2` datetime DEFAULT NULL,
  `cn_date3` datetime DEFAULT NULL,
  `cn_db1` double DEFAULT NULL,
  `cn_db2` double DEFAULT NULL,
  `cn_db3` double DEFAULT NULL,
  `cn_int1` int(11) DEFAULT NULL,
  `cn_int2` int(11) DEFAULT NULL,
  `cn_int3` int(11) DEFAULT NULL,
  `cn_str1` varchar(255) DEFAULT NULL,
  `cn_str2` varchar(255) DEFAULT NULL,
  `cn_str3` varchar(255) DEFAULT NULL,
  `cn_str4` varchar(255) DEFAULT NULL,
  `cn_str5` varchar(255) DEFAULT NULL,
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

insert  into `sys_user`(`id`,`created_by_id`,`created_date`,`deleted`,`updated_by_id`,`updated_date`,`cn_date1`,`cn_date2`,`cn_date3`,`cn_db1`,`cn_db2`,`cn_db3`,`cn_int1`,`cn_int2`,`cn_int3`,`cn_str1`,`cn_str2`,`cn_str3`,`cn_str4`,`cn_str5`,`email`,`head_portrait`,`init_recommend`,`last_login_client`,`last_login_date`,`latitude`,`login_name`,`longitude`,`mobile`,`name`,`password`,`position`) values ('f6b3c15c-ffd3-4c57-91ff-116a3550011d',NULL,'2022-08-16 12:43:45',0,NULL,'2022-08-16 12:43:45',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,'15921359796',NULL,'15921359796','name',NULL,NULL);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `user_id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  KEY `FKhh52n8vd4ny9ff4x9fb8v65qx` (`role_id`),
  KEY `FKb40xxfch70f5qnyfw8yme1n1s` (`user_id`),
  CONSTRAINT `FKb40xxfch70f5qnyfw8yme1n1s` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `FKhh52n8vd4ny9ff4x9fb8v65qx` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sys_user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
