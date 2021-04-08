# SQL2: 查找入职员工时间排名倒数第三的员工所有信息

# 知识点：limit offest, count  其中 offest 是从 0 开始

select *
from employees
order by hire_date desc
limit 2, 1;