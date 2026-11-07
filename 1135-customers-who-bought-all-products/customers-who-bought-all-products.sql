# Write your MySQL query statement below
SELECT customer_id
from customer
group by customer_id
having count(DISTINCT product_key) = (
    select count(*)
    from product
)