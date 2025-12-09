# Write your MySQL query statement below
select E.employee_id from Employees E where E.salary < 30000 AND E.manager_id is NOT NULL AND  NOT EXISTS(select * from Employees where employee_id = E.manager_id) order by E.employee_id;
