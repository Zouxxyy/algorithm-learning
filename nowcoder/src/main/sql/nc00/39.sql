# SQL39: 针对上面的salaries表emp_no字段创建索引idx_emp_no，查询emp_no为10005,

select *
from salaries
         force index (idx_emp_no)
where emp_no = 10005;