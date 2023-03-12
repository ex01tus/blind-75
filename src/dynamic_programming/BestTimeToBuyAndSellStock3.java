package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii
 * Difficulty: Hard
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class BestTimeToBuyAndSellStock3 {

    public int maxProfitViaStateMachine(int[] prices) {
        int sold1 = 0;
        int bought1 = -prices[0];
        int sold2 = 0;
        int bought2 = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // can get to SOLD_1 from SOLD_1 by resting or from BOUGHT_1 by selling
            sold1 = Math.max(sold1, bought1 + prices[i]);
            // can get to BOUGHT_1 from BOUGHT_1 by restring or by replacing with a new buy
            bought1 = Math.max(bought1, -prices[i]);
            // can get to SOLD_2 from SOLD_2 by resting or from BOUGHT_2 by selling
            sold2 = Math.max(sold2, bought2 + prices[i]);
            // can get to BOUGHT_2 from BOUGHT_2 by resting or SOLD_1 by buying
            bought2 = Math.max(bought2, sold1 - prices[i]);
        }

        return sold2;
    }
}
