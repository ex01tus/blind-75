package array;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/k-radius-subarray-averages
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class KRadiusSubarrayAverages {

    public int[] getAverages(int[] nums, int k) {
        int[] averages = new int[nums.length];
        Arrays.fill(averages, -1);
        if (2 * k + 1 > nums.length) return averages;

        long sum = 0L;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            if (right > k * 2) {
                sum -= nums[left];
                left++;
            }

            if (right >= k * 2) {
                averages[right - k] = (int) (sum / (k * 2 + 1));
            }
        }

        return averages;
    }
}
