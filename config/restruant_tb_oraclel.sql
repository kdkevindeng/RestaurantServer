-- -----------2015/11/26-------
-- Create the user
-- ----------------------------
create user restaurant
  identified by restaurant;
-- Grant/Revoke role privileges 
grant connect to restaurant;
grant resource to restaurant;
grant dba to restaurant;

-- ----------------------------
-- Table structure for ads
-- ----------------------------
CREATE TABLE ads (
  id varchar2(255) NOT NULL ,
  mc varchar2(255) DEFAULT NULL,
  userid varchar2(255) DEFAULT NULL,
  url varchar2(255) DEFAULT NULL,
  photo varchar2(255) DEFAULT NULL,
  begintime date DEFAULT NULL,
  endtime date DEFAULT NULL,
  isuse varchar2(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ;

-- ----------------------------
-- Records of ads
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
CREATE TABLE news (
  id varchar2(255) NOT NULL ,
  title varchar2(255) DEFAULT NULL,
  content varchar2(255) DEFAULT NULL,
  author varchar2(255) DEFAULT NULL,
  createtime date DEFAULT NULL,
  alertuser varchar2(255) DEFAULT NULL,
  alerttime date DEFAULT NULL,
  isuse varchar2(255) DEFAULT NULL,
  fujian_mc varchar2(255) DEFAULT NULL,
  fujian_url varchar2(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ;

-- ----------------------------
-- Records of news
-- ----------------------------

-- ----------------------------
-- Table structure for ordermx
-- ----------------------------
CREATE TABLE ordermx (
  id varchar2(255) NOT NULL ,
  orderid varchar2(255) DEFAULT NULL,
  productid varchar2(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ;

-- ----------------------------
-- Records of ordermx
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
CREATE TABLE orders (
  id varchar2(255) NOT NULL ,
  userid varchar2(255) DEFAULT NULL,
  productid varchar2(255) DEFAULT NULL,
  createtime date DEFAULT NULL,
  createuser varchar2(255) DEFAULT NULL,
  alerttime date DEFAULT NULL,
  alertuser varchar2(255) DEFAULT NULL,
  state varchar2(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
CREATE TABLE permission (
  PERMISSION_DM varchar2(255) NOT NULL ,
  PERMISSION_MC varchar2(255) DEFAULT NULL,
  URL varchar2(255) DEFAULT NULL,
  CREATE_DATE date DEFAULT NULL,
  CREATE_USER varchar2(255) DEFAULT NULL,
  DESCRIBES varchar2(255) DEFAULT NULL,
  BEIZHU varchar2(255) DEFAULT NULL,
  ALERT_DATE date DEFAULT NULL,
  ALERT_USER varchar2(255) DEFAULT NULL,
  ISUSE varchar2(255) DEFAULT NULL,
  PARENTCODE varchar2(255) DEFAULT NULL,
  PRIMARY KEY (PERMISSION_DM)
) ;


-- ----------------------------
-- Table structure for product
-- ----------------------------
CREATE TABLE product (
  productid varchar2(255) NOT NULL ,
  mc varchar2(255) DEFAULT NULL,
  price varchar2(255) DEFAULT NULL,
  photo varchar2(255) DEFAULT NULL,
  create_date date DEFAULT NULL,
  create_user varchar2(255) DEFAULT NULL,
  alter_date date DEFAULT NULL,
  alter_user varchar2(255) DEFAULT NULL,
  PRIMARY KEY (productid)
) ;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
CREATE TABLE role (
  role_dm varchar2(255) NOT NULL ,
  role_mc varchar2(255) DEFAULT NULL,
  isuse varchar2(255) DEFAULT NULL,
  createtime date DEFAULT NULL,
  createuser varchar2(255) DEFAULT NULL,
  alerttime date DEFAULT NULL,
  alertuser varchar2(255) DEFAULT NULL,
  beizhu varchar2(255) DEFAULT NULL,
  PRIMARY KEY (role_dm)
) ;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
CREATE TABLE role_permission (
  id varchar2(255) NOT NULL ,
  roleid varchar2(255) DEFAULT NULL,
  permissionid varchar2(255) DEFAULT NULL,
  describle varchar2(255) DEFAULT NULL,
  createtime date DEFAULT NULL,
  createuser varchar2(255) DEFAULT NULL,
  isuse varchar2(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ;


-- ----------------------------
-- Table structure for stru
-- ----------------------------
CREATE TABLE stru (
  jg_dm varchar2(255) NOT NULL ,
  jg_mc varchar2(255) DEFAULT NULL,
  is_use varchar2(255) DEFAULT NULL,
  parent_jgdm varchar2(255) DEFAULT NULL,
  create_date date DEFAULT NULL,
  create_user varchar2(255) DEFAULT NULL,
  alter_date date DEFAULT NULL,
  alter_user varchar2(255) DEFAULT NULL,
  beizhu varchar2(255) DEFAULT NULL,
  PRIMARY KEY (jg_dm)
) ;


-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE users (

  id     varchar2(255) not NULL,
  userid varchar2(255) NOT NULL  ,
  username varchar2(255) DEFAULT NULL ,
  password varchar2(255) DEFAULT NULL,
  telphone varchar2(255) DEFAULT NULL,
  email varchar2(255) DEFAULT NULL,
  qq varchar2(255) DEFAULT NULL,
  weixin varchar2(255) DEFAULT NULL,
  sex varchar2(255) DEFAULT NULL,
  occupation varchar2(255) DEFAULT NULL ,
  age varchar2(255) DEFAULT NULL,
  logo varchar2(255) DEFAULT '',
  state varchar2(255) DEFAULT NULL ,
  isuse varchar2(255) DEFAULT NULL,
  JGNM varchar2(255) DEFAULT NULL,
  type varchar2(255) DEFAULT NULL,
  create_date date DEFAULT NULL,
  create_user varchar2(255) DEFAULT NULL,
  alter_date date DEFAULT NULL,
  alter_user varchar2(255) DEFAULT NULL,
  domain varchar2(255) DEFAULT NULL,
  homepage varchar2(255) DEFAULT NULL,
  PRIMARY KEY (ID)
) ;


-- ----------------------------
-- Table structure for user_role
-- ----------------------------
CREATE TABLE user_role (
  id varchar2(255) NOT NULL ,
  userid varchar2(255) DEFAULT NULL,
  roleid varchar2(255) DEFAULT NULL,
  describle varchar2(255) DEFAULT NULL,
  createuser varchar2(255) DEFAULT NULL,
  createtime date DEFAULT NULL,
  PRIMARY KEY (id)
) ;


-- ----------------------------
-- Table structure for vip
-- ----------------------------
CREATE TABLE vip (
  id varchar2(255) NOT NULL ,
  customerid varchar2(255) DEFAULT NULL,
  bossid varchar2(255) DEFAULT NULL,
  isuse varchar2(255) DEFAULT NULL,
  score varchar2(255) DEFAULT NULL,
  create_date date DEFAULT NULL,
  create_user varchar2(255) DEFAULT NULL,
  alter_date date DEFAULT NULL,
  alter_user varchar2(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ;

