package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/maximum-sum-circular-subarray
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircularViaModifiedKadaneAlgo(int[] nums) {
        // we keep track of both minimum sum subarray and maximum size subarray
        int minSum = 0;
        int maxSum = 0;
        int totalSum = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            minSum = Math.min(minSum + num, num);
            maxSum = Math.max(maxSum + num, num);
            totalSum += num;

            min = Math.min(min, minSum);
            max = Math.max(max, maxSum);
        }

        // maximum sum circular subarray can either be in the middle of a regular array -> [min] [max] [min] -> max
        // or on both ends of it -> [max] [min] [max] -> totalSum - min
        return max > 0 ? Math.max(max, totalSum - min) : max;
    }
}
