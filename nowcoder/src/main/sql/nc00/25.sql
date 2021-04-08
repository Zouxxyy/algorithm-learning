# SQL25: 获取员工其当前的薪水比其manager当前薪水还高的相关信息

select e.emp_no, m.emp_no as manager_no, s1.salary as emp_salary, s2.salary as manager_salary
from dept_emp as e
         join dept_manager as m on e.dept_no = m.dept_no
         join salaries as s1 on e.emp_no = s1.emp_no
         join salaries as s2 on m.emp_no = s2.emp_no
where s1.salary > s2.salary;