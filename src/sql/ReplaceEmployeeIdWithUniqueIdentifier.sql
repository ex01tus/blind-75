-- Description: https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier
-- Difficulty: Easy

SELECT u.unique_id, e.name
FROM EmployeeUNI AS u
         RIGHT JOIN Employees AS e
                    ON u.id = e.id;