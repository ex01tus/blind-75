package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/climbing-stairs
 * Difficulty: Easy
 */
public class ClimbingStairs {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int climbStairsViaDP(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 1);
        dp.put(2, 2);

        return count(n, dp);
    }

    private int count(int n, Map<Integer, Integer> dp) {
        if (dp.containsKey(n)) return dp.get(n);

        int count = count(n - 1, dp) + count(n - 2, dp);
        dp.put(n, count);

        return count;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int climbStairsViaFibonacci(int n) {
        if (n <= 2) return n;

        int leftPrev = 1;
        int rightPrev = 2;

        for (int i = 3; i <= n; i++) {
            int count = leftPrev + rightPrev;
            leftPrev = rightPrev;
            rightPrev = count;
        }

        return rightPrev;
    }
}
