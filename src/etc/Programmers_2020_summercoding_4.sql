-- SELECT p.user_id, count(p.user_id) purchase_count, c.price total_price
-- from game_users u
-- right join purchases p
-- on u.id = p.user_id
-- join characters c
-- on c.name = p.item
-- group by p.user_id
-- order by u.id;

SELECT u.id USER_ID, count(p.user_id) PURCHASE_COUNT, IFNULL(SUM(c.price), 0) TOTAL_PRICE
from game_users u
left join purchases p
on u.id = p.user_id
left join characters c
on c.name= p.item
group by u.id
order by u.id;