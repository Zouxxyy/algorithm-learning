# SQL15: 查找employees表所有emp_no为奇数

select *
from employees
where emp_no & 1 = 1
  and last_name != 'Mary'
order by hire_date desc;