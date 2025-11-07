# Write your MySQL query statement below
-- select customer_number from Orders group by customer_number order by COUNT(order_number) desc LIMIT 1;

SELECT customer_number
FROM Orders
GROUP BY customer_number
HAVING COUNT(order_number) = (
  SELECT MAX(order_count)
  FROM (
    SELECT COUNT(order_number) AS order_count
    FROM Orders
    GROUP BY customer_number
  ) AS counts
);

