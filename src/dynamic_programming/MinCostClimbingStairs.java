package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/min-cost-climbing-stairs
 * Difficulty: Easy
 */
public class MinCostClimbingStairs {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int minCostClimbingStairsViaFibonacci(int[] cost) {
        int twoStepsBefore = cost[0];
        int oneStepBefore = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int currentCost = Math.min(oneStepBefore, twoStepsBefore) + cost[i];
            twoStepsBefore = oneStepBefore;
            oneStepBefore = currentCost;
        }

        return Math.min(oneStepBefore, twoStepsBefore);
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int minCostClimbingStairsViaDP(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
