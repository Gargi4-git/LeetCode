WITH ranked_reviews AS (
    SELECT
        employee_id,
        review_date,
        rating,
        ROW_NUMBER() OVER (
            PARTITION BY employee_id
            ORDER BY review_date DESC
        ) AS rn
    FROM performance_reviews
),
last_three AS (
    SELECT
        employee_id,
        MAX(CASE WHEN rn = 1 THEN rating END) AS latest_rating,
        MAX(CASE WHEN rn = 2 THEN rating END) AS middle_rating,
        MAX(CASE WHEN rn = 3 THEN rating END) AS earliest_rating,
        COUNT(*) AS review_count
    FROM ranked_reviews
    WHERE rn <= 3
    GROUP BY employee_id
)
SELECT
    e.employee_id,
    e.name,
    lt.latest_rating - lt.earliest_rating AS improvement_score
FROM last_three lt
JOIN employees e
    ON lt.employee_id = e.employee_id
WHERE lt.review_count = 3
  AND lt.earliest_rating < lt.middle_rating
  AND lt.middle_rating < lt.latest_rating
ORDER BY
    improvement_score DESC,
    e.name ASC;