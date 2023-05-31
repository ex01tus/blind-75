package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/integer-break
 * Difficulty: Medium
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int factor1 = Math.max(dp[j], j); // factor j further or use it as is
                int factor2 = Math.max(dp[i - j], i - j);

                dp[i] = Math.max(dp[i], factor1 * factor2);
            }
        }

        return dp[n];
    }
}
