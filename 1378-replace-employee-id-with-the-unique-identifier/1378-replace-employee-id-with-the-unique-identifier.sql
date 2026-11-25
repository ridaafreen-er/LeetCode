# Write your MySQL query statement below
SELECT  u.unique_id, e.name
From Employees as e
LEFT join EmployeeUNI as u
ON e.id=u.id;
