CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE offset INT;
    SET offset = N-1;
  RETURN (
      # Write your MySQL query statement below.
       select DISTINCT salary from Employee order by salary desc LIMIT 1 OFFSET offset
  );
END