-- Description: https://leetcode.com/problems/the-number-of-employees-which-report-to-each-employee
-- Difficulty: Easy

SELECT mgr.employee_id,
       mgr.name,
       COUNT(emp.employee_id) AS reports_count,
       ROUND(AVG(emp.age))    AS average_age
FROM Employees AS emp
         INNER JOIN Employees AS mgr
                    ON emp.reports_to = mgr.employee_id
GROUP BY employee_id
ORDER BY employee_id;