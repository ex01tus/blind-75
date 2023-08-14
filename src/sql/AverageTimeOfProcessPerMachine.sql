-- Description: https://leetcode.com/problems/average-time-of-process-per-machine
-- Difficulty: Easy

SELECT s.machine_id, ROUND(AVG(e.timestamp - s.timestamp), 3) AS processing_time
FROM Activity AS s
         INNER JOIN Activity AS e
                    ON s.machine_id = e.machine_id
                        AND s.process_id = e.process_id
                        AND s.activity_type = 'start'
                        AND e.activity_type = 'end'
GROUP BY s.machine_id;