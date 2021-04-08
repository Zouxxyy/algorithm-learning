# SQL16: 统计出当前各个title类型对应的员工当前薪水对应的平均工资

select t.title, avg(s.salary)
from titles t
         join salaries s
              on t.emp_no = s.emp_no
group by t.title
order by avg(s.salary)