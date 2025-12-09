# Write your MySQL query statement below
-- select P.product_id, P.product_name from Product P LEFT JOIN Sales S on P.product_id = S.product_id AND S.sale_date NOT BETWEEN '2019-01-01' AND '2019-03-31' where S.sale_date is NULL ; 

-- select P.product_id, P.product_name from Product P INNER JOIN Sales S ON P.product_id = S.product_id where P.product_id NOT IN
-- (select DISTINCT product_id from Sales where sale_date NOT BETWEEN '2019-01-01' AND '2019-03-31');

select P.product_id, P.product_name from Product P 
where
EXISTS (Select 1 from Product JOIN Sales on P.product_id = Sales.product_id)
AND
NOT EXISTS (Select 1 from Sales S2 where S2.product_id = P.product_id AND S2.sale_date NOT BETWEEN '2019-01-01' AND '2019-03-31');