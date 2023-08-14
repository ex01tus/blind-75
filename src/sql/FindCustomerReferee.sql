-- Description: https://leetcode.com/problems/find-customer-referee
-- Difficulty: Easy

SELECT name
FROM Customer
WHERE referee_id <> '2'
   OR referee_id IS NULL;