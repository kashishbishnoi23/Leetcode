# Write your MySQL query statement below
-- Select D.name as 'Department', E.name as 'Employee', E.salary as 'Salary' from Department D join Employee E ON E.departmentId = D.id where (Select COUNT(DISTINCT E2.salary) from Employee E2 where E2.departmentId = E.departmentId AND E2.salary > E.salary) <= 2;



select D.name as Department, E.name as Employee, E.salary as Salary from Employee E join Department D on E.departmentId = D.id where (select COUNT(DISTINCT salary) from Employee where salary > E.salary AND E.departmentId = departmentId) <= 2;