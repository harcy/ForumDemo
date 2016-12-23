#create database;
CREATE database forum;

#user table
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
  user_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '??Id',
  user_name VARCHAR(30) NOT NULL COMMENT '???',
  password VARCHAR(30) NOT NULL COMMENT '??',
  avatar VARCHAR(100) COMMENT '??',
  user_type TINYINT(4) NOT NULL DEFAULT '1' COMMENT '1:????,2:???',
  locked TINYINT(4) NOT NULL DEFAULT '0' COMMENT '0:???,1:??',
  credit INT(11) DEFAULT NULL COMMENT '??',
  last_visit DATETIME DEFAULT NULL COMMENT '??????',
  last_ip VARCHAR(20) DEFAULT NULL COMMENT '????IP'
)ENGINE = InnoDB AUTO_INCREMENT= 2 DEFAULT CHARSET = utf8 COMMENT '??';

INSERT INTO t_user VALUE (1,'admin','admin',NULL,2,0,NULL,NULL,NULL);

#topic table
DROP TABLE IF EXISTS t_topic;
CREATE TABLE t_topic (
  topic_id INT(11) NOT NULL AUTO_INCREMENT COMMENT '??(??)ID',
  user_id INT(11) NOT NULL DEFAULT '0' COMMENT '????',
  #board_id INT(11) NOT NULL COMMENT '????',
  topic_title VARCHAR(100) NOT NULL DEFAULT '' COMMENT '??(??)??',
  create_time DATETIME NOT NULL COMMENT '????',
  last_post DATETIME NOT NULL COMMENT '??????',
  topic_views INT(11) NOT NULL DEFAULT '1' COMMENT '???',
  topic_replies INT(11) NOT NULL DEFAULT '0' COMMENT '???',
  digest TINYINT NOT NULL COMMENT '0:??????,1:?????',
  PRIMARY KEY (topic_id)
)ENGINE = InnoDB AUTO_INCREMENT = 4 DEFAULT CHARSET = utf8 COMMENT '??(??)';

INSERT INTO t_topic VALUE (1,1,'????','2011-05-16','2011-05-16',0,1,1);
INSERT INTO t_topic VALUE (2,1,'????','2011-05-16','2011-05-16',0,0,0);
INSERT INTO t_topic VALUES (3,1,'????','2011-09-18','2011-09-18',0,0,0);

#post table
DROP TABLE IF EXISTS t_post;
CREATE TABLE t_post (
  post_id INT(32) NOT NULL AUTO_INCREMENT COMMENT '',
  #topic_id INT(11) NOT NULL DEFAULT '1' COMMENT '',
  board_id INT(11) NOT NULL COMMENT '????',
  user_id INT(11) NOT NULL COMMENT '',
  post_type TINYINT(4) NOT NULL DEFAULT '2',
  post_title VARCHAR(100) NOT NULL COMMENT '',
  post_text TEXT NOT NULL COMMENT '',
  create_time DATETIME NOT NULL COMMENT
)ENGINE = InnoDB AUTO_INCREMENT = 2 DEFAULT CHARSET = utf8 COMMENT '??'