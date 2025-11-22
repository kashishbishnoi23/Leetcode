# Write your MySQL query statement below
Select *, if (x+y > z and y+z > x and x+z > y, "Yes", "No") as triangle from triangle;