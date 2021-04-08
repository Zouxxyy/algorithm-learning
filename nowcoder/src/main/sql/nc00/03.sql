# SQL3: 查找各个部门当前领导当前薪水详情以及其对应部门编号dept_no

select d.emp_no, s.salary, s.from_date, s.to_date, d.dept_no
from dept_manager d
         join salaries s
              on d.emp_no = s.emp_no;