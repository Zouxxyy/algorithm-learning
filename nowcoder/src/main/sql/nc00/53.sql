# SQL53：按照dept_no进行汇总，属于同一个部门的emp_no按照逗号进行连接，结果给出dept_no以及连接出的结果employees

select dept_no, group_concat(emp_no) as employees
from dept_emp
group by dept_no;