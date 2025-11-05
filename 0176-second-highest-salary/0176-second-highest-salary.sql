# Write your MySQL query statement below
-- select (select DISTINCT salary from Employee order by salary desc LIMIT 1 OFFSET 1) as SecondHighestSalary;

select DISTINCT MAX(salary) as SecondHighestSalary from Employee where salary < (select MAX(salary) from Employee);