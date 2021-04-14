# SQL46: 在audit表上创建外键约束，其emp_no对应employees_test表的主键id

alter table audit
    add constraint foreign key (emp_no)
        references employees_test (id);