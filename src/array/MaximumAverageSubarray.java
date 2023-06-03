package array;

/**
 * Description: https://leetcode.com/problems/maximum-average-subarray-i
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaximumAverageSubarray {

    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Double.NEGATIVE_INFINITY;
        int windowSum = 0;
        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];
            if (i >= k) windowSum -= nums[i - k];

            if (i >= k - 1) {
                double windowAvg = (double) windowSum / k;
                maxAvg = Math.max(maxAvg, windowAvg);
            }
        }

        return maxAvg;
    }
}
