package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/two-sum
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            int pair = target - nums[i];
            Integer pairIndex = seen.get(pair);
            if (pairIndex != null) {
                return new int[]{i, pairIndex};
            } else {
                seen.put(nums[i], i);
            }
        }

        throw new RuntimeException();
    }
}
