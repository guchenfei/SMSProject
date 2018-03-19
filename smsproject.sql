/*
Navicat MySQL Data Transfer

Source Server         : temp
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : smsproject

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-03-19 14:50:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户名主键',
  `userName` varchar(255) NOT NULL COMMENT '用户名',
  `userPass` varchar(255) NOT NULL COMMENT '密码',
  `userSex` int(11) NOT NULL COMMENT '男0女1（性别）',
  `userBirthday` varchar(255) NOT NULL COMMENT '生日',
  `userPNum` varchar(255) NOT NULL COMMENT '手机号码',
  `userAddress` varchar(255) NOT NULL COMMENT '联系地址',
  `userEmail` varchar(255) NOT NULL COMMENT '邮箱',
  `userType` int(11) NOT NULL COMMENT '权限角色：0表示超级管理员，1表示普通管理员，2表示业务员',
  `cpy_id` int(11) NOT NULL COMMENT '所属公司',
  PRIMARY KEY (`admin_id`),
  KEY `fk_admin_cpy` (`cpy_id`) USING BTREE,
  CONSTRAINT `fk_admin_cpy` FOREIGN KEY (`cpy_id`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '谷晨飞', '123456', '0', '1996-09-13', '13383526652', '山西大同', '389443465@qq.com', '0', '1');
INSERT INTO `admin` VALUES ('2', '李明明', '258258', '1', '1997-07-23', '15336255623', '山西运城', '895564254@qq.com', '1', '1');
INSERT INTO `admin` VALUES ('3', '王华', '568952', '0', '1998-08-11', '15365256325', '山西长治', '1354633525@qq.com', '1', '2');
INSERT INTO `admin` VALUES ('4', '李磊', '135123', '1', '1999-09-11', '13515621265', '北京海淀区', '1562152152@qq.com', '1', '3');
INSERT INTO `admin` VALUES ('5', '赵敏', '132653', '1', '1993-02-23', '15232452154', '北京昌平区', '1531525215@qq.com', '1', '4');
INSERT INTO `admin` VALUES ('6', '程功', '152351', '0', '1993-05-25', '15235125125', '上海浦东区', '1561163156@qq.com', '1', '5');
INSERT INTO `admin` VALUES ('7', '范敏', '156252', '1', '1993-07-06', '15615658258', '山西吕梁', '1562516252@qq.com', '2', '1');
INSERT INTO `admin` VALUES ('8', '李明明', '252152', '1', '1993-08-24', '15625264525', '山西阳泉', '6251512151@qq.com', '2', '2');
INSERT INTO `admin` VALUES ('9', '张栋', '156115', '0', '1992-10-25', '15615514262', '山西忻州', '5656161561@qq.com', '2', '3');
INSERT INTO `admin` VALUES ('10', '张华', '161615', '1', '1995-02-12', '19915625421', '山西运城', '1256855615@qq.com', '2', '4');
INSERT INTO `admin` VALUES ('11', '张敏', '616561', '1', '1992-06-13', '18916152521', '北京顺义区', '1616156163@qq.com', '2', '5');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `company_id` int(11) NOT NULL,
  `companyName` varchar(255) NOT NULL COMMENT '1：北京总部，2：西安分公司，3：上海分公司，4：成都分公司，5南京分公司；',
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '北京总部');
INSERT INTO `company` VALUES ('2', '西安分公司');
INSERT INTO `company` VALUES ('3', '上海分公司');
INSERT INTO `company` VALUES ('4', '成都分公司');
INSERT INTO `company` VALUES ('5', '南京分公司');

-- ----------------------------
-- Table structure for contacts
-- ----------------------------
DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `conName` varchar(255) NOT NULL COMMENT '姓名',
  `conSex` int(11) NOT NULL COMMENT '男0女1',
  `conBirthday` varchar(255) NOT NULL COMMENT '生日',
  `conPhoneNum` varchar(255) NOT NULL COMMENT '手机号码',
  `conAddress` varchar(255) NOT NULL COMMENT '联系地址',
  `conEmail` varchar(255) NOT NULL COMMENT '邮箱',
  `conCompany` int(11) NOT NULL COMMENT ' 1：北京总部，2：西安分公司，3：上海分公司，4：成都分公司，5南京分公司；',
  PRIMARY KEY (`contact_id`),
  KEY `fk_con_cpy` (`conCompany`) USING BTREE,
  CONSTRAINT `fk_con_cpy` FOREIGN KEY (`conCompany`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contacts
-- ----------------------------
INSERT INTO `contacts` VALUES ('1', '张华', '0', '1996-10-23', '13512624521', '山西大同', '389445566@qq.com', '1');
INSERT INTO `contacts` VALUES ('2', '王宁', '0', '1996-12-11', '15616516515', '山西长治', '161616828@qq.com', '1');
INSERT INTO `contacts` VALUES ('3', '程宁1', '1', '1992-12-13', '16168825525', '山西运城', '153135156@qq.com', '2');
INSERT INTO `contacts` VALUES ('4', '程宁2', '0', '1996-10-26', '18956156156', '山西吕梁', '1651616128@qq.com', '2');
INSERT INTO `contacts` VALUES ('5', '张达达1', '0', '1994-10-23', '15615516511', '山西吕梁', '1641651616@qq.com', '3');
INSERT INTO `contacts` VALUES ('6', '张达达2', '1', '1995-10-16', '15615616582', '山西长治', '1646156155@qq.com', '3');
INSERT INTO `contacts` VALUES ('7', '王明1', '0', '1996-12-13', '15626485258', '山西运城', '1561523555@qq.com', '4');
INSERT INTO `contacts` VALUES ('8', '王明2', '1', '1996-12-11', '15625254262', '山西阳泉', '1615615585@qq.com', '4');
INSERT INTO `contacts` VALUES ('9', '李敏1', '1', '1995-10-13', '13515615652', '山西大同', '2611561655@qq.com', '5');
INSERT INTO `contacts` VALUES ('10', '李敏2', '0', '1994-12-11', '15261615625', '山西太原', '1665161156@qq.com', '5');

-- ----------------------------
-- Table structure for sended
-- ----------------------------
DROP TABLE IF EXISTS `sended`;
CREATE TABLE `sended` (
  `SRecord_id` int(11) NOT NULL AUTO_INCREMENT,
  `ad_id` int(11) NOT NULL COMMENT '用户编号外键关联到用户ID',
  `receivePhone` varchar(255) NOT NULL COMMENT '接收号码',
  `deliveryStatus` int(11) NOT NULL COMMENT '发送状态',
  `errorInfo` varchar(255) NOT NULL COMMENT '错误信息',
  `smsContent` varchar(255) NOT NULL COMMENT '短信内容',
  `sendTime` varchar(255) NOT NULL COMMENT '发送时间',
  PRIMARY KEY (`SRecord_id`),
  KEY `fk_sen_adm` (`ad_id`) USING BTREE,
  CONSTRAINT `fk_sen_adm` FOREIGN KEY (`ad_id`) REFERENCES `admin` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sended
-- ----------------------------
INSERT INTO `sended` VALUES ('1', '1', '13386235621', '1', '0', '国庆节快乐！', '1996-10-13 14:12:11');
