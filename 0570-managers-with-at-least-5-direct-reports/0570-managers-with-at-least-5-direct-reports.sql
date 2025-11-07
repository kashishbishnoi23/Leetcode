# Write your MySQL query statement below
-- select E1.name from Employee E2 join Employee E1 on E2.managerId = E1.id group by E1.id having COUNT(E1.name) >= 5;

SELECT E1.name
FROM Employee E2
JOIN Employee E1 ON E2.managerId = E1.id
GROUP BY E1.id, E1.name
HAVING COUNT(E1.id) >= 5;



-- SELECT name
-- FROM (
--   SELECT E1.name
--   FROM Employee E2
--   JOIN Employee E1 ON E2.managerId = E1.id
--   GROUP BY E1.id, E1.name
--   HAVING COUNT(E1.id) >= 5
  
--   UNION ALL
  
--   SELECT NULL
-- ) AS result
-- LIMIT 1;
