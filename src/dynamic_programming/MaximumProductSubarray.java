package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/maximum-product-subarray
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaximumProductSubarray {

    public int maxProductWithMinMaxSwap(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // if num < 0: min * num > max * num
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }

            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);

            result = Math.max(max, result);
        }

        return result;
    }

    public int maxProductWithoutMinMaxSwap(int[] nums) {
        int prevMax = nums[0];
        int prevMin = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Keep track of both min and max value:
            // - if num < 0: prevMin * nums > prevMax * nums
            // - if num > 0: prevMin * nums < prevMax * nums
            // - if num = 0: prevMin = 0, prevMax = 0

            int newMax = Math.max(
                    Math.max(prevMax * nums[i], prevMin * nums[i]),
                    nums[i]); // handle edge case when previous element is zero
            int newMin = Math.min(
                    Math.min(prevMax * nums[i], prevMin * nums[i]),
                    nums[i]);

            result = Math.max(newMax, result);

            prevMax = newMax;
            prevMin = newMin;
        }

        return result;
    }
}
