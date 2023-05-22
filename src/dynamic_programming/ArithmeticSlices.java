package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/arithmetic-slices
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;

        int subarrays = 0;
        int totalCount = 0;
        for (int i = 2; i < nums.length; i++) {
            subarrays = nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1] ? subarrays + 1 : 0;
            totalCount += subarrays;
        }

        return totalCount;
    }
}
