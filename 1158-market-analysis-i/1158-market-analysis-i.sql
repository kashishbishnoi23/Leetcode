# Write your MySQL query statement below
SELECT
t1.user_id as buyer_id,
t1.join_date,
COUNT(o.order_id) as orders_in_2019 
from Users t1 
LEFT JOIN Orders o ON t1.user_id = o.buyer_id AND YEAR(o.order_date) = '2019'
GROUP BY t1.user_id;