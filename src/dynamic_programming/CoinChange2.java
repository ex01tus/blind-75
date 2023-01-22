package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/coin-change-ii
 * Difficulty: Medium
 * Time complexity: O(n * m)
 * Space complexity: O(m)
 */
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                int prev = i - coin;
                dp[i] += dp[prev];
            }
        }

        return dp[amount];
    }
}
