# Write your MySQL query statement below
-- SELECT product_id, product_name, description
-- FROM products
-- WHERE description REGEXP BINARY '[^A-Za-z0-9]SN[0-9]{4}-[0-9]{4}[^A-Za-z0-9]'
--    OR description REGEXP BINARY '^SN[0-9]{4}-[0-9]{4}[^A-Za-z0-9]'   -- pattern at start
--    OR description REGEXP BINARY '[^A-Za-z0-9]SN[0-9]{4}-[0-9]{4}$'   -- pattern at end
--    OR description REGEXP BINARY '^SN[0-9]{4}-[0-9]{4}$'              -- full match
-- ORDER BY product_id;

SELECT product_id, product_name, description
FROM products
WHERE REGEXP_LIKE(
    description,
    '(^|[^A-Za-z0-9])SN[0-9]{4}-[0-9]{4}([^A-Za-z0-9]|$)',
    'c'       -- <- THIS FORCES CASE-SENSITIVE MATCH
)
ORDER BY product_id;

