# Write your MySQL query statement below
select E.employee_id, E.department_id from Employee E where E.primary_flag = 'Y' OR (select COUNT(*) from Employee where employee_id = E.employee_id) = 1;