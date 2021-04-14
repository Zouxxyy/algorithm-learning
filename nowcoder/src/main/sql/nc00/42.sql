# SQL42: 删除emp_no重复的记录，只保留最小的id对应的记录。

delete
from titles_test
where id not in (
    select *
    from (select min(id) from titles_test group by emp_no) a);