package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/combination-sum-iv
 * Difficulty: Medium
 */
public class CombinationSum4 {

    /**
     * Time complexity: O(target * n)
     * Space complexity: O(target * n)
     */
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        return count(nums, target, memo);
    }

    private int count(int[] nums, int remains, Map<Integer, Integer> memo) {
        if (remains < 0) return 0;
        if (remains == 0) return 1;

        if (memo.containsKey(remains)) {
            return memo.get(remains);
        }

        int count = 0;
        for (int num : nums) {
            count += count(nums, remains - num, memo);
        }

        memo.put(remains, count);

        return count;
    }

    /**
     * Time complexity: O(target * maxLength)
     * Space complexity: O(target * maxLength)
     */
    public int combinationSum4WithNegativeNumbers(int[] nums, int target, int maxLength) {
        Map<String, Integer> memo = new HashMap<>();
        return count(nums, 0, maxLength, target, memo);
    }

    private int count(
            int[] nums,
            int currentLength,
            int maxLength,
            int remains,
            Map<String, Integer> memo) {
        // max length should be restricted because of the possible cycles, e.g. [1, -1]
        if (currentLength > maxLength) return 0;
        if (remains == 0) return 1;

        // because of the negative numbers, we can have the same sum on different steps
        String lengthToRemainsKey = currentLength + ":" + remains;
        if (memo.containsKey(lengthToRemainsKey)) {
            return memo.get(lengthToRemainsKey);
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += count(nums, currentLength + 1, maxLength, remains - nums[i], memo);
        }
        memo.put(lengthToRemainsKey, count);

        return count;
    }
}
