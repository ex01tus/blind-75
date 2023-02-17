package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/target-sum
 * Difficulty: Medium
 * Time complexity: O(target * n)
 * Space complexity: O(target * n)
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return count(nums, 0, 0, target, memo);
    }

    private int count(
            int[] nums,
            int start,
            int currentSum,
            int targetSum,
            Map<String, Integer> memo) {
        if (start == nums.length) {
            if (currentSum == targetSum) return 1;
            return 0;
        }

        // because of the negative numbers, we can have the same sum on different steps
        String indexToSumKey = start + ":" + currentSum;
        if (memo.containsKey(indexToSumKey)) { // check whether we had the same sum on the same index
            return memo.get(indexToSumKey);
        }

        int count = count(nums, start + 1, currentSum + nums[start], targetSum, memo)
                + count(nums, start + 1, currentSum - nums[start], targetSum, memo);
        memo.put(indexToSumKey, count);

        return count;
    }
}
