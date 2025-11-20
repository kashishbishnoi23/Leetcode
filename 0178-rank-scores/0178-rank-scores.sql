# Write your MySQL query statement below

Select S1.score, COUNT(S2.score) AS 'Rank' from Scores S1, (Select DISTINCT score from Scores) S2 where S2.score >= S1.score group by S1.Id ORDER BY S1.score DESC;


