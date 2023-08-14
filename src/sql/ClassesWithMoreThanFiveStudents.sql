-- Description: https://leetcode.com/problems/classes-more-than-5-students
-- Difficulty: Easy

SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5;