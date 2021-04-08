# SQL5: 查找所有员工的last_name和first_name以及对应部门编号dept_no

select e.last_name, e.first_name, d.dept_no
from employees e
         left join dept_emp d
                   on e.emp_no = d.emp_no;