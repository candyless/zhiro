
CREATE TABLE `user_info` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nickname` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` char(18) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `photoid` int(11) DEFAULT NULL,
  `createdatetime` timestamp NULL DEFAULT NULL,
  `delflage` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `jurisdiction_info` (
  `jurisdictionid` int(11) NOT NULL AUTO_INCREMENT,
  `menuid` int(11) NOT NULL,
  `auth` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `comment` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `parent` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`jurisdictionid`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `role_info` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `createdatetime` timestamp NULL DEFAULT NULL,
  `delflage` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `role_jurisdiction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) NOT NULL,
  `jurisdictionid` int(11) NOT NULL,
  `createTime` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2467 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  `createdatetime` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
