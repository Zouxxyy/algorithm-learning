# SQL57：使用含有关键字exists查找未分配具体部门的员工的所有信息。

select *
from employees as e
where not exists(select emp_no from dept_emp as d where e.emp_no = d.emp_no);