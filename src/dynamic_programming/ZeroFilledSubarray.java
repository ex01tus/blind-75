package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/number-of-zero-filled-subarrays
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ZeroFilledSubarray {

    public long zeroFilledSubarray(int[] nums) {
        int zeroSubarraysEndingAtCurrentIndex = 0;
        long total = 0;

        // [0]    -> 0 + 1 -> 1
        // 0[0]   -> 1 + 2 -> 3
        // 00[0]  -> 3 + 3 -> 6
        // 000[0] -> 6 + 4 -> 10
        for (int num : nums) {
            zeroSubarraysEndingAtCurrentIndex = num == 0 ? ++zeroSubarraysEndingAtCurrentIndex : 0;
            total += zeroSubarraysEndingAtCurrentIndex;
        }

        return total;
    }
}
