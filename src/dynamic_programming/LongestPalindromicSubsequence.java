package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/longest-palindromic-subsequence
 * Difficulty: Medium
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int right = 0; right < s.length(); right++) {
            for (int left = right; left >= 0; left--) {
                if (left == right) {
                    dp[left][right] = 1;
                    continue;
                }

                if (s.charAt(left) == s.charAt(right)) {
                    int length = right - left + 1;
                    dp[left][right] = length <= 3 ? length : dp[left + 1][right - 1] + 2;
                } else {
                    dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
