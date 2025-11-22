# Write your MySQL query statement below
-- Select P.id, P.email from Person P where P.id = (select MIN(id) from Person P1  where P.email = P1.email);

DELETE P1 from Person P1 join Person P2 on P1.email = P2.email AND P1.id > P2.id;