# SQL30: 使用子查询的方式找出属于Action分类的所有电影对应的title,description

select f.title, f.description
from film as f
         join film_category as fc on f.film_id = fc.film_id
where fc.category_id in (select category_id from category where name = 'Action');