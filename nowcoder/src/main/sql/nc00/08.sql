# SQL8: 找出所有员工当前薪水salary情况

# 方式一：distinct
select distinct salary
from salaries
order by salary desc;

# 方式二：group by (推荐)
select salary
from salaries
group by salary
order by salary desc;