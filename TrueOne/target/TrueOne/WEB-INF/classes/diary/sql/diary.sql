-- 日记表
create  table  if not exists tb_diary(
id INT primary key not null,
author varchar (64),
create_time timestamp ,
update_time timestamp ,
topic  varchar (64),
authorid  varchar (64),
diary_text varchar
);