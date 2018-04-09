/*
Navicat MySQL Data Transfer

Source Server         : temp
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : smsproject

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-04-09 23:37:50
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
  UNIQUE KEY `email_unique` (`userEmail`) USING BTREE COMMENT '邮箱唯一性约束',
  KEY `fk_admin_cpy` (`cpy_id`) USING BTREE,
  CONSTRAINT `fk_admin_cpy` FOREIGN KEY (`cpy_id`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('2', '李明明', '123456', '1', '1997-07-23', '15336255623', '山西运城', '456@qq.com', '0', '1');
INSERT INTO `admin` VALUES ('3', '王华', '111222', '0', '1998-08-11', '15365256325', '山西长治', '111@qq.com', '0', '2');
INSERT INTO `admin` VALUES ('4', '李磊', '135123', '1', '1999-09-11', '13515621265', '北京海淀区', '1562152152@qq.com', '1', '3');
INSERT INTO `admin` VALUES ('5', '赵敏', '132653', '1', '1993-02-23', '15232452154', '北京昌平区', '1531525215@qq.com', '1', '4');
INSERT INTO `admin` VALUES ('6', '程功', '152351', '0', '1993-05-25', '15235125125', '上海浦东区', '1561163156@qq.com', '1', '5');
INSERT INTO `admin` VALUES ('7', '范敏', '222', '1', '1993-07-06', '15615658258', '山西吕梁', '222@qq.com', '2', '1');
INSERT INTO `admin` VALUES ('8', '李明明', '252152', '1', '1993-08-24', '15625264525', '山西阳泉', '6251512151@qq.com', '2', '2');
INSERT INTO `admin` VALUES ('9', '张栋', '156115', '0', '1992-10-25', '15615514262', '山西忻州', '5656161561@qq.com', '2', '3');
INSERT INTO `admin` VALUES ('12', '林佳', '156165', '1', '1993-10-13', '15625616158', '北京丰台区', '161561651@qq.com', '2', '1');
INSERT INTO `admin` VALUES ('13', '张伟', '161565', '1', '1993-11-12', '18625625621', '天津市', '1256115615@qq.com', '2', '2');
INSERT INTO `admin` VALUES ('14', '温勇', '161655', '0', '1995-12-11', '18932156155', '上海浦东区', '1616516566@qq.com', '2', '3');
INSERT INTO `admin` VALUES ('16', '雷磊', '461651', '0', '1995-07-12', '13362616168', '天津市', '2616516165@qq.com', '2', '4');
INSERT INTO `admin` VALUES ('19', '用户2', '123', '1', '1992-10-11', '13365234512', '北京市海淀区', '1236@qq.com', '2', '3');
INSERT INTO `admin` VALUES ('20', '用户3', '123', '1', '1992-10-11', '13365234512', '北京市海淀区', '1235@qq.com', '2', '3');
INSERT INTO `admin` VALUES ('24', '用户7', '123', '1', '1992-10-11', '13365234512', '北京市海淀区', '1275223@qq.com', '2', '3');

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
INSERT INTO `company` VALUES ('6', '沈阳分公司');

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
  UNIQUE KEY `email_unique` (`conEmail`) USING BTREE,
  KEY `fk_con_cpy` (`conCompany`) USING BTREE,
  CONSTRAINT `fk_con_cpy` FOREIGN KEY (`conCompany`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contacts
-- ----------------------------
INSERT INTO `contacts` VALUES ('1', '张华', '0', '1996-10-23', '13512624521', '山西大同', '389445566@qq.com', '1');
INSERT INTO `contacts` VALUES ('2', '王宁', '0', '1996-12-11', '15616516515', '山西长治', '161616828@qq.com', '1');
INSERT INTO `contacts` VALUES ('3', '程宁1', '1', '1992-12-13', '16168825525', '山西运城', '153135156@qq.com', '2');
INSERT INTO `contacts` VALUES ('4', '程宁2', '0', '1996-10-26', '18956156156', '山西吕梁', '1651616128@qq.com', '2');
INSERT INTO `contacts` VALUES ('6', '张达达2', '1', '1995-10-16', '15615616582', '山西长治', '1646156155@qq.com', '3');
INSERT INTO `contacts` VALUES ('7', '王明1', '0', '1996-12-13', '15626485258', '山西运城', '1561523555@qq.com', '4');
INSERT INTO `contacts` VALUES ('8', '王明2', '1', '1996-12-11', '15625254262', '山西阳泉', '1615615585@qq.com', '4');
INSERT INTO `contacts` VALUES ('9', '李敏1', '1', '1995-10-13', '13515615652', '山西大同', '2611561655@qq.com', '5');
INSERT INTO `contacts` VALUES ('10', '李敏2', '0', '1994-12-11', '15261615625', '山西太原', '1665161156@qq.com', '5');
INSERT INTO `contacts` VALUES ('11', '王华', '0', '1995-10-22', '13522223333', '山西太原', '25616165@qq.com', '1');
INSERT INTO `contacts` VALUES ('12', '李敏', '1', '1995-12-11', '13544446666', '北京朝阳', '1616156@qq.com', '2');
INSERT INTO `contacts` VALUES ('14', '张华', '1', '1995-12-11', '18711112222', '北京朝阳', '16161562@qq.com', '1');
INSERT INTO `contacts` VALUES ('15', '李敏3', '1', '1995-10-13', '18956552233', '北京丰台', '15616156@qq.com', '1');
INSERT INTO `contacts` VALUES ('16', '张伟', '0', '1996-12-11', '18822225555', '北京海淀', '15615616@qq.com', '2');
INSERT INTO `contacts` VALUES ('17', '陈东', '0', '1995-12-11', '18756235252', '山西太原', '156156258@qq.com', '3');
INSERT INTO `contacts` VALUES ('18', '陈明', '0', '1995-10-13', '13925262545', '山西运城', '6515616@qq.com', '3');
INSERT INTO `contacts` VALUES ('19', '林志', '1', '1996-05-13', '13896541236', '山西大同', '16165165@qq.com', '4');
INSERT INTO `contacts` VALUES ('20', '林玲', '1', '1994-10-24', '13616161652', '河北张家口', '8916156@qq.com', '4');
INSERT INTO `contacts` VALUES ('25', '任何', '1', '2018-03-13', '13622223333', '北京海淀区', 'bsa@qq.com', '5');
INSERT INTO `contacts` VALUES ('29', '李宁1', '0', '2018-11-11', '13511112222', '北京海淀区', 'sgbiu@qq.com', '1');
INSERT INTO `contacts` VALUES ('30', '李宁2', '0', '1996-10-15', '13616162525', '北京海淀区', 'hfsidv@qq.com', '1');
INSERT INTO `contacts` VALUES ('31', '李宁3', '0', '1995-10-24', '13515152626', '北京海淀区', 'huish@qq.com', '1');
INSERT INTO `contacts` VALUES ('32', '李宁4', '0', '1996-10-13', '13646461515', '北京海淀区', 'ofhgs@qq.com', '1');
INSERT INTO `contacts` VALUES ('33', '李宁5', '0', '1994-12-10', '13715152626', '北京海淀区', 'hgia@qq.com', '1');
INSERT INTO `contacts` VALUES ('34', '李宁6', '0', '1997-10-11', '13515152626', '北京海淀区', 'vsih@qq.com', '1');
INSERT INTO `contacts` VALUES ('35', '李宁7', '0', '1998-12-11', '13626261515', '北京海淀区', 'fdg@qq.com', '1');
INSERT INTO `contacts` VALUES ('36', '李宁8', '0', '1996-10-11', '13515161615', '北京海淀区', 'hgh@qq.com', '1');
INSERT INTO `contacts` VALUES ('37', '李宁9', '0', '1998-10-20', '13515161682', '北京海淀区', 'ghei@qq.com', '1');
INSERT INTO `contacts` VALUES ('38', '李宁10', '0', '1995-12-11', '13626161552', '北京海淀区', 'ghsh@qq.com', '1');
INSERT INTO `contacts` VALUES ('39', '李宁11', '0', '1996-10-11', '13716161156', '北京海淀区', 'gheih@qq.com', '1');
INSERT INTO `contacts` VALUES ('40', '李宁12', '0', '1998-12-11', '13825611562', '北京海淀区', 'ghiueah@qq.com', '1');
INSERT INTO `contacts` VALUES ('41', '李宁13', '0', '1995-10-15', '13515616185', '北京海淀区', 'sghi@qq.com', '1');
INSERT INTO `contacts` VALUES ('42', '李宁14', '1', '1996-12-11', '13515156825', '北北京海淀区', 'garekh@qq.com', '1');
INSERT INTO `contacts` VALUES ('43', '李宁15', '0', '1997-12-11', '13615161652', '北京海淀区', 'bskh@qq.com', '1');
INSERT INTO `contacts` VALUES ('44', '李宁16', '0', '1998-10-12', '13525251515', '北京海淀区', 'trh@qq.com', '1');
INSERT INTO `contacts` VALUES ('45', '李宁17', '0', '1992-12-11', '13515153615', '北京海淀区', 'gjoej@qq.com', '1');
INSERT INTO `contacts` VALUES ('46', '李宁18', '0', '1996-12-11', '13612356456', '北京海淀区', 'gakh@qq.com', '1');
INSERT INTO `contacts` VALUES ('47', '谷晨飞', '0', '1995-10-15', '18910386873', '北京海淀区', 'vbeaus@qq.com', '6');
INSERT INTO `contacts` VALUES ('48', '林艳丽', '1', '1996-10-15', '15810691167', '北京海淀区', 'haise@qq.com', '6');
INSERT INTO `contacts` VALUES ('49', '赵磊', '0', '1996-10-22', '15735655334', '北京海淀区', 'gesoh@qq.com', '6');

-- ----------------------------
-- Table structure for festivaltemp
-- ----------------------------
DROP TABLE IF EXISTS `festivaltemp`;
CREATE TABLE `festivaltemp` (
  `festival_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `festival_name` varchar(255) NOT NULL COMMENT '节日名',
  `templateCon` varchar(900) NOT NULL COMMENT '模板内容',
  PRIMARY KEY (`festival_id`),
  UNIQUE KEY `festival_nameUnique` (`festival_name`) USING BTREE COMMENT '节日名唯一约束'
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of festivaltemp
-- ----------------------------
INSERT INTO `festivaltemp` VALUES ('1', '元旦1', ' 愁烦随着缓缓时光，慢慢溜走，悲伤随着辞岁迎新，彻底消失；快乐伴着璀璨烟花，彻底绽放；好运伴着美酒，绵绵无期；问候随着短信，温馨送到；祝福伴着真挚，甜你心间。亲爱的朋友，祝你元旦快乐，福星高照！');
INSERT INTO `festivaltemp` VALUES ('2', '元旦2', ' 让元旦的欢乐驱走你生活的疲惫，让你的心灵跟随节日气氛一起陶醉；愿假期的休息带给你精力充沛，愿你节后上班信心百倍！祝你生活美丽、工作顺利！');
INSERT INTO `festivaltemp` VALUES ('4', '春节1', '有一种快乐叫做乐观，有一种幸福叫做知足，有一种痛苦叫做狭隘，有一种收获叫做信念，有一种坚持叫做执着，有一种情谊叫做惦记。春节，愿你称心如意!');
INSERT INTO `festivaltemp` VALUES ('5', '春节2', '大年三十赞歌唱，鞭炮烟花响不断。欢呼雀跃盛世年，灯火辉煌笑声甜。家宴大餐聚团圆，幸福美满一家欢。陪伴老人守岁年，通宵达旦迎朝阳。新春多快乐!');
INSERT INTO `festivaltemp` VALUES ('6', '劳动节1', ' 五一劳动节将到，温馨贴士送你五个礼，第一，健康开心见面礼，第二，幸福美满大回礼，第三，工作顺利幸运礼，第四，甜美爱情神秘礼，第五，生活如意节日礼。提前祝你五一快乐！');
INSERT INTO `festivaltemp` VALUES ('7', '劳动节2', '抓住轻松的美妙，揪住快乐的美好，揽住温馨的嬉闹，高举甜蜜的欢笑；甩掉烦恼的骚扰，驱赶失意的苦恼，践踏压力的跟跑，避开困苦的盘绕。五一劳动节将到，扑入大自然的怀抱，愿你五一劳动节，拥有轻爽不少，常伴欢乐不消！');
INSERT INTO `festivaltemp` VALUES ('8', '端午节1', ' 有一种快乐，漂漂洒洒；有一种自在，平平淡淡；有一种幸福，安安静静；有一种拥有，实实在在；有一种友谊，长长久久；有一个你，我天天祝福。祝端午节快乐！');
INSERT INTO `festivaltemp` VALUES ('9', '端午节2', ' 一粒粒糯米，粘稠着我的思念；一颗颗红枣，点缀着日子的红艳；一片片粽叶，贴上了幸福的标签；一圈圈丝线，缠绕着美好心愿；一个个粽子，包裹着幸福万千；一口口品尝着，生活的香甜。祝你端午节快乐无限！');
INSERT INTO `festivaltemp` VALUES ('10', '中秋节1', ' 圆圆的月儿天上挂，圆圆的月饼香天涯，圆圆的快乐美如花，圆圆的祝福到你家：美满日子玉润珠圆，幸福生活花好月圆，合家吉祥永团圆。节日快乐！');
INSERT INTO `festivaltemp` VALUES ('11', '中秋节2', ' 月儿圆圆挂天边，荷叶圆圆水中间。梦想圆圆都实现，成功圆圆舞翩跹。快乐圆圆永不变，祝福圆圆情无限，中秋花好月又圆，幸福与你两团圆。信短情长言未尽，唯愿朋友多安康。中秋到了，祝节日快乐，合家团圆！');
INSERT INTO `festivaltemp` VALUES ('12', '国庆节1', '不是每朵白云，都会带来真情；不是每个拥抱，都会面带微笑；不是每次思念，都能立刻兑现；不是每个朋友，都在身边守候；不是每个日子，都逢良辰吉时。国庆节到了，愿你节日快乐！');
INSERT INTO `festivaltemp` VALUES ('13', '国庆节2', ' 都说家是小的国，国是大的家，家国从来不分离。国庆也是家庆，喜庆普天同庆。看欢乐烟花绚丽，赏好运日子美丽。朋友，衷心祝愿你“大的家”国泰民安康，祝你“小的国”家庭更幸福。祝国庆快乐！');
INSERT INTO `festivaltemp` VALUES ('14', '圣诞节1', ' 美酒醇，火鸡香，吉祥伴着雪花飞；苹果红，炉火旺，鸿运随着烟花来；歌声飘，钟声荡，平安围着青松绕。圣诞节，在你的圣诞袜里，我装了一条祝福短信，愿你节日快乐，心想事成。');
INSERT INTO `festivaltemp` VALUES ('15', '圣诞节2', ' 圣诞老人是一个美丽的传说，七彩礼物装满背包，只有相信美好的人才能看到；圣诞欢歌是一曲精彩的演奏，高低起伏婉转悠扬，只有满心欢乐的人才能感知它的美妙；温馨祝福是一首动人的歌谣，真挚情谊传唱到老，只有我最好的朋友才能收到。愿你圣诞快乐，幸福逍遥！');

-- ----------------------------
-- Table structure for sendedrec
-- ----------------------------
DROP TABLE IF EXISTS `sendedrec`;
CREATE TABLE `sendedrec` (
  `SRecord_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `receCompanyId` int(11) NOT NULL COMMENT '接收公司id',
  `topic` varchar(255) NOT NULL COMMENT '任务主题',
  `describe` varchar(600) NOT NULL COMMENT '任务描述',
  `creator_id` int(11) NOT NULL COMMENT '创建人ID',
  `massType` int(11) NOT NULL COMMENT '群发类型:0立即发送，1定时发送',
  `createTime` varchar(255) NOT NULL COMMENT '创建时间',
  `reserveTime` varchar(255) NOT NULL COMMENT '定时发送时间',
  `smsCon` varchar(900) NOT NULL COMMENT '短信内容',
  PRIMARY KEY (`SRecord_id`),
  KEY `fk_sendedRec_Company` (`receCompanyId`),
  KEY `fk_sendedRec_admin` (`creator_id`),
  CONSTRAINT `fk_sendedRec_Company` FOREIGN KEY (`receCompanyId`) REFERENCES `company` (`company_id`),
  CONSTRAINT `fk_sendedRec_admin` FOREIGN KEY (`creator_id`) REFERENCES `admin` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sendedrec
-- ----------------------------
INSERT INTO `sendedrec` VALUES ('1', '1', '五一慰问', '五一假期给员工慰问下', '2', '0', '2018-5-1 8:0:0', '立即发送', '五一假期到了，祝各位五一快乐！');
