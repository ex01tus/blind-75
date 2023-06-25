package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/longest-arithmetic-subsequence
 * Difficulty: Medium
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */
public class LongestArithmeticSubsequence {

    public int longestArithSeqLength(int[] nums) {
        Map<Integer, Integer>[] dp = new HashMap[nums.length];
        int longest = 0;
        for (int right = 0; right < nums.length; right++) {
            dp[right] = new HashMap<>();
            for (int left = 0; left < right; left++) {
                int diff = nums[right] - nums[left];
                dp[right].put(diff, dp[left].getOrDefault(diff, 1) + 1);
                longest = Math.max(longest, dp[right].get(diff));
            }
        }

        return longest;
    }
}
