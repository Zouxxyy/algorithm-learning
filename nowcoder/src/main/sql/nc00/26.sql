# SQL26: 汇总各个部门当前员工的title类型的分配数目

select d.dept_no, d.dept_name, t.title, count(t.emp_no) as 'count'
from departments as d
         join dept_emp as e on d.dept_no = e.dept_no
         join titles as t on e.emp_no = t.emp_no
group by d.dept_no, t.title
order by d.dept_no