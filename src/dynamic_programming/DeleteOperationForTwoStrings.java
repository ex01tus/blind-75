package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/delete-operation-for-two-strings
 * Difficulty: Medium
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class DeleteOperationForTwoStrings {

    public int minDistanceViaLongestCommonSubsequence(String word1, String word2) {
        int longestCommonSubsequence = findLongestCommonSubsequence(word1, word2);
        return word1.length() + word2.length() - 2 * longestCommonSubsequence;
    }

    private int findLongestCommonSubsequence(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    int prev = (i > 0 && j > 0) ? dp[i - 1][j - 1] : 0;
                    dp[i][j] = prev + 1;
                } else {
                    int prev1 = i > 0 ? dp[i - 1][j] : 0;
                    int prev2 = j > 0 ? dp[i][j - 1] : 0;
                    dp[i][j] = Math.max(prev1, prev2);
                }
            }
        }

        return dp[word1.length() - 1][word2.length() - 1];
    }

    public int minDistanceViaDeletionsCount(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                    continue;
                }

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
