# Write your MySQL query statement below

-- select Department.name(select MAX(salary) from (select Department.name as Department, Employee.name as Employee , Employee.salary as Salary from Employee join Department on Employee.departmentId = Department.id) group by Department.id);


select Department.name as Department, Employee.name as Employee, Employee.salary as Salary from Employee join Department
on Employee.departmentId = Department.id
where Employee.salary = (
select MAX(Employee.salary) from Employee where Employee.departmentId = Department.id
);

--  where Employee.salary = (select MAX(salary) from (select Employee join Department on Employee.departmentId = Department.id) group by Department.id);
