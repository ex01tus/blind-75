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

        for (int i = 0; i < nums.length; i++) {
            int possiblePair = target - nums[i];
            Integer possiblePairIndex = seen.get(possiblePair);
            if (possiblePairIndex != null) {
                return new int[] {i, possiblePairIndex};
            }

            seen.put(nums[i], i);
        }

        throw new RuntimeException();
    }
}
