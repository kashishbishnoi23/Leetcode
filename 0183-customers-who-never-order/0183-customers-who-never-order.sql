# Write your MySQL query statement below
select name as Customers from Customers left join Orders on Customers.id = Orders.customerId where Orders.id is NULL;

-- left join krenge => get all rows from left table and right table ki corresponding null ho jayengi -> if it is null return names 