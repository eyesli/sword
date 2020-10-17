/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.16 : Database - sword
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sword` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `sword`;

/*Table structure for table `sys_config` */

DROP TABLE IF EXISTS `sys_config`;

CREATE TABLE `sys_config` (
  `id` varchar(100) NOT NULL COMMENT '编号',
  `value` varchar(100) NOT NULL COMMENT '数据值',
  `label` varchar(100) NOT NULL COMMENT '标签名',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  1：正常  0：已删除',
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置表';

/*Data for the table `sys_config` */

insert  into `sys_config`(`id`,`value`,`label`,`type`,`description`,`sort`,`create_by`,`create_time`,`last_update_by`,`last_update_time`,`remarks`,`del_flag`,`version`) values ('1','#14889A','theme','color','主题色','1','admin','2018-09-23 19:52:54',NULL,NULL,'主题色',1,0),('1178496153885478912','西门剑姬','测试','测试数据1','test','15','admin','2019-09-30 01:57:06','admin','2019-09-30 01:57:06','测试数据',1,0),('1178496156028768256','西门剑姬','测试','测试数据1','test','15','admin','2019-09-30 01:57:06','admin','2019-09-30 01:57:06','测试数据',1,0),('1178496157995896832','西门剑姬','测试','测试数据1','test','15','admin','2019-09-30 01:57:06','admin','2019-09-30 01:57:06','测试数据',1,0),('1178496159715561472','西门剑姬','测试','测试数据1','test','15','admin','2019-09-30 01:57:06','admin','2019-09-30 01:57:06','测试数据',1,0),('1178496161116459008','西门剑姬','测试','测试数据1','test','15','admin','2019-09-30 01:57:06','admin','2019-09-30 01:57:06','测试数据',0,14),('1178496161972097024','西门剑姬','测试','测试数据1','test','15','admin','2019-09-30 01:57:06','admin','2019-09-30 01:57:06','测试数据',1,0),('1178496162831929344','哈哈哈','啊啊','11','啊','1','admin','2019-09-30 01:57:06',NULL,'2019-10-12 12:48:45','啊啊啊',1,1),('1178496163435909120','西门剑姬','测试','测试数据1','test','15','admin','2019-09-30 01:57:06','admin','2019-09-30 01:57:06','测试数据',1,0),('1178496164136357888','xm','测试','测试数据1','test','15','admin','2019-09-30 01:57:06','admin','2019-09-30 01:57:06','测试数据',1,0),('1178496164945858560','西门剑姬','测试','测试数据1','test','15','admin','2019-09-30 01:57:06','admin','2019-09-30 01:57:06','测试数据',1,0),('1181418181542154240','23','1112','1','1111','11','admin','2019-10-08 03:31:25','string','2019-10-08 03:31:25','234',1,0),('1181456442213928960','43','11','1','123','15','admin','2019-10-08 06:29:01',NULL,NULL,'321',1,0),('1181457515221749760','jj','hh','1','123','15','admin','2019-10-08 14:33:17',NULL,NULL,'哈哈',1,0),('1181459444303794176','xxxx','hh','1','gg','5',NULL,'2019-10-08 14:40:57',NULL,'2019-10-08 15:54:27','jj',1,0),('1181459734021148672','yy','hh','1','123','15','admin','2019-10-08 14:42:06',NULL,NULL,'哈哈',1,0),('1181459764194971648','yy','hh','1','123','15','admin','2019-10-08 14:42:13',NULL,NULL,'哈哈',1,0),('1181473899175612416','RRRRRRRR','gg','11','fff','12','admin','2019-10-08 15:38:23',NULL,NULL,'hhh',1,0),('1181474457995317248','RRRRRRRR','gg','11','fff','12',NULL,'2019-10-08 15:40:36',NULL,NULL,'hhh',0,1),('1182590245921755136','的2','121','12','12','12',NULL,'2019-10-11 17:34:21',NULL,NULL,'1121',0,0),('1182590448271757312','string','string','1','string','12',NULL,'2019-10-11 17:35:09',NULL,'2019-10-11 17:52:10','string',1,2),('1182866738325360640','yy','bb','1','qq','1','admin','2019-10-12 11:53:02',NULL,NULL,'cc',0,0),('1182867897832312832','测试','b5b','1','q5q','1','admin','2019-10-12 11:57:38',NULL,NULL,'c5c',1,0);

/*Table structure for table `sys_dept` */

DROP TABLE IF EXISTS `sys_dept`;

CREATE TABLE `sys_dept` (
  `id` varchar(100) NOT NULL COMMENT '编号',
  `name` varchar(50) DEFAULT NULL COMMENT '机构名称',
  `parent_id` varchar(100) DEFAULT NULL COMMENT '上级机构ID，一级机构为0',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除 1：正常 0：已删除',
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构管理';

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`id`,`name`,`parent_id`,`order_num`,`create_by`,`create_time`,`last_update_by`,`last_update_time`,`del_flag`,`version`) values ('1','腾讯集团',NULL,0,'admin','2018-09-23 19:35:22',NULL,NULL,1,0),('10','市场部','5',0,'admin','2018-09-23 19:38:45',NULL,NULL,1,0),('11','市场部','6',0,'admin','2018-09-23 19:39:01',NULL,NULL,1,0),('1181486444552785920','LOL','0',0,'admin','2019-10-08 16:28:14',NULL,'2019-10-12 13:33:29',1,2),('1182881185991364608','FBI','1',0,NULL,'2019-10-12 12:50:26',NULL,NULL,1,0),('1182881470432284672','CIMB','1182881185991364608',0,NULL,'2019-10-12 12:51:34',NULL,NULL,1,0),('12','魏国','3',0,'admin','2018-09-23 19:40:42',NULL,NULL,1,0),('13','蜀国','3',1,'admin','2018-09-23 19:40:54',NULL,NULL,1,0),('14','吴国','3',2,'admin','2018-09-23 19:41:04',NULL,NULL,1,0),('2','阿里集团',NULL,1,'admin','2018-09-23 19:35:55',NULL,NULL,1,0),('3','三国集团',NULL,2,'admin','2018-09-23 19:36:24',NULL,NULL,1,0),('4','上海分公司','2',0,'admin','2018-09-23 19:37:03',NULL,NULL,1,0),('5','北京分公司','1',1,'admin','2018-09-23 19:37:17',NULL,NULL,1,0),('6','北京分公司','2',1,'admin','2018-09-23 19:37:28',NULL,NULL,1,0),('7','技术部','5',0,'admin','2018-09-23 19:38:00',NULL,NULL,1,0),('8','技术部','4',0,'admin','2018-09-23 19:38:10',NULL,NULL,1,0),('9','技术部','6',0,'admin','2018-09-23 19:38:17',NULL,NULL,1,0);

/*Table structure for table `sys_dict` */

DROP TABLE IF EXISTS `sys_dict`;

CREATE TABLE `sys_dict` (
  `id` varchar(100) NOT NULL COMMENT '编号',
  `value` varchar(100) NOT NULL COMMENT '数据值',
  `label` varchar(100) NOT NULL COMMENT '标签名',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除 1：正常 0：已删除',
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`id`,`value`,`label`,`type`,`description`,`sort`,`create_by`,`create_time`,`last_update_by`,`last_update_time`,`remarks`,`del_flag`,`version`) values ('1','male','男','sex','性别','0','admin','2018-09-23 19:52:54',NULL,NULL,'性别',1,0),('1178510388019466240','红色','鲜花','1','测试测试','1','admin','2019-09-30 03:18:24',NULL,'2019-10-12 13:41:23','红色的鲜花',1,1),('1178510470794055680','哈哈','string','看看','测试','1','admin','2019-09-30 03:18:24','string','2019-09-30 03:18:24','测试数据',1,0),('1178510479895695360','哈哈','string','看看','测试','1','admin','2019-09-30 03:18:24','string','2019-09-30 03:18:24','测试数据',1,0),('1178510487336390656','哈哈','string','看看','测试','1','admin','2019-09-30 03:18:24','string','2019-09-30 03:18:24','测试数据',1,0),('1178510501785767936','哈哈','string','看看','测试','1','admin','2019-09-30 03:18:24','string','2019-09-30 03:18:24','测试数据',1,0),('1178510507011870720','哈哈','string','看看','测试','1','admin','2019-09-30 03:18:24','string','2019-09-30 03:18:24','测试数据',1,0),('1178510511764017152','哈哈','string','看看','测试','1','admin','2019-09-30 03:18:24','string','2019-09-30 03:18:24','测试数据',1,0),('1178510516226756608','哈哈','string','看看','测试','1','admin','2019-09-30 03:18:24','string','2019-09-30 03:18:24','测试数据',1,0),('1178510520693690368','哈哈','string','看看','测试','1','admin','2019-09-30 03:18:24','string','2019-09-30 03:18:24','测试数据',1,0),('1182892584528384000','嘻嘻','哈哈','1','测试dict','1',NULL,'2019-10-12 13:35:44',NULL,NULL,'哈哈哈',1,0),('2','female','女','sex','性别','1','admin','2018-09-23 19:53:17',NULL,NULL,'性别',1,0);

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` varchar(100) NOT NULL COMMENT '编号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统操作日志';

/*Data for the table `sys_log` */

insert  into `sys_log`(`id`,`user_name`,`operation`,`method`,`params`,`time`,`ip`,`create_by`,`create_time`,`last_update_by`,`last_update_time`,`version`) values ('1','admin',NULL,'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()','{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}',4,'0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:16',NULL,NULL,0),('2','admin',NULL,'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()','{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}',4,'0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:17',NULL,NULL,0),('2798',NULL,NULL,'com.louis.mango.admin.service.impl.SysUserServiceImpl.findByName()','\"admin\"',361,'0:0:0:0:0:0:0:1',NULL,NULL,NULL,NULL,0),('2799',NULL,NULL,'com.louis.mango.admin.service.impl.SysUserServiceImpl.findByName()','\"admin\"',4,'0:0:0:0:0:0:0:1',NULL,NULL,NULL,NULL,0),('2800',NULL,NULL,'com.louis.mango.admin.service.impl.SysMenuServiceImpl.findByUser()','\"admin\"',43,'0:0:0:0:0:0:0:1',NULL,NULL,NULL,NULL,0),('2801',NULL,NULL,'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPermissions()','\"admin\"',49,'0:0:0:0:0:0:0:1',NULL,NULL,NULL,NULL,0),('2802',NULL,NULL,'com.louis.mango.admin.service.impl.SysUserServiceImpl.findByName()','\"admin\"',221,'0:0:0:0:0:0:0:1',NULL,NULL,NULL,NULL,0),('2803',NULL,NULL,'com.louis.mango.admin.service.impl.SysUserServiceImpl.findByName()','\"admin\"',3,'0:0:0:0:0:0:0:1',NULL,NULL,NULL,NULL,0),('2804',NULL,NULL,'com.louis.mango.admin.service.impl.SysMenuServiceImpl.findByUser()','\"admin\"',37,'0:0:0:0:0:0:0:1',NULL,NULL,NULL,NULL,0),('2805',NULL,NULL,'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPermissions()','\"admin\"',43,'0:0:0:0:0:0:0:1',NULL,NULL,NULL,NULL,0),('2806','admin',NULL,'com.louis.mango.admin.service.impl.SysLoginLogServiceImpl.writeLoginLog()','\"admin\"',138,'0:0:0:0:0:0:0:1','admin','2019-01-21 10:15:43',NULL,NULL,0),('2807','admin',NULL,'com.louis.mango.admin.service.impl.SysMenuServiceImpl.findTree()','\"admin\"',15,'0:0:0:0:0:0:0:1','admin','2019-01-21 10:15:44',NULL,NULL,0),('2808','admin',NULL,'com.louis.mango.admin.service.impl.SysMenuServiceImpl.findByUser()','\"admin\"',16,'0:0:0:0:0:0:0:1','admin','2019-01-21 10:15:44',NULL,NULL,0),('2809','admin',NULL,'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPermissions()','\"admin\"',22,'0:0:0:0:0:0:0:1','admin','2019-01-21 10:15:44',NULL,NULL,0),('2876','admin',NULL,'com.louis.mango.admin.service.impl.SysLoginLogServiceImpl.findPage()','{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"userName\",\"value\":\"\"}]}',13,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:10',NULL,NULL,0),('2877','admin',NULL,'com.louis.mango.admin.service.impl.SysRoleServiceImpl.findPage()','{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}',15,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:13',NULL,NULL,0),('2878','admin',NULL,'com.louis.mango.admin.service.impl.SysMenuServiceImpl.findTree()','null',10,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:13',NULL,NULL,0),('2879','admin',NULL,'com.louis.mango.admin.service.impl.SysDeptServiceImpl.findTree()',NULL,3,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:14',NULL,NULL,0),('2880','admin',NULL,'com.louis.mango.admin.service.impl.SysDeptServiceImpl.findTree()',NULL,2,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:14',NULL,NULL,0),('2881','admin',NULL,'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPage()','{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}',49,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:14',NULL,NULL,0),('2882','admin',NULL,'com.louis.mango.admin.service.impl.SysRoleServiceImpl.findAll()',NULL,1,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:14',NULL,NULL,0),('2883','admin',NULL,'com.louis.mango.admin.service.impl.SysMenuServiceImpl.findTree()','null',3,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:15',NULL,NULL,0),('2884','admin',NULL,'com.louis.mango.admin.service.impl.SysConfigServiceImpl.findPage()','{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"label\",\"value\":\"\"}]}',8,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:15',NULL,NULL,0),('2885','admin',NULL,'com.louis.mango.admin.service.impl.SysLoginLogServiceImpl.findPage()','{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"userName\",\"value\":\"\"}]}',7,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:16',NULL,NULL,0),('2886','admin',NULL,'com.louis.mango.admin.service.impl.SysDeptServiceImpl.findTree()',NULL,2,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:22',NULL,NULL,0),('2887','admin',NULL,'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPage()','{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}',61,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:22',NULL,NULL,0),('2888','admin',NULL,'com.louis.mango.admin.service.impl.SysRoleServiceImpl.findAll()',NULL,1,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:22',NULL,NULL,0),('2889','admin',NULL,'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPage()','{\"pageNum\":2,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}',18,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:25',NULL,NULL,0),('2890','admin',NULL,'com.louis.mango.admin.service.impl.SysRoleServiceImpl.findAll()',NULL,2,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:25',NULL,NULL,0),('2891','admin',NULL,'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPage()','{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}',43,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:27',NULL,NULL,0),('2892','admin',NULL,'com.louis.mango.admin.service.impl.SysRoleServiceImpl.findAll()',NULL,1,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:27',NULL,NULL,0),('2893','admin',NULL,'com.louis.mango.admin.service.impl.SysUserServiceImpl.createUserExcelFile()','{\"pageNum\":1,\"pageSize\":100000,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}',1577,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:48:38',NULL,NULL,0),('2894','admin',NULL,'com.louis.mango.admin.service.impl.SysDeptServiceImpl.findTree()',NULL,1,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:49:24',NULL,NULL,0),('2895','admin',NULL,'com.louis.mango.admin.service.impl.SysUserServiceImpl.findPage()','{\"pageNum\":1,\"pageSize\":9,\"params\":[{\"name\":\"name\",\"value\":\"\"}]}',75,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:49:24',NULL,NULL,0),('2896','admin',NULL,'com.louis.mango.admin.service.impl.SysRoleServiceImpl.findAll()',NULL,2,'0:0:0:0:0:0:0:1','admin','2019-01-22 14:49:24',NULL,NULL,0),('3','admin',NULL,'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()','{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}',36,'0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:18',NULL,NULL,0),('4','admin',NULL,'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()','{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}',4,'0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:20',NULL,NULL,0),('5','admin',NULL,'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()','{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}',4,'0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:20',NULL,NULL,0),('6','admin',NULL,'com.louis.kitty.admin.sevice.impl.SysUserServiceImpl.findPage()','{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}',27,'0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:21',NULL,NULL,0),('7','admin',NULL,'com.louis.kitty.admin.sevice.impl.SysRoleServiceImpl.findPage()','{\"columnFilters\":{\"name\":{\"name\":\"name\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}',4,'0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:22',NULL,NULL,0),('8','admin',NULL,'com.louis.kitty.admin.sevice.impl.SysDictServiceImpl.findPage()','{\"columnFilters\":{\"label\":{\"name\":\"label\",\"value\":\"\"}},\"pageNum\":1,\"pageSize\":8}',4,'0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:23',NULL,NULL,0);

/*Table structure for table `sys_login_log` */

DROP TABLE IF EXISTS `sys_login_log`;

CREATE TABLE `sys_login_log` (
  `id` varchar(100) NOT NULL COMMENT '编号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `status` varchar(50) DEFAULT NULL COMMENT '登录状态（online:在线，登录初始状态，方便统计在线人数；login:退出登录后将online置为login；logout:退出登录）',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统登录日志';

/*Data for the table `sys_login_log` */

insert  into `sys_login_log`(`id`,`user_name`,`status`,`ip`,`create_by`,`create_time`,`last_update_by`,`last_update_time`) values ('1','admin','login','0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:16',NULL,NULL),('2','admin','logout','0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:17',NULL,NULL),('2798','admin','logout','0:0:0:0:0:0:0:1','admin','2019-01-21 10:15:43',NULL,NULL),('2799','admin','login','0:0:0:0:0:0:0:1','admin','2019-01-21 10:15:43','admin','2019-01-21 10:16:54'),('2800','admin','logout','0:0:0:0:0:0:0:1','admin','2019-01-21 10:16:54',NULL,NULL),('2801','admin','login','0:0:0:0:0:0:0:1','admin','2019-01-21 10:16:54','admin','2019-01-22 14:43:09'),('2802','admin','logout','0:0:0:0:0:0:0:1','admin','2019-01-22 14:43:09',NULL,NULL),('2803','admin','online','0:0:0:0:0:0:0:1','admin','2019-01-22 14:43:09',NULL,NULL),('3','admin','login','0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:18',NULL,NULL),('4','admin','logout','0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:20',NULL,NULL),('5','admin','login','0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:20',NULL,NULL),('6','admin','logout','0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:21',NULL,NULL),('7','admin','login','0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:22',NULL,NULL),('8','admin','login','0:0:0:0:0:0:0:1','admin','2018-09-23 19:54:23','admin','2019-01-21 10:15:43');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` varchar(100) NOT NULL COMMENT '编号',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `parent_id` varchar(100) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL,类型：1.普通页面（如用户管理， /sys/user） 2.嵌套完整外部页面，以http(s)开头的链接 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址)',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除 1：正常 0：已删除',
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单管理';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`perms`,`type`,`icon`,`order_num`,`create_by`,`create_time`,`last_update_by`,`last_update_time`,`del_flag`,`version`) values ('1','系统管理','0',NULL,NULL,0,'el-icon-setting',0,NULL,NULL,NULL,NULL,1,0),('10','修改','7',NULL,'sys:dept:edit',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('11','删除','7',NULL,'sys:dept:delete',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('1182909642653700096','LOL','0','','',0,'',0,'admin','2019-10-12 14:43:31','admin','2019-10-12 15:03:21',1,3),('1182954767689846784','S9全球总决赛','1182909642653700096','','',1,'string',0,'admin','2019-10-12 17:42:50',NULL,NULL,1,0),('1182954825495744512','MSI','1182909642653700096','','',1,'string',0,'admin','2019-10-12 17:43:03',NULL,NULL,1,0),('1182954877161181184','洲际赛I','1182909642653700096','','',1,'string',0,'admin','2019-10-12 17:43:16',NULL,NULL,1,0),('1182955585755287552','查看S9全球总决赛','1182954767689846784','','',2,'string',0,'admin','2019-10-12 17:46:05',NULL,NULL,1,0),('1182955688779976704','删除S9全球总决赛','1182954767689846784','','',2,'string',0,'admin','2019-10-12 17:46:29',NULL,NULL,1,0),('1182956013305860096','删除MSI','1182954825495744512','','',2,'string',0,'admin','2019-10-12 17:47:46',NULL,NULL,1,0),('1182956045807521792','查看MSI','1182954825495744512','','',2,'string',0,'admin','2019-10-12 17:47:54',NULL,NULL,1,0),('1182956104938819584','查看洲际赛','1182954877161181184','','',2,'string',0,'admin','2019-10-12 17:48:08',NULL,NULL,1,0),('1182956137436286976','删除洲际赛','1182954877161181184','','',2,'string',0,'admin','2019-10-12 17:48:16',NULL,NULL,1,0),('12','角色管理','1','/sys/role',NULL,1,'el-icon-view',4,NULL,NULL,NULL,NULL,1,0),('13','查看','12',NULL,'sys:role:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('14','新增','12',NULL,'sys:role:add',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('15','修改','12',NULL,'sys:role:edit',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('16','删除','12',NULL,'sys:role:delete',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('17','菜单管理','1','/sys/menu',NULL,1,'el-icon-menu',5,NULL,NULL,NULL,NULL,1,0),('18','查看','17',NULL,'sys:menu:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('19','新增','17',NULL,'sys:menu:add',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('2','用户管理','1','/sys/user',NULL,1,'el-icon-service',1,NULL,NULL,NULL,NULL,1,0),('20','修改','17',NULL,'sys:menu:edit',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('21','删除','17',NULL,'sys:menu:delete',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('22','字典管理','1','/sys/dict',NULL,1,'el-icon-edit-outline',7,NULL,NULL,NULL,NULL,1,0),('23','查看','22',NULL,'sys:dict:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('24','新增','22',NULL,'sys:dict:add',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('25','修改','22',NULL,'sys:dict:edit',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('26','删除','22',NULL,'sys:dict:delete',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('27','系统配置','1','/sys/config',NULL,1,'el-icon-edit-outline',7,NULL,NULL,NULL,NULL,1,0),('28','查看','27',NULL,'sys:config:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('29','新增','27',NULL,'sys:config:add',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('3','查看','2',NULL,'sys:user:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('30','修改','27',NULL,'sys:config:edit',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('31','删除','27',NULL,'sys:config:delete',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('32','登录日志','1','/sys/loginlog',NULL,1,'el-icon-info',8,NULL,NULL,'admin','2018-09-23 19:32:28',1,0),('33','查看','32',NULL,'sys:loginlog:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('34','删除','32',NULL,'sys:loginlog:delete',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('35','操作日志','1','/sys/log',NULL,1,'el-icon-info',8,NULL,NULL,'admin','2018-09-23 19:32:28',1,0),('36','查看','35',NULL,'sys:log:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('37','删除','35',NULL,'sys:log:delete',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('38','系统监控','0','','',0,'el-icon-info',4,'admin','2018-12-27 10:57:29','admin','2019-01-10 17:31:04',1,0),('39','数据监控','38','http://127.0.0.1:8001/druid/login.html',NULL,1,'el-icon-warning',0,NULL,NULL,'admin','2018-12-27 11:03:45',1,0),('4','新增','2',NULL,'sys:user:add',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('40','查看','39',NULL,'sys:druid:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('41','服务监控','38','http://127.0.0.1:8000/',NULL,1,'el-icon-view',1,'admin','2018-11-02 20:02:15','admin','2018-12-27 11:03:53',1,0),('42','查看','41',NULL,'sys:monitor:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('43','服务治理','0','','',0,'el-icon-service',2,'admin','2018-12-27 11:05:48','admin','2018-12-27 11:06:39',1,0),('44','注册中心','43','http://127.0.0.1:8500',NULL,1,' el-icon-view',0,'admin','2018-11-03 11:06:48','admin','2018-12-27 11:08:11',1,0),('45','查看','44',NULL,'sys:consul:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('46','接口文档','0','http://127.0.0.1:8001/swagger-ui.html',NULL,1,'el-icon-document',3,NULL,NULL,'admin','2018-12-27 11:04:18',1,0),('47','查看','46',NULL,'sys:swagger:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('48','代码生成','0','/generator/generator','',1,'el-icon-star-on',5,'admin','2018-11-15 14:39:30','admin','2018-11-15 14:56:18',1,0),('49','查看','48',NULL,'sys:generator:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('5','修改','2',NULL,'sys:user:edit',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('50','在线用户','0','/sys/online','',1,'el-icon-view',5,'admin','2018-11-15 14:39:30','admin','2018-11-15 14:56:18',1,0),('51','查看','50',NULL,'sys:online:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('52','使用案例','0',NULL,NULL,0,'el-icon-picture-outline',6,NULL,NULL,'admin','2018-11-15 14:39:43',1,0),('53','国际化','52','/demo/i18n',NULL,1,'el-icon-edit',1,NULL,NULL,NULL,NULL,1,0),('54','查看','53',NULL,'sys:dict:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('55','换皮肤','52','/demo/theme',NULL,1,'el-icon-picture',2,NULL,NULL,NULL,NULL,1,0),('56','查看','55',NULL,'sys:dict:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('6','删除','2',NULL,'sys:user:delete',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('7','机构管理','1','/sys/dept',NULL,1,'el-icon-news',2,NULL,NULL,NULL,NULL,1,0),('8','查看','7',NULL,'sys:dept:view',2,NULL,0,NULL,NULL,NULL,NULL,1,0),('9','新增','7',NULL,'sys:dept:add',2,NULL,0,NULL,NULL,NULL,NULL,1,0);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` varchar(100) NOT NULL COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除 1：正常 0：已删除',
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色管理';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`remark`,`create_by`,`create_time`,`last_update_by`,`last_update_time`,`del_flag`,`version`) values ('1','admin','超级管理员','admin','2019-01-19 11:11:11','admin','2019-01-19 19:07:18',1,0),('1182585766430248960','123','321',NULL,'2019-10-11 17:16:33',NULL,NULL,1,0),('1182585877528973312','哈哈','测试',NULL,'2019-10-11 17:16:59',NULL,NULL,1,0),('1182587061803290624','string','string',NULL,'2019-10-11 17:21:42',NULL,'2019-10-11 18:32:19',1,1),('1182587621742874624','嘿发嘿','看发看',NULL,'2019-10-11 17:23:55',NULL,NULL,1,0),('1182588020252086272','嘿发个嘿','看更丰富看',NULL,'2019-10-11 17:25:30',NULL,NULL,1,0),('1182588503003893760','嘿发个就嘿','看更丰富看',NULL,'2019-10-11 17:27:25',NULL,NULL,1,0),('1182601641585676288','嘿发个是就嘿','看更是丰富看',NULL,'2019-10-11 18:19:38',NULL,NULL,1,0),('1182601748053889024','www','对对对',NULL,'2019-10-11 18:20:03',NULL,NULL,1,0),('1182956494367363072','LOLer','LOL观赛','admin','2019-10-12 17:49:41',NULL,NULL,1,0),('2','mng','项目经理','admin','2019-01-19 11:11:11','admin','2019-01-19 11:39:28',1,0),('3','dev','开发人员','admin','2019-01-19 11:11:11','admin','2019-01-19 11:39:28',1,0),('4','test','测试人员','admin','2019-01-19 11:11:11','admin','2019-01-19 11:11:11',1,0);

/*Table structure for table `sys_role_dept` */

DROP TABLE IF EXISTS `sys_role_dept`;

CREATE TABLE `sys_role_dept` (
  `id` varchar(100) NOT NULL COMMENT '编号',
  `role_id` varchar(100) DEFAULT NULL COMMENT '角色ID',
  `dept_id` varchar(100) DEFAULT NULL COMMENT '机构ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色机构';

/*Data for the table `sys_role_dept` */

insert  into `sys_role_dept`(`id`,`role_id`,`dept_id`,`create_by`,`create_time`,`last_update_by`,`last_update_time`) values ('1','1','1','admin','2019-01-11 08:30:37','admin','2019-01-11 08:30:25'),('2','2','2','admin','2019-01-11 08:31:01','admin','2019-01-11 08:31:04'),('3','3','3','admin','2019-01-11 08:31:18','admin','2019-01-11 08:31:21');

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` varchar(100) NOT NULL COMMENT '编号',
  `role_id` varchar(100) DEFAULT NULL COMMENT '角色ID',
  `menu_id` varchar(100) DEFAULT NULL COMMENT '菜单ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`,`create_by`,`create_time`,`last_update_by`,`last_update_time`) values ('1182957899790553088','1182956494367363072','1182909642653700096','admin','2019-10-12 17:55:16',NULL,NULL),('1182957899790553089','1182956494367363072','1182954767689846784','admin','2019-10-12 17:55:16',NULL,NULL),('1182957899790553090','1182956494367363072','1182954825495744512','admin','2019-10-12 17:55:16',NULL,NULL),('1182957899790553091','1182956494367363072','1182954877161181184','admin','2019-10-12 17:55:16',NULL,NULL),('1182957899790553092','1182956494367363072','1182955585755287552','admin','2019-10-12 17:55:16',NULL,NULL),('1182957899790553093','1182956494367363072','1182955688779976704','admin','2019-10-12 17:55:16',NULL,NULL),('1182957899790553094','1182956494367363072','1182956013305860096','admin','2019-10-12 17:55:16',NULL,NULL),('1182957899790553095','1182956494367363072','1182956045807521792','admin','2019-10-12 17:55:16',NULL,NULL),('1182957899790553096','1182956494367363072','1182956104938819584','admin','2019-10-12 17:55:16',NULL,NULL),('1182957899790553097','1182956494367363072','1182956137436286976','admin','2019-10-12 17:55:16',NULL,NULL),('3','1','2','4','2019-10-12 16:12:17','5','2019-10-12 16:12:17'),('431','8','1','admin','2018-09-23 19:55:08',NULL,NULL),('432','8','2','admin','2018-09-23 19:55:08',NULL,NULL),('433','8','9','admin','2018-09-23 19:55:08',NULL,NULL),('434','8','3','admin','2018-09-23 19:55:08',NULL,NULL),('435','8','13','admin','2018-09-23 19:55:08',NULL,NULL),('436','8','4','admin','2018-09-23 19:55:08',NULL,NULL),('437','8','17','admin','2018-09-23 19:55:08',NULL,NULL),('438','8','5','admin','2018-09-23 19:55:08',NULL,NULL),('439','8','21','admin','2018-09-23 19:55:08',NULL,NULL),('440','8','7','admin','2018-09-23 19:55:08',NULL,NULL),('441','8','31','admin','2018-09-23 19:55:08',NULL,NULL),('442','8','8','admin','2018-09-23 19:55:08',NULL,NULL),('443','8','6','admin','2018-09-23 19:55:08',NULL,NULL),('444','8','35','admin','2018-09-23 19:55:08',NULL,NULL),('469','2','1',NULL,NULL,NULL,NULL),('470','2','2',NULL,NULL,NULL,NULL),('471','2','3',NULL,NULL,NULL,NULL),('472','2','4',NULL,NULL,NULL,NULL),('473','2','5',NULL,NULL,NULL,NULL),('474','2','6',NULL,NULL,NULL,NULL),('475','2','7',NULL,NULL,NULL,NULL),('476','2','8',NULL,NULL,NULL,NULL),('477','2','9',NULL,NULL,NULL,NULL),('478','2','10',NULL,NULL,NULL,NULL),('479','2','11',NULL,NULL,NULL,NULL),('480','2','12',NULL,NULL,NULL,NULL),('481','2','13',NULL,NULL,NULL,NULL),('482','2','14',NULL,NULL,NULL,NULL),('483','2','15',NULL,NULL,NULL,NULL),('484','2','16',NULL,NULL,NULL,NULL),('485','2','17',NULL,NULL,NULL,NULL),('486','2','18',NULL,NULL,NULL,NULL),('487','2','19',NULL,NULL,NULL,NULL),('488','2','20',NULL,NULL,NULL,NULL),('489','2','21',NULL,NULL,NULL,NULL),('490','2','22',NULL,NULL,NULL,NULL),('491','2','23',NULL,NULL,NULL,NULL),('492','2','24',NULL,NULL,NULL,NULL),('493','2','25',NULL,NULL,NULL,NULL),('494','2','26',NULL,NULL,NULL,NULL),('495','2','27',NULL,NULL,NULL,NULL),('496','2','28',NULL,NULL,NULL,NULL),('497','2','29',NULL,NULL,NULL,NULL),('498','2','30',NULL,NULL,NULL,NULL),('499','2','31',NULL,NULL,NULL,NULL),('500','2','32',NULL,NULL,NULL,NULL),('501','2','33',NULL,NULL,NULL,NULL),('502','2','34',NULL,NULL,NULL,NULL),('503','2','35',NULL,NULL,NULL,NULL),('504','2','36',NULL,NULL,NULL,NULL),('505','2','37',NULL,NULL,NULL,NULL),('506','2','43',NULL,NULL,NULL,NULL),('507','2','44',NULL,NULL,NULL,NULL),('508','2','45',NULL,NULL,NULL,NULL),('509','2','46',NULL,NULL,NULL,NULL),('510','2','47',NULL,NULL,NULL,NULL),('511','2','38',NULL,NULL,NULL,NULL),('512','2','39',NULL,NULL,NULL,NULL),('513','2','40',NULL,NULL,NULL,NULL),('514','2','41',NULL,NULL,NULL,NULL),('515','2','42',NULL,NULL,NULL,NULL),('516','2','48',NULL,NULL,NULL,NULL),('517','2','49',NULL,NULL,NULL,NULL),('518','2','50',NULL,NULL,NULL,NULL),('519','2','51',NULL,NULL,NULL,NULL),('520','2','52',NULL,NULL,NULL,NULL),('521','2','53',NULL,NULL,NULL,NULL),('522','2','54',NULL,NULL,NULL,NULL),('523','2','55',NULL,NULL,NULL,NULL),('524','2','56',NULL,NULL,NULL,NULL),('572','3','1','admin','2019-01-22 14:45:28',NULL,NULL),('573','3','2','admin','2019-01-22 14:45:28',NULL,NULL),('574','3','3','admin','2019-01-22 14:45:28',NULL,NULL),('575','3','4','admin','2019-01-22 14:45:28',NULL,NULL),('576','3','5','admin','2019-01-22 14:45:28',NULL,NULL),('577','3','6','admin','2019-01-22 14:45:28',NULL,NULL),('578','3','7','admin','2019-01-22 14:45:28',NULL,NULL),('579','3','8','admin','2019-01-22 14:45:28',NULL,NULL),('580','3','12','admin','2019-01-22 14:45:28',NULL,NULL),('581','3','13','admin','2019-01-22 14:45:28',NULL,NULL),('582','3','17','admin','2019-01-22 14:45:28',NULL,NULL),('583','3','18','admin','2019-01-22 14:45:28',NULL,NULL),('584','3','22','admin','2019-01-22 14:45:28',NULL,NULL),('585','3','23','admin','2019-01-22 14:45:28',NULL,NULL),('586','3','24','admin','2019-01-22 14:45:28',NULL,NULL),('587','3','25','admin','2019-01-22 14:45:28',NULL,NULL),('588','3','26','admin','2019-01-22 14:45:28',NULL,NULL),('589','3','27','admin','2019-01-22 14:45:28',NULL,NULL),('590','3','28','admin','2019-01-22 14:45:28',NULL,NULL),('591','3','29','admin','2019-01-22 14:45:28',NULL,NULL),('592','3','30','admin','2019-01-22 14:45:28',NULL,NULL),('593','3','31','admin','2019-01-22 14:45:28',NULL,NULL),('594','3','32','admin','2019-01-22 14:45:28',NULL,NULL),('595','3','33','admin','2019-01-22 14:45:28',NULL,NULL),('596','3','35','admin','2019-01-22 14:45:28',NULL,NULL),('597','3','36','admin','2019-01-22 14:45:28',NULL,NULL),('598','3','43','admin','2019-01-22 14:45:28',NULL,NULL),('599','3','44','admin','2019-01-22 14:45:28',NULL,NULL),('600','3','45','admin','2019-01-22 14:45:28',NULL,NULL),('601','3','38','admin','2019-01-22 14:45:28',NULL,NULL),('602','3','39','admin','2019-01-22 14:45:28',NULL,NULL),('603','3','40','admin','2019-01-22 14:45:28',NULL,NULL),('604','3','41','admin','2019-01-22 14:45:28',NULL,NULL),('605','3','42','admin','2019-01-22 14:45:28',NULL,NULL),('606','3','50','admin','2019-01-22 14:45:28',NULL,NULL),('607','3','51','admin','2019-01-22 14:45:28',NULL,NULL),('608','4','1','admin','2019-01-22 14:46:44',NULL,NULL),('609','4','2','admin','2019-01-22 14:46:44',NULL,NULL),('610','4','3','admin','2019-01-22 14:46:44',NULL,NULL),('611','4','7','admin','2019-01-22 14:46:44',NULL,NULL),('612','4','8','admin','2019-01-22 14:46:44',NULL,NULL),('613','4','17','admin','2019-01-22 14:46:44',NULL,NULL),('614','4','18','admin','2019-01-22 14:46:44',NULL,NULL),('615','4','32','admin','2019-01-22 14:46:44',NULL,NULL),('616','4','33','admin','2019-01-22 14:46:44',NULL,NULL),('617','4','35','admin','2019-01-22 14:46:44',NULL,NULL),('618','4','36','admin','2019-01-22 14:46:44',NULL,NULL),('619','4','46','admin','2019-01-22 14:46:44',NULL,NULL),('620','4','47','admin','2019-01-22 14:46:44',NULL,NULL),('621','4','50','admin','2019-01-22 14:46:44',NULL,NULL),('622','4','51','admin','2019-01-22 14:46:44',NULL,NULL);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` varchar(100) NOT NULL COMMENT '编号',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `nick_name` varchar(150) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(150) DEFAULT NULL COMMENT '头像',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(40) DEFAULT NULL COMMENT '加密盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `dept_id` varchar(100) DEFAULT NULL COMMENT '机构ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除 1：正常 0：已删除',
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户管理';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`name`,`nick_name`,`avatar`,`password`,`salt`,`email`,`mobile`,`status`,`dept_id`,`create_by`,`create_time`,`last_update_by`,`last_update_time`,`del_flag`,`version`) values ('1','admin','超管',NULL,'bd1718f058d8a02468134432b8656a86','YzcmCZNvbXocrsz9dm8e','admin@qq.com','13612345678',1,'4','admin','2018-08-14 11:11:11','admin','2018-08-14 11:11:11',1,0),('1181831009973440512','测试人员','测试狗','test','858ee01d889e1967f90a04ae81a86f1e','be2caf9720fc437589c6','4516@qq.com','1656515613625',1,'1181486444552785920','admin','2019-10-09 15:17:25',NULL,NULL,1,0),('1181832589556715520','GG','GGG','头像地址','779e95f5f8a5094f68a95e58ec43f467','d97416c612954515b137','35235@qq.com','12321412',1,'1181486444552785920','admin','2019-10-09 15:23:41',NULL,'2019-10-09 15:36:57',1,0),('22','liubei','刘备',NULL,'fd80ebd493a655608dc893a9f897d845','YzcmCZNvbXocrsz9dm8e','test@qq.com','13889700023',1,'7','admin','2018-09-23 19:43:00','admin','2019-01-10 11:41:13',1,0),('23','zhaoyun','赵云',NULL,'fd80ebd493a655608dc893a9f897d845','YzcmCZNvbXocrsz9dm8e','test@qq.com','13889700023',1,'7','admin','2018-09-23 19:43:44','admin','2018-09-23 19:43:52',1,0),('24','zhugeliang','诸葛亮',NULL,'fd80ebd493a655608dc893a9f897d845','YzcmCZNvbXocrsz9dm8e','test@qq.com','13889700023',7,'11','admin','2018-09-23 19:44:23','admin','2018-09-23 19:44:29',1,0),('25','caocao','曹操',NULL,'fd80ebd493a655608dc893a9f897d845','YzcmCZNvbXocrsz9dm8e','test@qq.com','13889700023',1,'8','admin','2018-09-23 19:45:32','admin','2019-01-10 17:59:14',1,0),('26','dianwei','典韦',NULL,'fd80ebd493a655608dc893a9f897d845','YzcmCZNvbXocrsz9dm8e','test@qq.com','13889700023',1,'10','admin','2018-09-23 19:45:48','admin','2018-09-23 19:45:57',1,0),('27','xiahoudun','夏侯惇',NULL,'fd80ebd493a655608dc893a9f897d845','YzcmCZNvbXocrsz9dm8e','test@qq.com','13889700023',1,'8','admin','2018-09-23 19:46:09','admin','2018-09-23 19:46:17',1,0),('28','xunyu','荀彧',NULL,'fd80ebd493a655608dc893a9f897d845','YzcmCZNvbXocrsz9dm8e','test@qq.com','13889700023',1,'10','admin','2018-09-23 19:46:38','admin','2018-11-04 15:33:17',1,0),('29','sunquan','孙权',NULL,'fd80ebd493a655608dc893a9f897d845','YzcmCZNvbXocrsz9dm8e','test@qq.com','13889700023',1,'10','admin','2018-09-23 19:46:54','admin','2018-09-23 19:47:03',1,0),('30','zhouyu','周瑜',NULL,'fd80ebd493a655608dc893a9f897d845','YzcmCZNvbXocrsz9dm8e','test@qq.com','13889700023',1,'11','admin','2018-09-23 19:47:28','admin','2018-09-23 19:48:04',1,0),('31','luxun','陆逊',NULL,'fd80ebd493a655608dc893a9f897d845','YzcmCZNvbXocrsz9dm8e','test@qq.com','13889700023',1,'11','admin','2018-09-23 19:47:44','admin','2018-09-23 19:47:58',1,0),('32','huanggai','黄盖',NULL,'fd80ebd493a655608dc893a9f897d845','YzcmCZNvbXocrsz9dm8e','test@qq.com','13889700023',1,'11','admin','2018-09-23 19:48:38','admin','2018-09-23 19:49:02',1,0);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` varchar(100) NOT NULL COMMENT '编号',
  `user_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `role_id` varchar(100) DEFAULT NULL COMMENT '角色ID',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `last_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_id`,`role_id`,`create_by`,`create_time`,`last_update_by`,`last_update_time`) values ('1','1','1',NULL,NULL,NULL,NULL),('2','2','1',NULL,NULL,NULL,NULL),('26','5','3',NULL,NULL,NULL,NULL),('33','6','2',NULL,NULL,NULL,NULL),('34','4','2',NULL,NULL,NULL,NULL),('35','9','2',NULL,NULL,NULL,NULL),('36','10','3',NULL,NULL,NULL,NULL),('37','11','2',NULL,NULL,NULL,NULL),('38','12','3',NULL,NULL,NULL,NULL),('39','15','2',NULL,NULL,NULL,NULL),('41','16','3',NULL,NULL,NULL,NULL),('42','8','2',NULL,NULL,NULL,NULL),('43','7','4',NULL,NULL,NULL,NULL),('45','18','2',NULL,NULL,NULL,NULL),('46','17','3',NULL,NULL,NULL,NULL),('47','3','4',NULL,NULL,NULL,NULL),('48','21','2',NULL,NULL,NULL,NULL),('57','31','2',NULL,NULL,NULL,NULL),('58','30','2',NULL,NULL,NULL,NULL),('59','32','3',NULL,NULL,NULL,NULL),('73','33','8',NULL,NULL,NULL,NULL),('74','25','8',NULL,NULL,NULL,NULL),('75','25','2',NULL,NULL,NULL,NULL),('80','22','2',NULL,NULL,NULL,NULL),('81','23','3',NULL,NULL,NULL,NULL),('82','24','4',NULL,NULL,NULL,NULL),('83','26','3',NULL,NULL,NULL,NULL),('85','29','2',NULL,NULL,NULL,NULL),('86','28','4',NULL,NULL,NULL,NULL),('87','27','3',NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
