# Write your MySQL query statement below
SELECT e.name, b.bonus
From Employee e
LEFT JOIN Bonus b
on e.empID= b.empID
where bonus<1000 or bonus IS NULL
GROUP BY e.empID