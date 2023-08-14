-- Description: https://leetcode.com/problems/biggest-single-number
-- Difficulty: Easy

SELECT MAX(num) AS num
FROM (SELECT num
      FROM MyNumbers
      GROUP BY num
      HAVING COUNT(num) = 1) AS tmp;