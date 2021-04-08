# SQL22: 统计各个部门的工资记录数

select d.dept_no, d.dept_name, t.cnt
from departments d
         join
     (select d.dept_no, count(d.dept_no) cnt
      from dept_emp d
               join salaries s
                    on d.emp_no = s.emp_no
      group by d.dept_no) t
     on d.dept_no = t.dept_no;
