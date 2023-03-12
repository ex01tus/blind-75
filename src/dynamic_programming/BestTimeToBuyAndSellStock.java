package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfitViaStateMachine(int[] prices) {
        int sold = 0;
        int bought = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            sold = Math.max(sold, bought + prices[i]);
            bought = Math.max(bought, -prices[i]);
        }

        return sold;
    }

    public int maxProfitViaCommonSense(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - min;
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (prices[i] < min) {
                min = prices[i];
            }
        }

        return maxProfit;
    }
}
