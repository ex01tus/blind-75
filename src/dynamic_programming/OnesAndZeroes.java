package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/ones-and-zeroes
 * Difficulty: Medium
 */
public class OnesAndZeroes {

    /**
     * Time complexity: O(m * n * l)
     * Space complexity: O(m * n * l)
     */
    public int findMaxFormViaRecursion(String[] strs, int m, int n) {
        return count(0, strs, m, n, new int[strs.length][m + 1][n + 1]);
    }

    private int count(int idx, String[] strs, int zeroesLeft, int onesLeft, int[][][] memo) {
        if (idx == strs.length) return 0;
        if (memo[idx][zeroesLeft][onesLeft] != 0) return memo[idx][zeroesLeft][onesLeft];

        Tuple current = toTuple(strs[idx]);
        int taken = (zeroesLeft - current.zeroes >= 0 && onesLeft - current.ones >= 0)
                ? 1 + count(idx + 1, strs, zeroesLeft - current.zeroes, onesLeft - current.ones, memo)
                : 0;
        int notTaken = count(idx + 1, strs, zeroesLeft, onesLeft, memo);

        memo[idx][zeroesLeft][onesLeft] = Math.max(taken, notTaken);
        return memo[idx][zeroesLeft][onesLeft];
    }

    /**
     * Time complexity: O(m * n * l)
     * Space complexity: O(m * n)
     */
    public int findMaxFormViaDP(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            Tuple current = toTuple(str);
            for (int zeroes = m; zeroes >= current.zeroes; zeroes--) {
                for (int ones = n; ones >= current.ones; ones--) {
                    dp[zeroes][ones] = Math.max(
                            dp[zeroes][ones],
                            dp[zeroes - current.zeroes][ones - current.ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

    private Tuple toTuple(String str) {
        int ones = 0;
        int zeroes = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') {
                zeroes++;
            } else {
                ones++;
            }
        }

        return new Tuple(zeroes, ones);
    }

    private record Tuple(int zeroes, int ones) {
    }
}
