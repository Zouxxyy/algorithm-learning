# SQL43: 将所有to_date为9999-01-01的全部更新为NULL,且 from_date更新为2001-01-01。

update titles_test
set to_date   = null,
    from_date = '2001-01-01'
where to_date = '9999-01-01';