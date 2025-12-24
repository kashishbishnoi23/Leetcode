# Write your MySQL query statement below

select t1.id,
   CASE WHEN p_id is NULL THEN "Root" 
        WHEN (SELECT COUNT(*) from Tree where p_id = t1.id) > 0 THEN "Inner"
        ELSE "Leaf"
    END AS type 
from Tree t1;


