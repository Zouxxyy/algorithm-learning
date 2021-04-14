# SQL51：查找字符串'10,A,B' 中逗号','出现的次数cnt。

select ((length("10,A,B") - length(replace("10,A,B", ",", "")))) as cnt;