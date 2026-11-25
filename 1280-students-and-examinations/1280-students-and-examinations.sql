# Write your MySQL query statement below
SELECT s.student_id, s.student_name, su.subject_name, COUNT(e.subject_name) as attended_exams
from Students s
cross join Subjects su
left Join Examinations e 
on s.student_id =e.student_id AND su.subject_name =e.subject_name
GROUP BY s.student_id, s.student_name, su.subject_name
ORDER BY s.student_id, su.subject_name;
