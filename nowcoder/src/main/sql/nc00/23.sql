# SQL23: 对所有员工的当前薪水按照salary进行按照1-N的排名

select emp_no, salary, dense_rank() over (order by salary desc) as t_rank
from salaries;