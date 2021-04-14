# SQL38: 针对actor表创建视图actor_name_view

create view actor_name_view
as
select first_name AS first_name_v, last_name AS last_name_v
from actor;