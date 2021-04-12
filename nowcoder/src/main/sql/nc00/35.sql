# SQL35: 批量插入数据,如果数据已经存在，请忽略，不使用replace操作

insert ignore into actor
values (3, 'ED', 'CHASE', '2006-02-15 12:34:33');