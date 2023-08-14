-- Description: https://leetcode.com/problems/number-of-unique-subjects-taught-by-each-teacher
-- Difficulty: Easy

SELECT teacher_id, COUNT(DISTINCT subject_id) AS cnt
FROM Teacher
GROUP BY teacher_id;