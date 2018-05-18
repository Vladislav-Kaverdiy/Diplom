package diploma.com.database;

public interface DBCreateTables {

    String SQL_CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS `users` (\n" +
            "  `user_id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `full_name` varchar(45) DEFAULT NULL,\n" +
            "  `email` varchar(45) DEFAULT NULL,\n" +
            "  `login` varchar(45) DEFAULT NULL,\n" +
            "  `password` varchar(45) DEFAULT NULL,\n" +
            "  `register_date` date DEFAULT NULL,\n" +
            "  `role_id` int(11) DEFAULT NULL,\n" +
            "  `blocked` tinyint(1) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`user_id`),\n" +
            "  KEY `role_idx` (`role_id`),\n" +
            "  CONSTRAINT `role` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
            ");"+

            "LOCK TABLES `users` WRITE;\n"+
                    "/*!40000 ALTER TABLE `users` DISABLE KEYS */;\n"+
                    "INSERT INTO `users` VALUES (1,'Vladislav','vladyslav.kaverdii@nure.ua','admin','7cc01437a2a2392242a09fb6ded4d74e','2018-01-21',1,1);";

    String SQL_CREATE_TABLE_ROLES = "CREATE TABLE IF NOT EXISTS `roles` (\n" +
            "  `role_id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `role_name` varchar(45) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`role_id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;\n" +

            "LOCK TABLES `roles` WRITE;\n" +
            "/*!40000 ALTER TABLE `roles` DISABLE KEYS */;\n" +
            "INSERT INTO `roles` VALUES (1,'administrator'),(2,'client');";

    String SQL_CREATE_TABLE_CREDIT_CARDS = "CREATE TABLE IF NOT EXISTS `credit_cards` (\n" +
            "  `credit_card_id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `bill` bigint(15) DEFAULT NULL,\n" +
            "  `credit_card_number` bigint(15) DEFAULT NULL,\n" +
            "  `description` varchar(500) DEFAULT NULL,\n" +
            "  `month_expiration` int(11) DEFAULT NULL,\n" +
            "  `year_expiration` int(11) DEFAULT NULL,\n" +
            "  `cvs` int(11) DEFAULT NULL,\n" +
            "  `blocked` tinyint(1) DEFAULT NULL,\n" +
            "  `balance` double DEFAULT NULL,\n" +
            "  `user_id` int(11) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`credit_card_id`),\n" +
            "  KEY `user_idx` (`user_id`),\n" +
            "  CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
            ");";

    String SQL_CREATE_TABLE_USER_PAYMENTS = "CREATE TABLE IF NOT EXISTS`user_payments` (\n" +
            "  `payment_id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `description` varchar(45) DEFAULT NULL,\n" +
            "  `creation_date` date DEFAULT NULL,\n" +
            "  `state` tinyint(1) DEFAULT NULL,\n" +
            "  `credit_card_id` int(11) DEFAULT NULL,\n" +
            "  `sum` double DEFAULT NULL,\n" +
            "  `recipient_bill` varchar(45) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`payment_id`),\n" +
            "  KEY `stateid_idx` (`state`),\n" +
            "  KEY `cardsid_idx` (`credit_card_id`),\n" +
            "  CONSTRAINT `cardsid` FOREIGN KEY (`credit_card_id`) REFERENCES `credit_cards` (`credit_card_id`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
}
