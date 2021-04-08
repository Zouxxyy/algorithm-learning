# SQL10: 获取所有非manager的员工emp_no

# 左连接 + null
select e.emp_no
from employees e
         left join dept_manager d
                   on e.emp_no = d.emp_no
where d.dept_no is null;