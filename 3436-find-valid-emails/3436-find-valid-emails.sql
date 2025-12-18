# Write your MySQL query statement below
select user_id, email from Users where email REGEXP '^[A-Za-z0-9]+@[A-Za-z]+\\.com$' ORDER BY user_id;