# Write your MySQL query statement below
-- SELECT id, COUNT(*) AS num
-- FROM (
--     SELECT requester_id AS id FROM RequestAccepted
--     UNION ALL
--     SELECT accepter_id  AS id FROM RequestAccepted
-- ) t
-- GROUP BY id
-- ORDER BY num DESC
-- LIMIT 1;


SELECT id, COUNT(*) AS num
FROM (
SELECT requester_id as id  from RequestAccepted 
UNION ALL
SELECT accepter_id as id  from RequestAccepted
) t 
GROUP BY id
ORDER BY num DESC
LIMIT 1
;


-- SELECT id, num
-- FROM (
--     SELECT id, COUNT(*) AS num
--     FROM (
--         SELECT requester_id AS id FROM RequestAccepted
--         UNION ALL
--         SELECT accepter_id  AS id FROM RequestAccepted
--     ) t
--     GROUP BY id
-- ) c
-- WHERE num = (
--     SELECT MAX(num)
--     FROM (
--         SELECT id, COUNT(*) AS num
--         FROM (
--             SELECT requester_id AS id FROM RequestAccepted
--             UNION ALL
--             SELECT accepter_id  AS id FROM RequestAccepted
--         ) t2
--         GROUP BY id
--     ) m
-- );
