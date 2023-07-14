package array;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/two-sum-less-than-k
 * Difficulty: Easy
 * Time complexity: O(nlog n)
 * Space complexity: O(log n)
 */
public class TwoSumLessThanK {

    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        int max = -1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum >= k) {
                right--;
            } else {
                max = Math.max(max, sum);
                left++;
            }
        }

        return max;
    }
}
