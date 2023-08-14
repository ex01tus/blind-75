-- Description: https://leetcode.com/problems/percentage-of-users-attended-a-contest
-- Difficulty: Easy

SELECT contest_id,
       ROUND(COUNT(user_id) / (SELECT COUNT(*) FROM Users) * 100, 2) AS percentage
FROM Register
GROUP BY contest_id
ORDER BY percentage DESC, contest_id