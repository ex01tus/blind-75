package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/count-ways-to-build-good-strings
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class CountWaysToBuildGoodStrings {

    // since the answer may be too large, return it modulo 10^9 + 7
    private static final int MOD = 1_000_000_007;

    public int countGoodStringsViaDP(int low, int high, int zeroes, int ones) {
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for (int length = 1; length <= high; length++) {
            int pickZeroes = length >= zeroes ? dp[length - zeroes] : 0;
            int pickOnes = length >= ones ? dp[length - ones] : 0;
            dp[length] = (pickZeroes + pickOnes) % MOD;
        }

        int count = 0;
        for (int length = low; length <= high; length++) {
            count += dp[length];
            count %= MOD;
        }

        return count;
    }

    public int countGoodStringsViaRecursion(int low, int high, int zeroes, int ones) {
        int count = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        for (int length = low; length <= high; length++) {
            count += count(length, zeroes, ones, memo);
            count %= MOD;
        }

        return count;
    }

    private int count(int length, int zeroes, int ones, Map<Integer, Integer> memo) {
        if (memo.containsKey(length)) return memo.get(length);
        if (length == 0) return 1; // was able to build string of a given length

        int count = 0;
        if (length >= zeroes) {
            count += count(length - zeroes, zeroes, ones, memo);
        }

        if (length >= ones) {
            count += count(length - ones, zeroes, ones, memo);
        }

        count %= MOD;
        memo.put(length, count);
        return count;
    }
}
