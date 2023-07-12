package array;

/**
 * Description: https://leetcode.com/problems/monotonic-array
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MonotonicArray {

    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2) return true;

        Boolean isIncreasing = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;

            if (isIncreasing == null) {
                isIncreasing = nums[i] > nums[i - 1];
            } else if (isIncreasing && nums[i] < nums[i - 1]) {
                return false;
            } else if (!isIncreasing && nums[i] > nums[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
