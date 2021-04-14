# SQL50: 将employees表中的所有员工的last_name和first_name通过(')连接起来。(sqlite不支持concat，请用||实现，mysql支持concat)

select concat(last_name, "'", first_name)
from employees;