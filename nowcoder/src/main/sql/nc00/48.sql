# SQL48: 请你写出更新语句，将所有获取奖金的员工当前的(salaries.to_date='9999-01-01')薪水增加10%。(emp_bonus里面的emp_no都是当前获奖的所有员工)

update salaries as s join emp_bonus as e on s.emp_no = e.emp_no
set salary=salary * 1.1
where to_date = '9999-01-01';