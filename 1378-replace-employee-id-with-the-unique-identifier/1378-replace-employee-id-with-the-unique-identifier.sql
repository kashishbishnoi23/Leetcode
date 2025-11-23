# Write your MySQL query statement below
select EU.unique_id , E.name from Employees E left join EmployeeUNI EU ON E.id = EU.id;