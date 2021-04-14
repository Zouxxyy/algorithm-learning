# SQL41: 构造一个触发器audit_log，在向employees表中插入一条数据的时候，触发插入相关的数据到audit中

create trigger audit_log
    after insert
    on employees_test
    for each row
begin
    insert into audit values (new.id, new.name);
end;