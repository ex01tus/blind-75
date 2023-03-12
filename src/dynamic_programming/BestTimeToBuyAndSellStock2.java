package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class BestTimeToBuyAndSellStock2 {

    public int maxProfitViaStateMachine(int[] prices) {
        int sold = 0;
        int bought = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int prevSold = sold;
            int prevBought = bought;

            // can get to SOLD from SOLD by resting or BOUGHT by selling
            sold = Math.max(prevSold, prevBought + prices[i]);
            // can get to BOUGHT from BOUGHT by resting or SOLD by buying
            bought = Math.max(prevBought, prevSold - prices[i]);
        }

        return sold;
    }

    public int maxProfitViaGreedyAlgo(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
