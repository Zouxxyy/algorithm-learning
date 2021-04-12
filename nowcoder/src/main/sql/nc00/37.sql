# SQL37: 对first_name创建唯一索引uniq_idx_firstname，对last_name创建普通索引idx_lastname

create index idx_lastname on actor (last_name);
create unique index uniq_idx_firstname on actor (first_name);