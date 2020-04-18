SELECT distinct c.user_id
from carts c right join cart_products p
on c.id = p.cart_id
where p.name = "밀가루"
order by c.user_id asc;