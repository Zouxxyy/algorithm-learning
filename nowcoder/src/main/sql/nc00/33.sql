# SQL33: 创建一个actor表，包含如下列信息

create table actor
(
    actor_id    smallint(5) primary key,
    first_name  varchar(45) not null,
    last_name   varchar(45) not null,
    last_update date        not null
);