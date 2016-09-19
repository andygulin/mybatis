# mybatis+spring 动态数据源切换+分页

### Init DB

	CREATE TABLE `user` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(20) DEFAULT NULL,
	`age` int(11) DEFAULT NULL,
	`address` varchar(100) DEFAULT NULL,
	`createdAt` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;