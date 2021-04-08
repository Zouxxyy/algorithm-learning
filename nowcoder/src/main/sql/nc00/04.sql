# SQL4: 查找所有已经分配部门的员工的last_name和first_name

select e.last_name, e.first_name, d.dept_no
from employees e
         join dept_emp d
              on e.emp_no = d.emp_no;