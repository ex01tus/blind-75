-- Description: https://leetcode.com/problems/primary-department-for-each-employee
-- Difficulty: Easy

SELECT employee_id, department_id
FROM Employee
WHERE employee_id IN (SELECT employee_id
                      FROM Employee
                      GROUP BY employee_id
                      HAVING COUNT(employee_id) = 1)
   OR primary_flag = 'Y';