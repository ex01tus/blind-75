package dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/perfect-squares
 * Difficulty: Medium
 * Time complexity: O(n * sqrt(n))
 * Space complexity: O(n)
 */
public class PerfectSquares {

    public int numSquaresViaDP(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s * s <= n; s++) {
                if (s * s > i) continue;
                dp[i] = Math.min(dp[i], dp[i - s * s] + 1);
            }
        }

        return dp[n];
    }

    public int numSquaresViaRecursion(int n) {
        return count(n, new HashMap<>());
    }

    private int count(int remains, Map<Integer, Integer> memo) {
        if (remains == 0) return 0;

        if (memo.containsKey(remains)) {
            return memo.get(remains);
        }

        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= remains; i++) {
            count = Math.min(count, 1 + count(remains - i * i, memo));
        }

        memo.put(remains, count);
        return count;
    }
}
