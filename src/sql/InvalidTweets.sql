-- Description: https://leetcode.com/problems/invalid-tweets
-- Difficulty: Easy

SELECT tweet_id
FROM Tweets
WHERE LENGTH(content) > 15;