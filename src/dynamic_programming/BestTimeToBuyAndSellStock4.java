package dynamic_programming;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv
 * Difficulty: Hard
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class BestTimeToBuyAndSellStock4 {

    public int maxProfitViaStateMachine(int k, int[] prices) {
        int[] sold = new int[k + 1];
        int[] bought = new int[k + 1];
        Arrays.fill(bought, -prices[0]);

        for (int i = 1; i < prices.length; i++) {
            for (int transaction = 1; transaction <= k; transaction++) {
                // can get to SOLD_T from SOLD_T by resting or from BOUGHT_T by selling
                sold[transaction] = Math.max(sold[transaction], bought[transaction] + prices[i]);
                // can get to BOUGHT_T from BOUGHT_T by resting or from SOLD_T-1 by buying
                bought[transaction] = Math.max(bought[transaction], sold[transaction - 1] - prices[i]);
            }
        }

        return sold[k];
    }
}
