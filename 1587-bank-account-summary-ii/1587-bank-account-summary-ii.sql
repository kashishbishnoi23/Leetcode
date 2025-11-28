# Write your MySQL query statement below
select U.name, SUM(T.amount) as balance from Users U join Transactions T on U.account = T.account  group by U.account having SUM(T.amount) > 10000;