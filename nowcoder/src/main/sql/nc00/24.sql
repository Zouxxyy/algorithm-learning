# SQL24: 获取所有非manager员工当前的薪水情况

select d.dept_no, e.emp_no, s.salary
from employees as e
         left join dept_emp as d on e.emp_no = d.emp_no
         left join dept_manager as m on d.dept_no = m.dept_no
         join salaries as s on e.emp_no = s.emp_no
where d.emp_no != m.emp_no;