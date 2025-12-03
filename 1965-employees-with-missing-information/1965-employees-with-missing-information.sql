# Write your MySQL query statement below
select E.employee_id from Employees E LEFT JOIN Salaries S on E.employee_id = S.employee_id where S.salary is NULL
UNION
select S.employee_id from Employees E RIGHT JOIN Salaries S on E.employee_id = S.employee_id where E.name is NULL
ORDER BY employee_id;
;