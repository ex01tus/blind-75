package array;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/max-number-of-k-sum-pairs
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(log n)
 */
public class MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int pairs = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > k) {
                right--;
            } else if (sum < k) {
                left++;
            } else {
                pairs++;
                left++;
                right--;
            }
        }

        return pairs;
    }
}
