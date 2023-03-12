package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfitViaStateMachine(int[] prices, int fee) {
        int sold = 0;
        int bought = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int prevSold = sold;
            int prevBought = bought;

            // can get to SOLD from SOLD by resting or BOUGHT by selling with fee
            sold = Math.max(prevSold, prevBought + prices[i] - fee);
            // can get to BOUGHT from BOUGHT by resting or SOLD by buying
            bought = Math.max(prevBought, prevSold - prices[i]);
        }

        return sold;
    }
}
