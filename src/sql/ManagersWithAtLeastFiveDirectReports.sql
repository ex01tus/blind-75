-- Description: https://leetcode.com/problems/managers-with-at-least-5-direct-reports
-- Difficulty: Medium

SELECT m.name
FROM Employee AS m
         INNER JOIN Employee AS e
                    ON m.id = e.managerId
GROUP BY m.id
HAVING COUNT(e.id) >= 5;