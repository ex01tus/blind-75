package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * Difficulty: Medium
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int maxProfitViaStateMachine(int[] prices) {
        int rested = 0;
        int sold = 0;
        int bought = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int prevRested = rested;
            int prevSold = sold;
            int prevBought = bought;

            // can get to RESTED from RESTED or SOLD states by resting
            rested = Math.max(prevRested, prevSold);
            // can get to SOLD from BOUGHT by selling
            sold = prevBought + prices[i];
            // can get to BOUGHT from BOUGHT by resting or RESTED by buying
            bought = Math.max(prevBought, prevRested - prices[i]);
        }

        return Math.max(rested, sold);
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public int maxProfitViaDP(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;

        for (int current = 1; current < prices.length; current++) {
            for (int prev = current; prev >= 0; prev--) {
                int buyPrev = prev > 1 ? dp[prev - 1] : 0;
                int prevPossibleProfit = prev > 2 ? dp[prev - 2] : 0;
                int sellNow = Math.max(prices[current] - prices[prev], 0);

                int maxProfit = Math.max(buyPrev, prevPossibleProfit + sellNow);
                dp[current] = Math.max(dp[current], maxProfit);
            }
        }

        return dp[dp.length - 1];
    }
}
