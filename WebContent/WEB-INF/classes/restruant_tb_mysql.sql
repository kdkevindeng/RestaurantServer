-- -----------2015/11/26-----------------
-- Table structure for `ads`
-- ----------------------------
DROP TABLE IF EXISTS `ads`;
CREATE TABLE `ads` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `mc` varchar(255) DEFAULT NULL,
  `userid` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `begintime` date DEFAULT NULL,
  `endtime` date DEFAULT NULL,
  `isuse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ads
-- ----------------------------

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `alertuser` varchar(255) DEFAULT NULL,
  `alerttime` date DEFAULT NULL,
  `isuse` varchar(255) DEFAULT NULL,
  `fujian_mc` varchar(255) DEFAULT NULL,
  `fujian_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------

-- ----------------------------
-- Table structure for `ordermx`
-- ----------------------------
DROP TABLE IF EXISTS `ordermx`;
CREATE TABLE `ordermx` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `orderid` varchar(255) DEFAULT NULL,
  `productid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordermx
-- ----------------------------

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `userid` varchar(255) DEFAULT NULL,
  `productid` varchar(255) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `createuser` varchar(255) DEFAULT NULL,
  `alerttime` date DEFAULT NULL,
  `alertuser` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `PERMISSION_DM` varchar(255) NOT NULL DEFAULT '',
  `PERMISSION_MC` varchar(255) DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `CREATE_DATE` date DEFAULT NULL,
  `CREATE_USER` varchar(255) DEFAULT NULL,
  `DESCRIBES` varchar(255) DEFAULT NULL,
  `BEIZHU` varchar(255) DEFAULT NULL,
  `ALERT_DATE` date DEFAULT NULL,
  `ALERT_USER` varchar(255) DEFAULT NULL,
  `ISUSE` varchar(255) DEFAULT NULL,
  `PARENTCODE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PERMISSION_DM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productid` varchar(255) NOT NULL DEFAULT '',
  `mc` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `alter_date` date DEFAULT NULL,
  `alter_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_dm` varchar(255) NOT NULL DEFAULT '',
  `role_mc` varchar(255) DEFAULT NULL,
  `isuse` varchar(255) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `createuser` varchar(255) DEFAULT NULL,
  `alerttime` date DEFAULT NULL,
  `alertuser` varchar(255) DEFAULT NULL,
  `beizhu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_dm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `roleid` varchar(255) DEFAULT NULL,
  `permissionid` varchar(255) DEFAULT NULL,
  `describle` varchar(255) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `createuser` varchar(255) DEFAULT NULL,
  `isuse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `stru`
-- ----------------------------
DROP TABLE IF EXISTS `stru`;
CREATE TABLE `stru` (
  `jg_dm` varchar(255) NOT NULL DEFAULT '',
  `jg_mc` varchar(255) DEFAULT NULL,
  `is_use` varchar(255) DEFAULT NULL,
  `parent_jgdm` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `alter_date` date DEFAULT NULL,
  `alter_user` varchar(255) DEFAULT NULL,
  `beizhu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`jg_dm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stru
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` varchar(255) NOT NULL DEFAULT '' COMMENT '鐢ㄦ埛ID',
  `username` varchar(255) DEFAULT NULL COMMENT '鍚嶇О',
  `password` varchar(255) DEFAULT NULL,
  `telphone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `weixin` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `occupation` varchar(255) DEFAULT NULL COMMENT '鑱屼笟',
  `age` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT '澶村儚',
  `state` varchar(255) DEFAULT NULL COMMENT '鐘舵�',
  `isuse` varchar(255) DEFAULT NULL,
  `JGNM` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `alter_date` date DEFAULT NULL,
  `alter_user` varchar(255) DEFAULT NULL,
  `domain` varchar(255) DEFAULT NULL,
  `homepage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `userid` varchar(255) DEFAULT NULL,
  `roleid` varchar(255) DEFAULT NULL,
  `describle` varchar(255) DEFAULT NULL,
  `createuser` varchar(255) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `vip`
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `customerid` varchar(255) DEFAULT NULL,
  `bossid` varchar(255) DEFAULT NULL,
  `isuse` varchar(255) DEFAULT NULL,
  `score` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `alter_date` date DEFAULT NULL,
  `alter_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

