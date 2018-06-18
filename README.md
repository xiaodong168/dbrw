# dbrw
spring boot+mybatis+shariding-jdbc读写分离的例子

本地数据库创建三个库：master,slave,slave_2
一主：master
两从：slave,slave_2

## 测试的数据库表：
### 主库脚本
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('1', 'zhang san943', '1', '15'), ('2', 'zhang san351', '1', '17'), ('3', 'zhang san448', '1', '42'), ('4', 'zhang san707', '0', '4'), ('5', 'zhang san17', '0', '21'), ('6', 'zhang san759', '0', '13'), ('7', 'zhang san367', '0', '32'), ('8', 'zhang san911', '0', '47'), ('9', 'zhang san82', '0', '14'), ('10', 'zhang san846', '0', '48'), ('11', 'zhang san172', '0', '11'), ('12', 'zhang san893', '0', '15'), ('13', 'zhang san93', '0', '1'), ('14', 'zhang san927', '0', '8'), ('15', 'zhang san763', '0', '33'), ('18', 'zhang san647', '0', '5'), ('19', 'zhang san561', '0', '42'), ('20', 'zhang san156', '0', '40'), ('21', 'zhang san286', '0', '6'), ('22', 'zhang san109', '0', '15'), ('23', 'zhang san7188', '0', '8'), ('24', 'zhang san1159', '0', '46'), ('25', 'zhang san4820', '0', '29'), ('26', 'zhang san9350', '0', '34'), ('27', 'zhang san9455', '0', '20'), ('28', 'zhang san3473', '0', '21'), ('29', 'zhang san8624', '0', '25'), ('30', 'zhang san1073', '0', '2');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

### 从库脚本

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('1', 'zhang san943', '1', '15'), ('2', 'zhang san351', '1', '17'), ('3', 'zhang san448', '1', '42'), ('4', 'zhang san707', '0', '4'), ('5', 'zhang san17', '0', '21'), ('6', 'zhang san759', '0', '13'), ('7', 'zhang san367', '0', '32'), ('8', 'zhang san911', '0', '47');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
