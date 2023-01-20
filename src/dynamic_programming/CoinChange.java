package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/coin-change
 * Difficulty: Medium
 * Time complexity: O(n * m)
 * Space complexity: O(m)
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;

        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);

        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            int count = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (currentAmount - coin < 0) continue;

                if (memo.get(currentAmount - coin) != null) {
                    count = Math.min(memo.get(currentAmount - coin) + 1, count);
                }
            }

            if (count != Integer.MAX_VALUE) {
                memo.put(currentAmount, count);
            }
        }

        return memo.getOrDefault(amount, -1);
    }
}
