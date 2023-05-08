package array;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {

    // since the answer may be too large, return it modulo 10^9 + 7
    private static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int[] powersOfTwo = precomputePowers(nums);
        int result = 0;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // all possible subsequences in [left + 1; right]
                result += powersOfTwo[right - left];
                result %= MOD;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    private int[] precomputePowers(int[] nums) {
        int[] powers = new int[nums.length];
        powers[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            powers[i] = (powers[i - 1] * 2) % MOD;
        }

        return powers;
    }
}
