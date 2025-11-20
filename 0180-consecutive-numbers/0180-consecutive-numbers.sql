# Write your MySQL query statement below
Select DISTINCT num AS ConsecutiveNums from Logs L where num = (Select num from Logs where id = L.id + 1) AND num = (Select num from Logs where id = L.id + 2);