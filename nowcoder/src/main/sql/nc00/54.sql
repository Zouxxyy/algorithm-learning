# SQL54：查找排除最大、最小salary之后的当前(to_date = '9999-01-01' )员工的平均工资avg_salary

select avg(salary)
from salaries
where salary != (select max(salary) from salaries where to_date = '9999-01-01')
  and salary != (select min(salary) from salaries where to_date = '9999-01-01')
  and to_date = '9999-01-01';