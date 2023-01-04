package w2;

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
    public int climbStairsWithMemoization(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 2);

        return count(n, memo);
    }

    private int count(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);

        int count = count(n - 1, memo) + count(n - 2, memo);
        memo.put(n, count);

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
