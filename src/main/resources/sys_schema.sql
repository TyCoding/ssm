-- create database ssm character set utf8;

drop table if exists tb_user;
drop table if exists tb_customer;

create table tb_user(
  id int primary key auto_increment,
  username varchar(100),
  password varchar(100)
) default charset = utf8;

create table tb_customer(
  id int primary key auto_increment,
  name varchar(100),
  telephone varchar(100),
  address varchar(100),
  remark varchar(100)
) default charset = utf8;

insert into tb_user values(1,'admin','admin');

insert into tb_customer values(1,'涂陌','123456789','你猜','不想写备注');
insert into tb_customer values(2,'逗瓜','123456789','你猜','不想写备注');
insert into tb_customer values(3,'愤青','123456789','你猜','不想写备注');
insert into tb_customer values(4,'咸鱼','123456789','你猜','不想写备注');
insert into tb_customer values(5,'小白','123456789','你猜','不想写备注');
insert into tb_customer values(6,'菜鸡','123456789','你猜','不想写备注');

