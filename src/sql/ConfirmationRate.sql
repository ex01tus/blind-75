-- Description: https://leetcode.com/problems/confirmation-rate
-- Difficulty: Medium

SELECT s.user_id,
       ROUND(AVG(CASE WHEN c.action = 'confirmed' THEN 1.0 ELSE 0.0 END), 2) AS confirmation_rate
FROM Signups AS s
         LEFT JOIN Confirmations AS c
                   ON s.user_id = c.user_id
GROUP BY s.user_id