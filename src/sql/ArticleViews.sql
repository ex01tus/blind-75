-- Description: https://leetcode.com/problems/article-views-i
-- Difficulty: Easy

SELECT DISTINCT author_id AS id
FROM Views
WHERE author_id = viewer_id
ORDER BY author_id;