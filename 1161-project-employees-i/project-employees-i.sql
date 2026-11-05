# Write your MySQL query statement below
SELECT p.project_id, Round(avg(e.experience_years), 2) as average_years
from Project p
JOIN Employee e
on p.employee_id = e.employee_id
group by project_id
