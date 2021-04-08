# SQL19: 查找所有员工的last_name和first_name以及对应的dept_name

select e.last_name, e.first_name, d.dept_name
from employees e
         left join
     (select dept_emp.emp_no, dept_emp.dept_no, departments.dept_name
      from dept_emp
               join departments
                    on dept_emp.dept_no = departments.dept_no) as d
     on e.emp_no = d.emp_no;