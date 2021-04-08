# SQL11: 获取所有员工当前的manager

select e.emp_no, m.emp_no as manager
from dept_emp as e
         join dept_manager as m
              on e.dept_no = m.dept_no
where e.emp_no != m.emp_no