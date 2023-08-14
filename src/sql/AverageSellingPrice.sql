-- Description: https://leetcode.com/problems/average-selling-price
-- Difficulty: Easy

SELECT s.product_id,
       ROUND(SUM(s.units * p.price) / SUM(s.units), 2) AS average_price
FROM UnitsSold AS s
         LEFT JOIN Prices AS p
                   ON s.product_id = p.product_id
                       AND s.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY s.product_id;
