# Write your MySQL query statement below
SELECT e.name,  b.Bonus
FROM Employee e
LEFT JOIN Bonus b
on e.empID =  b.empID
where bonus < 1000 OR bonus IS NULL
;

