package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/longest-common-subsequence
 * Difficulty: Medium
 * Time complexity: O(n * m)
 * Space complexity: O(n * m)
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    int prev = (i > 0 && j > 0) ? memo[i - 1][j - 1] : 0;
                    memo[i][j] = prev + 1;
                } else {
                    int prev1 = i > 0 ? memo[i - 1][j] : 0;
                    int prev2 = j > 0 ? memo[i][j - 1] : 0;
                    memo[i][j] = Math.max(prev1, prev2);
                }
            }
        }

        return memo[text1.length() - 1][text2.length() - 1];
    }
}
