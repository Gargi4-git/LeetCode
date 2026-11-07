# Write your MySQL query statement below
SELECT id, 
CASE WHEN p_id IS NULL THEN 'Root'
WHEN id not in (
    SELECT p_id
    FROM Tree
    WHERE p_id IS NOT NULL
) THEN 'Leaf'
ELSE 'Inner'
END AS Type
FROM Tree;