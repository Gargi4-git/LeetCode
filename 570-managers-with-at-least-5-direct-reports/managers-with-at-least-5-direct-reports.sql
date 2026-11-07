# Write your MySQL query statement below
SELECT e2.name
FROM Employee e1
JOIn Employee e2
On e1.managerId = e2.id
group by e2.id, e2.name
HAVING COUNT(e1.id) >= 5;