# SQL32: 将employees表的所有员工的last_name和first_name拼接起来作为Name，中间以一个空格区分

select concat(last_name, " ", first_name) as name
from employees