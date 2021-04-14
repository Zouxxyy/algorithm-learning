# SQL44: 将id=5以及emp_no=10001的行数据替换成id=5以及emp_no=10005,其他数据保持不变，使用replace实现。

update titles_test
set emp_no=replace(emp_no, 10001, 10005)
where id = 5;