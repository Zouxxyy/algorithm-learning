# SQL28: 查找描述信息中包括robot的电影对应的分类名称以及电影数目

# 这里用 c.category_id 进行 groupBy，而 c.name 和 c.category_id 是一对一关系，因此可以选它

select c.name, count(f.film_id)
from film as f
         join film_category as fc on f.film_id = fc.film_id
         join category as c on fc.category_id = c.category_id
where f.description like '%robot%'
  and c.category_id in (
    select category_id
    from film_category
    group by category_id
    having count(film_id) >= 5
)
group by c.category_id