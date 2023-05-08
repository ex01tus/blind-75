package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/fruit-into-baskets
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;

        Map<Integer, Integer> basket = new HashMap<>();
        int max = 0;
        while (right < fruits.length) {
            basket.merge(fruits[right], 1, Integer::sum);

            // shrink the window from the left
            while (basket.size() > 2) {
                int count = basket.merge(fruits[left], -1, Integer::sum);
                if (count == 0) basket.remove(fruits[left]);
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}
