package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/coin-change-ii
 * Difficulty: Medium
 * Time complexity: O(n * m)
 * Space complexity: O(m)
 */
public class CoinChange2 {

    public int change(int totalAmount, int[] coins) {
        int[] dp = new int[totalAmount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int amount = coin; amount <= totalAmount; amount++) {
                dp[amount] += dp[amount - coin];
            }
        }

        return dp[totalAmount];
    }
}
