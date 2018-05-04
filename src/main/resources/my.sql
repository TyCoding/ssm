create table user(
  uid int primary key auto_increment,
  username varchar(100),
  password varchar(100)
) default charset = utf8;

create table customer(
  c_id int primary key auto_increment,
  c_name varchar(100),
  c_telephone varchar(100),
  c_address varchar(100),
  c_remark varchar(100)
) default charset = utf8;

insert into user values(1,'admin','admin');
delete from customer where c_id = 1;
delete from customer where c_id = 8;

insert into customer values(1,'涂陌','123456789','你猜','不想写备注');
insert into customer values(2,'逗瓜','123456789','你猜','不想写备注');
insert into customer values(3,'愤青','123456789','你猜','不想写备注');
insert into customer values(4,'咸鱼','123456789','你猜','不想写备注');
insert into customer values(5,'小白','123456789','你猜','不想写备注');
insert into customer values(6,'菜鸡','123456789','你猜','不想写备注');

show variables like 'character_set_database';
show create database ssm_paging;