# SQL40: 在last_update后面新增加一列名字为create_date

alter table actor
    add (create_date datetime not null default '2020-10-01 00:00:00');