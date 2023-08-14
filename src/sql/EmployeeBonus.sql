-- Description: https://leetcode.com/problems/employee-bonus
-- Difficulty: Easy

SELECT e.name, b.bonus
FROM Employee AS e
         LEFT JOIN Bonus AS b
                   ON e.empId = b.empId
WHERE bonus < 1000
   OR bonus IS NULL;