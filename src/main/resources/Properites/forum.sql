#create database;
CREATE database forum;

#user table
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
  user_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  user_name VARCHAR(30) NOT NULL COMMENT '用户名',
  password VARCHAR(30) NOT NULL COMMENT '密码',
  avatar VARCHAR(100) COMMENT '头像',
  user_type TINYINT(4) NOT NULL DEFAULT '1' COMMENT '1:普通用户,2:管理员',
  locked TINYINT(4) NOT NULL DEFAULT '0' COMMENT '0:未锁定,1:锁定',
  credit INT(11) DEFAULT NULL COMMENT '积分',
  last_visit DATETIME DEFAULT NULL COMMENT '最后登录时间',
  last_ip VARCHAR(20) DEFAULT NULL COMMENT '最后登录IP'
)ENGINE = InnoDB AUTO_INCREMENT= 2 DEFAULT CHARSET = utf8 COMMENT '用户';

INSERT INTO t_user VALUE (1,'admin','admin',NULL,2,0,NULL,NULL,NULL);

#topic table
DROP TABLE IF EXISTS t_topic;
CREATE TABLE t_topic (
  topic_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '话题ID',
  user_id INT(11) NOT NULL DEFAULT '0' COMMENT '发表用户ID',
  board_id INT(11) NOT NULL COMMENT '所属板块',
  topic_title VARCHAR(100) NOT NULL DEFAULT '' COMMENT '话题标题',
  create_time DATETIME NOT NULL COMMENT '发表时间',
  last_post DATETIME NOT NULL COMMENT '最后回复时间',
  topic_views INT(11) NOT NULL DEFAULT '1' COMMENT '浏览数',
  topic_replies INT(11) NOT NULL DEFAULT '0' COMMENT '回复数',
  digest TINYINT NOT NULL COMMENT '0:不是精华话题,1:是精华话题',
  PRIMARY KEY (topic_id)
)ENGINE = InnoDB AUTO_INCREMENT = 4 DEFAULT CHARSET = utf8 COMMENT '话题';

INSERT INTO t_topic VALUE (1,1,'育儿经验','2011-05-16','2011-05-16',0,1,1);
INSERT INTO t_topic VALUE (2,1,'测试...','2011-05-16','2011-05-16',0,0,0);
INSERT INTO t_topic VALUES (3,1,'美德故事','2011-09-18','2011-09-18',0,0,0);

#post table
DROP TABLE IF EXISTS t_post;
CREATE TABLE t_post (
  post_id INT(32) NOT NULL AUTO_INCREMENT COMMENT '帖子ID',
  topic_id INT(11) NOT NULL DEFAULT '1' COMMENT '话题ID',
  board_id INT(11) NOT NULL COMMENT '所属板块',
  user_id INT(11) NOT NULL COMMENT '发表用户ID',
  post_type TINYINT(4) NOT NULL DEFAULT '2' COMMENT '帖子类型，1：主帖子 2:回复帖子',
  post_title VARCHAR(100) NOT NULL COMMENT '帖子标题',
  post_text TEXT NOT NULL COMMENT '帖子内容',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (post_id)
)ENGINE = InnoDB AUTO_INCREMENT = 2 DEFAULT CHARSET = utf8 COMMENT '帖子';

INSERT INTO `t_post` VALUES (1,1,1,1,1,'育儿','培育健康聪明宝贝，分享您的经验心得\r\n','2011-05-07');

#board table
DROP TABLE IF EXISTS t_board;
CREATE TABLE t_board (
  board_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '论坛版块ID',
  board_name VARCHAR(150) NOT NULL DEFAULT '' COMMENT '版块名称',
  board_desc VARCHAR(255) DEFAULT NULL COMMENT '版块描述',
  topic_num INT(11) NOT NULL DEFAULT '0' COMMENT '话题数目',
  PRIMARY KEY (board_id)
)ENGINE = InnoDB AUTO_INCREMENT = 4 DEFAULT CHARSET = utf8 COMMENT '论坛版块';

INSERT INTO t_board VALUES (1,'育儿','培育健康聪明宝贝，分享您的经验心得\r\n',0);
INSERT INTO t_board VALUES (2,'儿歌','经典儿歌精选',0);
INSERT INTO t_board VALUES (3,'故事','世间百态小故事',0);

#board_manager table
DROP TABLE IF EXISTS t_board_manager;
CREATE TABLE t_board_manager (
  board_id INT(11) NOT NULL,
  user_id INT(11) NOT NULL,
  PRIMARY KEY (board_id,user_id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '论坛管理员';

#login_log table
DROP TABLE IF EXISTS t_login_log;
CREATE TABLE t_login_log (
  login_log_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '登录记录ID',
  user_id INT(11) DEFAULT NULL COMMENT '登录用户ID',
  login_datetime VARCHAR(20) NOT NULL COMMENT '登录时间',
  login_ip VARCHAR(30) NOT NULL DEFAULT '' COMMENT '登录IP',
  PRIMARY KEY (login_log_id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '登录历史记录';
