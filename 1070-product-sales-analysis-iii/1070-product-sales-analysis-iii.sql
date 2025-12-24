# Write your MySQL query statement below
-- Select product_id, year as first_year, quantity, price from Sales S1 where year = (Select MIN(year) from Sales where S1.product_id = product_id);

Select t1.product_id, t1.year as first_year, t1.quantity, t1.price from Sales t1 LEFT JOIN Sales t2 ON t1.product_id = t2.product_id AND t2.year < t1.year where t2.product_id is NULL;

