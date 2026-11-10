WITH product_counts AS (
    SELECT
        store_id,
        COUNT(DISTINCT product_name) AS total_products
    FROM inventory
    GROUP BY store_id
),
ranked_inventory AS (
    SELECT
        store_id,
        product_name,
        quantity,
        price,
        ROW_NUMBER() OVER (
            PARTITION BY store_id
            ORDER BY price DESC, inventory_id ASC
        ) AS expensive_rank,
        ROW_NUMBER() OVER (
            PARTITION BY store_id
            ORDER BY price ASC, inventory_id ASC
        ) AS cheap_rank
    FROM inventory
)
SELECT
    s.store_id,
    s.store_name,
    s.location,
    expensive.product_name AS most_exp_product,
    cheap.product_name AS cheapest_product,
    ROUND(
        cheap.quantity / expensive.quantity,
        2
    ) AS imbalance_ratio
FROM ranked_inventory expensive
JOIN ranked_inventory cheap
    ON expensive.store_id = cheap.store_id
JOIN product_counts pc
    ON expensive.store_id = pc.store_id
JOIN stores s
    ON s.store_id = expensive.store_id
WHERE expensive.expensive_rank = 1
  AND cheap.cheap_rank = 1
  AND pc.total_products >= 3
  AND expensive.quantity < cheap.quantity
ORDER BY
    imbalance_ratio DESC,
    s.store_name ASC;