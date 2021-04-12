# SQL36: 创建一个actor_name表，将actor表中的所有first_name以及last_name导入改表

create table if not exists actor_name
(
    first_name varchar(45) not null,
    last_name  varchar(45) not null
);

insert into actor_name
select first_name, last_name
from actor;