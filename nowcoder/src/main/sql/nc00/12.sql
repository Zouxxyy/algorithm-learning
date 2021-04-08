# SQL12: 获取所有部门中当前员工薪水最高的相关信息

# 三表联查
select e.dept_no, e.emp_no, t.maxSalary
from dept_emp as e
         join salaries as s
         join
     (
         select e.dept_no, max(s.salary) as maxSalary
         from dept_emp e
                  join salaries s
                       on e.emp_no = s.emp_no
         group by e.dept_no
     ) t
     on e.emp_no = s.emp_no and e.dept_no = t.dept_no and s.salary = t.maxSalary
order by e.dept_no;


# 开窗
select t.dept_no, t.emp_no, t.maxSalary
from (select e.dept_no,
             e.emp_no,
             s.salary                                                          as maxSalary,
             row_number() over (partition by e.dept_no order by s.salary desc) as row_num
      from dept_emp e
               join salaries s
                    on e.emp_no = s.emp_no) t
where t.row_num = 1;