package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/first-missing-positive
 * Difficulty: Hard
 */
public class FirstMissingPositive {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int firstMissingPositiveOptimalApproach(int[] nums) {
        int n = nums.length;

        // first missing positive is either in range [1, n] or equal to n + 1
        for (int i = 0; i < n; i++) {
            // "kill" all non-positive values
            if (nums[i] <= 0) nums[i] = n + 1;
        }

        // use array as hashtable
        // if number exists in an array mark its index (0-indexed) with negative value
        // [3, 4, 5, 1]
        // 3 exists -> [3, 4, -5, 1]
        // 4 exists -> [3, 4, -5, -1]
        // 5 is greater than n -> not interested
        // 1 exists -> [-1, 4, -5, -1]
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) continue;

            nums[num - 1] = -Math.abs(nums[num - 1]);
        }

        // [-1, 4, -5, -1] -> first non-negative value is 4 with index 2 (1-indexed) -> 2
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }

        // if all values are negative -> original array is e.g. [1, 2, 3, 4] -> 5
        return n + 1;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int firstMissingPositiveNaiveApproach(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (num > 0) seen.add(num);
        }

        for (int num = 1; num < Integer.MAX_VALUE; num++) {
            if (!seen.contains(num)) return num;
        }

        return -1;
    }
}
