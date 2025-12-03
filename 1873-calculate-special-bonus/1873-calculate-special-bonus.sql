# Write your MySQL query statement below
select employee_id, 
CASE 
  when SUBSTR(name, 1, 1) = 'M' OR 
   MOD(employee_id, 2) = 0
  then 0
  ELSE salary
  END as bonus
from Employees ORDER BY employee_id;
  