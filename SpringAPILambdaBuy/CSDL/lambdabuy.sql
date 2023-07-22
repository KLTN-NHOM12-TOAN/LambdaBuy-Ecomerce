-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: lambdabuy
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES ('6130b685-5811-4cb3-a10a-3fe2235b98b2','Lô D26, ngõ 3, đường Tôn Thất Thuyết, phường Yên Hòa, quận Cầu Giấy, thủ đô Hà Nội.','admin','2022-11-25 00:06:34','Công ty Cổ phần Sữa Việt Nam Vinamilk',_binary '\0','Vinamilk',NULL,NULL),('9e04867f-ca39-40e6-a866-1b3a51c96580','Lô D26, ngõ 3, đường Tôn Thất Thuyết, phường Yên Hòa, quận Cầu Giấy, thủ đô Hà Nội.','admin','2022-11-25 00:05:32','Tập đoàn Công nghiệp - Viễn thông Quân đội (Viettel)',_binary '\0','Viettel',NULL,'2022-11-25 00:16:25'),('fa90f9e1-9e94-484b-b212-3b5dfc24fd62','MobiFone đã nỗ lực mở rộng phạm vi cung cấp dịch vụ của mình, nâng rộng vùng phủ sóng di động tới 3 miền trên cả nước, với việc thành lập 3 Trung tâm thông tin di động tại Hà Nội, TP.HCM, Đà Nẵng.','admin','2022-11-25 00:08:52','MobiFone',_binary '\0','MobiFone',NULL,NULL),('fd84bd9b-b390-4493-8731-74e823e1cf17','Lô D26, ngõ 3, đường Tôn Thất Thuyết, phường Yên Hòa, quận Cầu Giấy, thủ đô Hà Nội.','admin','2022-11-25 00:07:16','Tập đoàn Bưu chính Viễn thông Việt Nam (VNPT)',_binary '\0','VNPT',NULL,NULL);
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('0fe02f4c-34a9-490f-a8e0-61a4d22cf31d','admin','2022-11-25 00:10:54',_binary '\0','Đồ thời trang',NULL,NULL),('1fa14737-a68b-452b-a845-db5836e5f29b','admin','2022-11-25 00:09:57',_binary '\0','Sữa chua, kem, sữa chua uống',NULL,NULL),('47cbb459-4ef8-4bf2-9580-5602f62d0823','admin','2022-11-25 00:09:51',_binary '\0','Đồ ăn nhanh',NULL,NULL),('54442c17-640a-49fd-bf20-422eecae5bf7','admin','2022-11-25 00:10:17',_binary '\0','Các loại hóa mỹ phẩm',NULL,NULL),('b4945446-4b5e-4ecc-b143-21f2cabe8c1e','admin','2022-11-25 00:11:09',_binary '\0','Đồ thể thao',NULL,NULL),('bf95e631-7977-4690-86c7-8dc304026d45','admin','2022-11-25 00:10:26',_binary '\0','Các đồ dùng văn phòng phẩm',NULL,NULL),('c62615fc-38a8-450e-9786-b8d72f969264','admin','2022-11-25 00:09:46',_binary '\0','Đồ ăn nhanh',NULL,NULL),('dbc91e40-d236-46ed-80bd-b8c855b3b90a','admin','2022-11-25 00:11:02',_binary '\0','Đồ mỹ phẩm',NULL,NULL),('e25058ed-8ed3-4c66-be57-0294688bdf20','admin','2022-11-25 00:10:48',_binary '\0','Đồ công nghệ',NULL,NULL),('ecc61f61-caf2-45f9-a627-b67fe70a8a6e','admin','2022-11-25 00:09:40',_binary '\0','Đồ uống giải khát',NULL,NULL),('f0803487-d0c6-44f3-bed9-120fe14f3603','admin','2022-11-25 00:10:32',_binary '\0','Đồ sinh hoạt cá nhân',NULL,NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` varchar(255) NOT NULL,
  `image_data` longblob,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `profile_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgpextbyee3uk9u6o2381m7ft1` (`product_id`),
  KEY `FKqwn1clw18e100amv72q5o0tad` (`profile_id`),
  CONSTRAINT `FKgpextbyee3uk9u6o2381m7ft1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKqwn1clw18e100amv72q5o0tad` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetail` (
  `id` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `payer_email` varchar(255) DEFAULT NULL,
  `payer_firt_name` varchar(255) DEFAULT NULL,
  `payer_last_name` varchar(255) DEFAULT NULL,
  `recident_name` varchar(255) DEFAULT NULL,
  `shipping_city` varchar(255) DEFAULT NULL,
  `shipping_country_code` varchar(255) DEFAULT NULL,
  `shipping_line1` varchar(255) DEFAULT NULL,
  `shipping_postal_code` double DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfxkmvpbfxqect54pd7slj4ll9` (`order_id`),
  KEY `FKdubukg3j0fymgci0idnd72k0` (`product_id`),
  CONSTRAINT `FKdubukg3j0fymgci0idnd72k0` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKfxkmvpbfxqect54pd7slj4ll9` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` varchar(255) NOT NULL,
  `shipping` double DEFAULT NULL,
  `sub_total` double DEFAULT NULL,
  `tax` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKel9kyl84ego2otj2accfd8mr7` (`user_id`),
  CONSTRAINT `FKel9kyl84ego2otj2accfd8mr7` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` varchar(255) NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `description` text,
  `discount` double DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `in_stock` int DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `manufactured_date` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `special` bit(1) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `brand_id` varchar(255) DEFAULT NULL,
  `category_id` varchar(255) DEFAULT NULL,
  `supplier_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs6cydsualtsrprvlf2bb3lcam` (`brand_id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  KEY `FK2kxvbr72tmtscjvyp9yqb12by` (`supplier_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FK2kxvbr72tmtscjvyp9yqb12by` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
  CONSTRAINT `FKs6cydsualtsrprvlf2bb3lcam` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('4c90605d-e5aa-40ee-88d4-a8c0ba6b18cf','USA','admin','2022-11-25 00:25:38','Được sản xuất tại Châu Âu, đảm bảo chất lượng sản phẩm',0,'fuji.png',200,_binary '\0',0,'Máy ảnh Fuji',_binary '\0',5,NULL,NULL,'9e04867f-ca39-40e6-a866-1b3a51c96580','e25058ed-8ed3-4c66-be57-0294688bdf20','b7cb2b5b-72b6-4214-9f9d-5d0c74b4f3f7'),('6a6e420e-decb-4ffd-8958-49b50a690976','USA','admin','2022-11-25 00:28:59','Được sản xuất tại Châu Âu, đảm bảo chất lượng sản phẩm',0,'fuji.png',200,_binary '\0',0,'Lò vi sóng',_binary '\0',15,NULL,NULL,'9e04867f-ca39-40e6-a866-1b3a51c96580','e25058ed-8ed3-4c66-be57-0294688bdf20','b7cb2b5b-72b6-4214-9f9d-5d0c74b4f3f7'),('83de71cb-f4bf-4a7b-b162-8833d87d6e84','USA','admin','2022-11-25 00:23:47','Được sản xuất tại Châu Âu, đảm bảo chất lượng sản phẩm',0,'noichien.png',100,_binary '\0',0,'Máy ảnh Canon',_binary '\0',10,NULL,NULL,'fa90f9e1-9e94-484b-b212-3b5dfc24fd62','e25058ed-8ed3-4c66-be57-0294688bdf20','27d943a7-0365-42c6-a321-3c3a943b8449'),('a4d3be17-b888-45e2-a0fe-250cec18571b','USA','admin','2022-11-25 00:28:29','Được sản xuất tại Châu Âu, đảm bảo chất lượng sản phẩm',0,'fuji.png',200,_binary '\0',0,'Máy lạnh',_binary '\0',15,NULL,NULL,'9e04867f-ca39-40e6-a866-1b3a51c96580','e25058ed-8ed3-4c66-be57-0294688bdf20','b7cb2b5b-72b6-4214-9f9d-5d0c74b4f3f7'),('c853919b-12eb-4edd-88bd-70f855c04102','USA','admin','2022-11-25 00:28:43','Được sản xuất tại Châu Âu, đảm bảo chất lượng sản phẩm',0,'fuji.png',200,_binary '\0',0,'Đèn huỳnh quang',_binary '\0',15,NULL,NULL,'9e04867f-ca39-40e6-a866-1b3a51c96580','e25058ed-8ed3-4c66-be57-0294688bdf20','b7cb2b5b-72b6-4214-9f9d-5d0c74b4f3f7');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profile` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `image_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjvw51ll74pvplckkn054pakw9` (`image_id`),
  KEY `FKawh070wpue34wqvytjqr4hj5e` (`user_id`),
  CONSTRAINT `FKawh070wpue34wqvytjqr4hj5e` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKjvw51ll74pvplckkn054pakw9` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES ('4375d227-56b5-41f9-923e-0ce9960d3942','Quang Trung - Gò Vấp','1st anniversity.png',NULL,NULL,'Toan','Van','0819490540',NULL,'2022-11-25 00:32:45',NULL,'767fc8b3-1abd-48c5-ae52-69d3f4486996'),('d6da4bcc-4703-4cb1-82df-696853da9ab4',NULL,NULL,NULL,NULL,'Admin','account',NULL,NULL,NULL,NULL,'f589f12f-e022-4125-8a2a-b3f43dd51bd2'),('de1d9cc8-1b93-46a4-9039-a71f70ddbc58',NULL,NULL,NULL,NULL,'Toan','Le',NULL,NULL,NULL,NULL,'2f181fb6-493d-469f-9ce0-f68c848baeae'),('f8dd389b-a759-456f-81a9-b82f2a980bf4',NULL,NULL,NULL,NULL,'Toan','CV',NULL,NULL,NULL,NULL,'49f2cfe1-383f-4657-9b4f-0ba1c4372a07');
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('27d943a7-0365-42c6-a321-3c3a943b8449','Tân Bình, Tp.HCM',NULL,'2022-11-25 00:03:24','Brandz Quốc Tế là nhà nhập khẩu, đối tác của gần 20 nhãn hàng thời trang trên thế giới tập trung vào mảng đồng hồ, phụ kiện thời trang cho nam và nữ. Hiện tại, Brandz Quốc Tế là đối tác độc quyền cho hai thương hiệu Kapten ',_binary '\0','CÔNG TY TNHH BRANDZ INTERNATIONAL',NULL,NULL),('4b641896-708e-44fa-ba38-6ae2255d202b','Hà Đông, Hà Nội',NULL,'2022-11-24 23:58:25','Đơn vị chuyên cung cấp tã,bỉm Merries nội địa Nhật (hàng cộng miếng) cho các đại lý,nhà phân phối,siêu thị,cửa hàng... khắp các tỉnh thành,giá cả cạnh tranh.',_binary '\0','Công ty CPTP XNK TINH HOA VIỆT',NULL,NULL),('a71787e9-2ce2-4e2c-9120-a9822b097d15','Hoàn Kiếm, Hà Nội',NULL,'2022-11-25 00:02:32','Vì ngành nông nghiệp Việt Nam hiện đại và trong sạch, INARI hướng đến cung cấp các sản phẩm từ trùn quế chất lượng cao, giá thành phù hợp để đáp ứng cho nhu cầu nông nghiệp hiện tại và trong tương lai.',_binary '\0','CÔNG TY CP THƯƠNG MẠI NÔNG NGHIỆP VÀ PHÂN BÓN HỮU CƠ INARI',NULL,NULL),('b7cb2b5b-72b6-4214-9f9d-5d0c74b4f3f7','Tân Bình, Tp.HCM',NULL,'2022-11-25 00:00:31','Công Ty TNHH TM DV UP\nPhân phối độc quyền tại Việt Nam các sản phẩm bánh kẹo nhập khẩu từ Indonesia, Thái Lan...',_binary '\0','Công ty TNHH TM DV UP',NULL,NULL);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token` (
  `id` varchar(255) NOT NULL,
  `confirm_date` datetime DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `expires_date` datetime NOT NULL,
  `token_code` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe32ek7ixanakfqsdaokm4q9y2` (`user_id`),
  CONSTRAINT `FKe32ek7ixanakfqsdaokm4q9y2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES ('41cbe4a9-628b-45f6-9bc6-3e5c38a27397','2022-11-25 00:30:56','2022-11-25 00:30:32','2022-11-26 00:30:32','2f7be1df-76d3-42b2-a689-414285b959e5','49f2cfe1-383f-4657-9b4f-0ba1c4372a07'),('a730f803-5af2-49b8-a3c0-6300a176d803','2022-11-24 23:46:40','2022-11-24 23:46:00','2022-11-25 23:46:00','1e5a1cff-f5bd-4e1d-9d0e-1a7f473b21a6','767fc8b3-1abd-48c5-ae52-69d3f4486996');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `locked` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('2f181fb6-493d-469f-9ce0-f68c848baeae','Toan Le','2022-11-24 23:45:26','lvtoan.it2000@gmail.com',_binary '',_binary '\0','$2a$10$sD/cq29sCuDzKBmS0jVpcO5VzUuRz65jSw1LAVcpUBYT7.vOrOt2S','ADMIN',NULL,NULL,'lvtoan'),('49f2cfe1-383f-4657-9b4f-0ba1c4372a07','Toan CV','2022-11-25 00:30:32','lvtoan.cv@gmail.com',_binary '',_binary '\0','$2a$10$g9T86UhVdxihlUYgHkByV.OlCymnP3aqyUNVeExHEj/Xr3wWl1XKK','CUSTOMER',NULL,NULL,'lvtoancv'),('767fc8b3-1abd-48c5-ae52-69d3f4486996','Toan Van','2022-11-24 23:46:00','vantoan10c2@gmail.com',_binary '',_binary '\0','$2a$10$8tvo62xE3U4HVyyvdKsRgOY5slzhsSKPQOYcmovAy.kcueZMptYlu','CUSTOMER',NULL,NULL,'vantoan'),('f589f12f-e022-4125-8a2a-b3f43dd51bd2','Admin account','2022-11-24 23:45:26','admin@gmail.com',_binary '',_binary '\0','$2a$10$onc2iQCeJgnK/XQVEb2RIOA/Suwl8R1YqfVSSxscndbHDocGfxVHe','ADMIN',NULL,NULL,'admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-25 16:35:35
