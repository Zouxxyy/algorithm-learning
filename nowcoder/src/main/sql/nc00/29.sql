# SQL29: 使用join查询方式找出没有分类的电影id以及名称

select f.film_id, f.title
from film as f
         left join film_category as fc on f.film_id = fc.film_id
where fc.category_id is null;