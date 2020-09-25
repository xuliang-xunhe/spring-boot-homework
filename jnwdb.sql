-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: jnwdb
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acticity_target`
--

DROP TABLE IF EXISTS `acticity_target`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acticity_target` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `target_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acticity_target`
--

LOCK TABLES `acticity_target` WRITE;
/*!40000 ALTER TABLE `acticity_target` DISABLE KEYS */;
INSERT INTO `acticity_target` VALUES (4,'Team'),(1,'社内'),(2,'部门'),(3,'项目');
/*!40000 ALTER TABLE `acticity_target` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activities`
--

DROP TABLE IF EXISTS `activities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rule_id` varchar(30) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `target_id` int(11) NOT NULL,
  `department_id` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `explain` varchar(1000) NOT NULL,
  `point` int(11) NOT NULL,
  `activity_kbn` char(1) NOT NULL DEFAULT '0',
  `reject_explain` varchar(1000) DEFAULT NULL,
  `open_kbn` char(1) NOT NULL DEFAULT '0',
  `status` char(1) NOT NULL DEFAULT '0',
  `manager_id` varchar(20) DEFAULT NULL,
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_by_id` varchar(20) NOT NULL,
  `update_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_by_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `team_id_idx` (`team_id`),
  KEY `project_id_idx` (`project_id`),
  KEY `department_id_idx` (`department_id`),
  KEY `rule_id_idx` (`rule_id`),
  KEY `create_by_id_idx` (`create_by_id`),
  KEY `update_by_id_idx` (`update_by_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `target_id_idx` (`target_id`),
  KEY `user_id_idx1` (`user_id`),
  KEY `target_id_idx1` (`target_id`),
  KEY `manager_id_2_idx` (`manager_id`),
  CONSTRAINT `create_by_id_1` FOREIGN KEY (`create_by_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `department_id_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `manager_id_2` FOREIGN KEY (`manager_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `project_id_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `rule_id_1` FOREIGN KEY (`rule_id`) REFERENCES `point_rule` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `target_id2` FOREIGN KEY (`target_id`) REFERENCES `acticity_target` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `team_id_1` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `update_by_id_1` FOREIGN KEY (`update_by_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activities`
--

LOCK TABLES `activities` WRITE;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
INSERT INTO `activities` VALUES (1,'1','SD10378',2,1,1,1,'测试','ceshi \n\n\n\n\nceshi\n\n111\n\n666',5,'0','ssss\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nhhh','1','3',NULL,'2020-08-03 06:34:10','sd10378','2020-08-03 07:26:29','sd00000'),(2,'1','SD10378',3,1,1,1,'测试2','测试',1000,'0',NULL,'1','1','sd00000','2020-08-03 06:43:14','SD10378','2020-08-03 06:58:21','sd00000'),(3,'2','sd00000',2,NULL,NULL,NULL,'测试3','测试33',200,'0',NULL,'0','1','sd00000','2020-08-03 06:44:15','SD10378','2020-08-03 06:59:27','sd00000'),(4,'1','sd00003',1,NULL,NULL,NULL,'111','111',15,'0',NULL,'1','1','sd00000','2020-08-03 06:50:23','sd10378','2020-08-03 07:01:33','sd00000'),(5,'2','sd00003',2,NULL,NULL,NULL,'222','333',22,'0',NULL,'0','0',NULL,'2020-08-03 06:50:46','sd10378',NULL,NULL),(6,'2','sd00000',2,1,1,1,'ceshi','111',34,'0','12','1','2',NULL,'2020-08-03 07:18:07','SD00000','2020-08-03 08:10:33','SD00000');
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_types`
--

DROP TABLE IF EXISTS `activity_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_types`
--

LOCK TABLES `activity_types` WRITE;
/*!40000 ALTER TABLE `activity_types` DISABLE KEYS */;
INSERT INTO `activity_types` VALUES (5,'其他'),(1,'开发'),(3,'活动'),(4,'管理'),(2,'运用'),(6,'运用运用运用运用运用');
/*!40000 ALTER TABLE `activity_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'SD0101'),(2,'SD0102');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `point`
--

DROP TABLE IF EXISTS `point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `point` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activitie_id` int(11) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `target_id` int(11) NOT NULL,
  `point` int(11) NOT NULL,
  `activity_kbn` char(1) NOT NULL DEFAULT '0',
  `open_kbn` char(1) NOT NULL DEFAULT '0',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_by_id` varchar(20) NOT NULL,
  `update_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_by_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `create_by_id_2_idx` (`create_by_id`),
  KEY `update_by_id_2_idx` (`update_by_id`),
  KEY `user_id_2_idx` (`user_id`),
  KEY `target_id_idx` (`target_id`),
  KEY `user_id_3_idx` (`user_id`),
  KEY `target_id_3_idx` (`target_id`),
  KEY `activitie_id_idx` (`activitie_id`),
  CONSTRAINT `activitie_id` FOREIGN KEY (`activitie_id`) REFERENCES `activities` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `create_by_id_2` FOREIGN KEY (`create_by_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `target_id_3` FOREIGN KEY (`target_id`) REFERENCES `acticity_target` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `update_by_id_2` FOREIGN KEY (`update_by_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id_3` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `point`
--

LOCK TABLES `point` WRITE;
/*!40000 ALTER TABLE `point` DISABLE KEYS */;
INSERT INTO `point` VALUES (1,2,'SD10378',3,1000,'0','1','2020-08-03 06:58:21','sd00000',NULL,NULL),(2,3,'sd00000',2,200,'0','0','2020-08-03 06:59:27','sd00000',NULL,NULL),(3,4,'sd00003',1,15,'0','1','2020-08-03 07:01:33','sd00000',NULL,NULL);
/*!40000 ALTER TABLE `point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `point_rule`
--

DROP TABLE IF EXISTS `point_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `point_rule` (
  `id` varchar(30) NOT NULL,
  `type_id` int(11) NOT NULL,
  `target_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `explain` varchar(1000) NOT NULL,
  `delete_kbn` char(1) NOT NULL DEFAULT '0',
  `status` char(1) NOT NULL DEFAULT '0',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_by_id` varchar(20) NOT NULL,
  `update_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_by_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id_idx` (`type_id`),
  KEY `target_id_idx` (`target_id`),
  KEY `create_by_id_idx` (`create_by_id`),
  KEY `update_by_id_idx` (`update_by_id`),
  CONSTRAINT `create_by_id` FOREIGN KEY (`create_by_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `target_id` FOREIGN KEY (`target_id`) REFERENCES `acticity_target` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `activity_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `update_by_id` FOREIGN KEY (`update_by_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `point_rule`
--

LOCK TABLES `point_rule` WRITE;
/*!40000 ALTER TABLE `point_rule` DISABLE KEYS */;
INSERT INTO `point_rule` VALUES ('1',1,1,'1111','111','0','0','2020-07-27 05:06:36','SD00000','2020-07-27 05:06:36','SD00000'),('2',1,1,'2222','为隆重表彰在抗击新冠肺炎疫情斗争中作出杰出贡献的功勋模范人物，党中央决定开展“共和国勋章”和国家荣誉称号评选颁授。在相关地区和部门反复比选、集体研究的基础上，经组织考察、统筹考虑，产生1名“共和国勋章”建议人选，3名国家荣誉称号建议人选。为充分发扬民主，广泛听取意见，接受社会监督，现将有关人选情况予以公示，公示时间从2020年8月3日起，至8月7日止。如对建议人选有异议，请于公示期间通过电话、邮件、信函等方式向党和国家功勋荣誉表彰工作委员会办公室反映。','0','0','2020-08-03 01:41:56','SD00000','2020-08-03 01:41:56',NULL);
/*!40000 ALTER TABLE `point_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (4,'DX推进部'),(3,'Frontシステム二部'),(2,'基干系统三部'),(1,'基盘技术二部');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'自動化');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `department_id` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `manager_kbn` char(1) NOT NULL DEFAULT '0',
  `explain` varchar(500) DEFAULT NULL,
  `delete_kbn` char(1) NOT NULL DEFAULT '0',
  `status` char(1) NOT NULL DEFAULT '0',
  `manager_id` varchar(20) DEFAULT NULL,
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `department_id_idx` (`department_id`),
  KEY `project_id_idx` (`project_id`),
  KEY `team_id_idx` (`team_id`),
  CONSTRAINT `department_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `team_id` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('SD00000','管理员','e10adc3949ba59abbe56e057f20f883e',NULL,NULL,NULL,'1',NULL,'0','1','SD00000','2020-06-17 03:38:50','2020-06-17 03:40:57'),('SD00001','刘国徽','593c9b4a9390551d53e5cacf28ebd638',1,1,1,'1','require - 请求另外的controller，传入当前directive的link function中。require需要传入一个directive controller的名称。如果找不到这个名称对应的controller，那么将会抛出一个error。名称可以加入以下前1','0','1','SD10379','2020-07-02 07:52:50','2020-07-15 02:28:20'),('SD00003','00003','e10adc3949ba59abbe56e057f20f883e',1,NULL,1,'2','11111','0','1','SD10656','2020-07-02 07:56:33','2020-09-17 08:23:23'),('SD00004','1123','e10adc3949ba59abbe56e057f20f883e',NULL,NULL,NULL,'2','','0','1','','2020-07-02 08:02:16','2020-09-17 08:23:32'),('SD00005','15','9bf31c7ff062936a96d3c8bd1f8f2ff3',NULL,NULL,NULL,'2','','0','1','','2020-07-02 08:15:56','2020-09-17 08:23:32'),('SD10001','張','e10adc3949ba59abbe56e057f20f883e',NULL,NULL,NULL,'2','','0','1','','2020-07-16 02:40:28','2020-09-17 08:23:32'),('SD10378','张三','e10adc3949ba59abbe56e057f20f883e',1,NULL,1,'1','1564654dgzsgasgf','0','1','SD00000','2020-07-02 05:27:13','2020-09-17 08:23:23'),('SD10379','徐亮','e10adc3949ba59abbe56e057f20f883e',1,1,1,'1','gvdfsgfdshfds','0','1','','2020-09-14 13:33:01','2020-09-21 14:13:01'),('SD10656','刘国徽','96e79218965eb72c92a549dd5a330112',1,1,1,'1','','0','1','','2020-07-16 07:30:38','2020-07-16 07:30:56');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-24 21:30:00
