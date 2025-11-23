# Write your MySQL query statement below
-- Update Salary SET sex = 'm' where sex = 'f' AND SET sex = 'f' where sex = 'm';

Update Salary set sex = CASE 
when sex = 'f' then 'm'
when sex = 'm' then 'f' 
END;