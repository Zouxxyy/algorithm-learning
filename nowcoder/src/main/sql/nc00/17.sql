# SQL19: 获取当前薪水第二多的员工的emp_no以及其对应的薪水salary

select emp_no, salary
from salaries
order by salary desc
limit 1, 1;