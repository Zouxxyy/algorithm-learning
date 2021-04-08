# SQL21: 查找所有员工自入职以来的薪水涨幅情况

# 构建两个新表 join

select t1.emp_no, (t2.to_salary - t1.from_salary) growth
from (select s.emp_no, s.salary from_salary
      from salaries s
               join employees e
                    on s.emp_no = e.emp_no
      where s.from_date = e.hire_date) t1
         join
     (select s.emp_no, s.salary to_salary
      from salaries s
      where s.to_date = '9999-01-01') t2
     on t1.emp_no = t2.emp_no
order by growth;