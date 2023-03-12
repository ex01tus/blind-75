package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/longest-increasing-subsequence
 * Difficulty: Medium
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLISViaDP(int[] nums) {
        int[] dp = new int[nums.length];
        int longest = 1;

        for (int left = nums.length - 1; left >= 0; left--) {
            for (int right = left; right < nums.length; right++) {
                if (left == right) {
                    dp[left] = 1;
                    continue;
                }

                if (nums[left] < nums[right]) {
                    dp[left] = Math.max(dp[left], dp[right] + 1);
                }
            }

            longest = Math.max(longest, dp[left]);
        }

        return longest;
    }
}
