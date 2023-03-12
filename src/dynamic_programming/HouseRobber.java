package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/house-robber
 * Difficulty: Medium
 */
public class HouseRobber {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int rob(int[] houses) {
        int[] dp = new int[houses.length];
        for (int i = 0; i < houses.length; i++) {
            int adjacentRobbery = i > 0 ? dp[i - 1] : 0;
            int prevPossibleRobbery = i > 1 ? dp[i - 2] : 0;
            int currentRobbery = houses[i];
            dp[i] = Math.max(adjacentRobbery, prevPossibleRobbery + currentRobbery);
        }

        return dp[houses.length - 1];
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int robWithNoExtraSpace(int[] houses) {
        int adjacentRobbery = 0;
        int prevPossibleRobbery = 0;

        for (int currentRobbery : houses) {
            int tmp = adjacentRobbery;
            adjacentRobbery = Math.max(adjacentRobbery, prevPossibleRobbery + currentRobbery);
            prevPossibleRobbery = tmp;
        }

        return adjacentRobbery;
    }
}
