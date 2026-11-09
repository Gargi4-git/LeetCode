WITH daily_amount AS (
    -- Step 1: Get total amount spent per day
    SELECT visited_on, SUM(amount) AS amount
    FROM Customer
    GROUP BY visited_on
),
rolling_window AS (
    -- Step 2: Calculate 7-day moving sum and average using window functions
    SELECT 
        visited_on,
        SUM(amount) OVER (
            ORDER BY visited_on 
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ) AS amount,
        ROUND(AVG(amount) OVER (
            ORDER BY visited_on 
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ), 2) AS average_amount,
        ROW_NUMBER() OVER (ORDER BY visited_on) AS rn
    FROM daily_amount
)
-- Step 3: Select rows starting from the 7th day onwards
SELECT visited_on, amount, average_amount
FROM rolling_window
WHERE rn >= 7
ORDER BY visited_on;