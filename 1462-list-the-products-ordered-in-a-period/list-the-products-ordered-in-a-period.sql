# Write your MySQL query statement below
SELECT p.product_name,
sum(o.unit) as unit
FROM Products p
JOIN orders o
    ON p.product_id = o.product_id
WHERE o.order_date >= '2020-02-01'
  AND o.order_date < '2020-03-01'
GROUP BY
    p.product_id,
    p.product_name
HAVING SUM(o.unit) >= 100;