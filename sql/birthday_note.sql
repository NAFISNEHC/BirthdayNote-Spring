/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : birthday_note

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 20/10/2019 21:26:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bn_user
-- ----------------------------
DROP TABLE IF EXISTS `bn_user`;
CREATE TABLE `bn_user`  (
  `U_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `USER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `SEX` int(1) NULL DEFAULT NULL COMMENT '性别',
  `PHONE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `BIRTHDAY` date NULL DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`U_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bn_user
-- ----------------------------
INSERT INTO `bn_user` VALUES ('007332a4998f2f6665681d52c440a7e7', '邱艳', 1, '17600666233', '2019-10-20');
INSERT INTO `bn_user` VALUES ('09ea981f0c1ed1a2d8872638c202f8b7', '罗超', 1, '17600666233', '2019-10-27');
INSERT INTO `bn_user` VALUES ('19fe0de6f5d3e63b83185c7f79f1d90a', '常艳', 1, '17873443052', '2019-10-20');
INSERT INTO `bn_user` VALUES ('1c893da302e7a59077bec3a9c8af2206', '康娟', 1, '17873442949', '2019-10-20');
INSERT INTO `bn_user` VALUES ('1daa434548e7576d5176898c14514b74', '龚娜', 1, '17873442949', '2019-10-21');
INSERT INTO `bn_user` VALUES ('1f424be3e80e7df89a2eae986a0b1ca1', '易涛', 1, '17600666233', '2019-10-30');
INSERT INTO `bn_user` VALUES ('201a10502ac0e8ed6c3f6d2be97da8a6', '傅艳', 1, '17600666233', '2019-10-31');
INSERT INTO `bn_user` VALUES ('22c95ca6be42a4e769c1be41571f6aff', '熊静', 1, '17600666233', '2019-11-08');
INSERT INTO `bn_user` VALUES ('29e1f420aa4e706850295ff44a7477b8', '周涛', 1, '17873443052', '2019-10-25');
INSERT INTO `bn_user` VALUES ('2e7c0bd7e4a5f530d11b6dcccb1537ae', '胡刚', 1, '17600666233', '2019-10-20');
INSERT INTO `bn_user` VALUES ('34ee667ba594ebfa4f2f23b0543a1a42', '叶敏', 1, '17600666233', '2019-10-26');
INSERT INTO `bn_user` VALUES ('3503f8c9721db9fb87569ebde7161386', '文涛', 1, '17873442949', '2019-10-22');
INSERT INTO `bn_user` VALUES ('4154db838758d2fa33de9a528162a3a7', '余勇', 1, '17873443052', '2019-10-24');
INSERT INTO `bn_user` VALUES ('41ef44eb31ce0946f9e9ed6babf0d4fb', '顾强', 1, '17600666233', '2019-10-20');
INSERT INTO `bn_user` VALUES ('42d8f1febfd6261623fb78c6246e8e31', '秦艳', 1, '17600666233', '2019-10-20');
INSERT INTO `bn_user` VALUES ('44e57528652b5a2558a9434a7194fa37', '侯勇', 1, '17600666233', '2019-10-22');
INSERT INTO `bn_user` VALUES ('45bcd4b8db559b506494b0c868968e27', '武军', 1, '17873443052', '2019-10-20');
INSERT INTO `bn_user` VALUES ('47613b3fcc5724736fc50d359b593a83', '魏敏', 1, '17873442949', '2019-10-21');
INSERT INTO `bn_user` VALUES ('4870ffd6ca03f0ee36b8b514a928dcb0', '于强', 1, '17873442949', '2019-10-20');
INSERT INTO `bn_user` VALUES ('533dc48ab92ab4e91f3eda666660dcab', '孟丽', 1, '17873443052', '2019-10-20');
INSERT INTO `bn_user` VALUES ('56baa2241e45f0e4a4aec9fa4fabafb1', '郑洋', 1, '17600666233', '2019-10-22');
INSERT INTO `bn_user` VALUES ('57129e0672d56a4e8a24f74e1894f2a3', '武秀兰', 1, '17873442949', '2019-10-22');
INSERT INTO `bn_user` VALUES ('5806e2749ff272cd1409b2b80d588004', '江伟', 1, '17600666233', '2019-10-20');
INSERT INTO `bn_user` VALUES ('657a72846672aa3f9521272400c2c334', '沈超', 1, '17600666233', '2019-10-22');
INSERT INTO `bn_user` VALUES ('67de5d035c895b650edb89abeba1cafa', '沈娜', 1, '17873442949', '2019-10-20');
INSERT INTO `bn_user` VALUES ('68ce6ef48ce445402ecd39871375db3e', '江伟', 1, '17600666233', '2019-10-21');
INSERT INTO `bn_user` VALUES ('6f3f92a6fb9e02ed38a98012ac374c4f', '罗艳', 1, '17600666233', '2019-10-21');
INSERT INTO `bn_user` VALUES ('719b7b0821c10962da4953a145ad98c0', '梁娜', 1, '17873442949', '2019-10-22');
INSERT INTO `bn_user` VALUES ('7e05944b75c3fd930cb1926c3de61dcc', '袁刚', 1, '17873443052', '2019-10-20');
INSERT INTO `bn_user` VALUES ('80314367f1cde3f8404f70e30eae84cf', '董秀英', 1, '17873442949', '2019-10-21');
INSERT INTO `bn_user` VALUES ('807bb14d24ade72bb74d06a9d1ae9714', '苏秀兰', 1, '17873442949', '2019-10-22');
INSERT INTO `bn_user` VALUES ('84d7d3805887a1de777151976f8cd6df', '汤杰', 1, '17873442949', '2019-10-22');
INSERT INTO `bn_user` VALUES ('8a07d2a78696eaafab61229f97e97f44', '于娟', 1, '17873443052', '2019-10-20');
INSERT INTO `bn_user` VALUES ('8fc1e0c9c54e1adcdd66c1740afc84bb', '史伟', 1, '17600666233', '2019-10-22');
INSERT INTO `bn_user` VALUES ('937dbe20e1cdd1282b8260062bb02393', '罗洋', 1, '17600666233', '2019-10-22');
INSERT INTO `bn_user` VALUES ('94438e1b2dfb4fa11098a119b91e222b', '许霞', 1, '17873442949', '2019-10-22');
INSERT INTO `bn_user` VALUES ('966f4179796bd4c788e060f494b80acd', '于强', 1, '17873442949', '2019-10-23');
INSERT INTO `bn_user` VALUES ('99dc75e6bde7194d56f092910bafbb2f', '阎静', 1, '17600666233', '2019-10-20');
INSERT INTO `bn_user` VALUES ('9a19b5698f783e9a4bf8d3e5dd3f17dc', '马强', 1, '17873442949', '2019-10-20');
INSERT INTO `bn_user` VALUES ('a1b386338d9eb488ed26a341e49dab3d', '刘敏', 1, '17873443052', '2019-10-23');
INSERT INTO `bn_user` VALUES ('a2f2dd1c9e02c9d5e6de1e5a1e7a9ab9', '周强', 1, '17873443052', '2019-10-23');
INSERT INTO `bn_user` VALUES ('b547d96134fc4cc4794c87759ea74583', '邵秀英', 1, '17873443052', '2019-10-20');
INSERT INTO `bn_user` VALUES ('b68f70c6a4ccd96729fa476f80f2839d', '石强', 1, '17873442949', '2019-10-20');
INSERT INTO `bn_user` VALUES ('c057117273e3698df7fb4ba774a01be7', '汤娟', 1, '17600666233', '2019-10-24');
INSERT INTO `bn_user` VALUES ('c0728f11808c0001992d25a1cdb78355', '马强', 1, '17873442949', '2019-10-20');
INSERT INTO `bn_user` VALUES ('c7ced1e64941bea2b2a18e6d9a39c983', '雷强', 1, '17600666233', '2019-10-24');
INSERT INTO `bn_user` VALUES ('ca8d432cb792a160412471cde78acbae', '魏强', 1, '17873443052', '2019-10-22');
INSERT INTO `bn_user` VALUES ('cb951deba342803197463b8b663d21d4', '袁杰', 1, '17873442949', '2019-10-24');
INSERT INTO `bn_user` VALUES ('ccbd3314297db74413944947a14d2ac9', '阎军', 1, '17873443052', '2019-10-25');
INSERT INTO `bn_user` VALUES ('d167718a9360c6a3a91b9ec1e9e4ffec', '秦艳', 1, '17600666233', '2019-10-20');
INSERT INTO `bn_user` VALUES ('d69f0cfbb54ab50bfdbc33104b050cdd', '锺平', 1, '17873443052', '2019-10-22');
INSERT INTO `bn_user` VALUES ('d9f8bfb89693125fc858504bb672a634', '白静', 1, '17873443052', '2019-10-26');
INSERT INTO `bn_user` VALUES ('dc17e0b488df5925ec4fbfdefc686b35', '王敏', 1, '17873442949', '2019-10-20');
INSERT INTO `bn_user` VALUES ('dc35004f27da8eda4e6976b83f407388', '萧超', 1, '17600666233', '2019-10-26');
INSERT INTO `bn_user` VALUES ('de6c12c38405ce2ca393f9066a20599f', '金娜', 1, '17600666233', '2019-10-27');
INSERT INTO `bn_user` VALUES ('e81133abafa54883e48f9befcbef52e3', '赖秀兰', 1, '17873442949', '2019-10-22');
INSERT INTO `bn_user` VALUES ('e99fc3dee2a14cec89b76f2ea715a01a', '姚秀兰', 1, '17600666233', '2019-10-28');
INSERT INTO `bn_user` VALUES ('ee13e01f32a1bf7e51694717ffbfa0b3', '萧刚', 1, '17600666233', '2019-10-29');
INSERT INTO `bn_user` VALUES ('f0373d4450cf1ab341348e443a424525', '韩伟', 1, '17600666233', '2019-10-30');
INSERT INTO `bn_user` VALUES ('f375163dd90dd22b068a9e99d5b4d1fc', '范伟', 1, '17600666233', '2019-10-30');
INSERT INTO `bn_user` VALUES ('f41c2bb88cb1ae2d07256be9ee34e30d', '杨伟', 1, '17873442949', '2019-10-22');
INSERT INTO `bn_user` VALUES ('fc2044a117ba32b52cd1921ce780373a', '周静', 1, '17600666233', '2019-10-30');

-- ----------------------------
-- Table structure for send_log
-- ----------------------------
DROP TABLE IF EXISTS `send_log`;
CREATE TABLE `send_log`  (
  `L_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `SEND_TIME` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `SEND_USER` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送的用户',
  `SEND_USER_ID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的id',
  PRIMARY KEY (`L_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Function structure for NewProc
-- ----------------------------
DROP FUNCTION IF EXISTS `NewProc`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `NewProc`(`日历` CHAR) RETURNS char(30) CHARSET utf8
BEGIN
	declare temp_num 				int;
	declare chn_str 				varchar(10);
	declare num_str					varchar(20);
	declare res_month 				varchar(20);
	declare j								int;
 
	set chn_str = '正二三四五六七八九';
	set temp_num = num + 0;
	set res_month = '';
 
	if temp_num > 0 and temp_num < 10 then
		set num_str = temp_num;
		set j = substring(num_str from 1 for 1);
		set res_month = substring(chn_str from j for 1);
	end if;
 
	if temp_num = 10 then 
		set res_month = '十'; 
	end if;
	if temp_num = 11 then 
		set res_month = '冬';
	end if;
	if temp_num = 12 then 
		set res_month = '腊'; 
	end if;
		
	return res_month;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
