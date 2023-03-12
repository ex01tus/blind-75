package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/house-robber-ii
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class HouseRobber2 {

    public int rob(int[] houses) {
        if (houses.length < 2) return houses[0];

        return Math.max(
                rob(houses, 0, houses.length - 1), // skip last house
                rob(houses, 1, houses.length));       // skip first house
    }

    private int rob(int[] houses, int from, int to) {
        int adjacentRobbery = 0;
        int prevPossibleRobbery = 0;

        for (int i = from; i < to; i++) {
            int tmp = adjacentRobbery;
            adjacentRobbery = Math.max(adjacentRobbery, prevPossibleRobbery + houses[i]);
            prevPossibleRobbery = tmp;
        }

        return adjacentRobbery;
    }
}
