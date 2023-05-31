package dynamic_programming;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/coin-change
 * Difficulty: Medium
 * Time complexity: O(n * m)
 * Space complexity: O(m)
 */
public class CoinChange {

    public int coinChange(int[] coins, int totalAmount) {
        int[] dp = new int[totalAmount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int amount = 1; amount <= totalAmount; amount++) {
            for (int coin : coins) {
                if (coin <= amount && dp[amount - coin] != Integer.MAX_VALUE) {
                    dp[amount] = Math.min(dp[amount], dp[amount - coin] + 1);
                }
            }
        }

        return dp[totalAmount] != Integer.MAX_VALUE ? dp[totalAmount] : -1;
    }
}
