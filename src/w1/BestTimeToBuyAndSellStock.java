package w1;

/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

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
