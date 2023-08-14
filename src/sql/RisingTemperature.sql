-- Description: https://leetcode.com/problems/rising-temperature
-- Difficulty: Easy

SELECT today.id
FROM Weather AS today
         INNER JOIN Weather AS yesterday
                    ON TO_DAYS(today.recordDate) = TO_DAYS(yesterday.recordDate) + 1
WHERE today.temperature > yesterday.temperature;