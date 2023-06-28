package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/maximum-subarray
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaximumSubarray {

    public int maxSubArrayViaKadaneAlgo(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            max = Math.max(sum, max);
        }

        return max;
    }
}
