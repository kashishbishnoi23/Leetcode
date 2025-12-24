# Write your MySQL query statement below
select t1.id, 
CASE WHEN MOD(t1.id , 2) = 0 THEN (select student from Seat where id = t1.id - 1) 
ELSE 
  CASE WHEN EXISTS (select student from Seat where id = t1.id + 1)
  THEN (select student from Seat where id = t1.id + 1)
  ELSE t1.student 
  END
  END AS student
  from Seat t1;

