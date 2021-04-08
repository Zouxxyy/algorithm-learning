# SQL18: 查找当前薪水排名第二多的员工编号emp_no

select e.emp_no, s.salary, e.last_name, e.first_name
from employees e
         join salaries s
              on e.emp_no = s.emp_no
where s.salary = (select max(salary)
                  from salaries
                  where salary != (select max(salary) from salaries));