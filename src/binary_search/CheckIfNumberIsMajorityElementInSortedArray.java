package binary_search;

/**
 * Description: https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array
 * Difficulty: Easy
 * Time complexity: O(log n)
 * Space complexity: O(1)
 */
public class CheckIfNumberIsMajorityElementInSortedArray {

    public boolean isMajorityElement(int[] nums, int target) {
        int firstOccurrence = findFirstOccurrence(nums, target);
        return firstOccurrence + nums.length / 2 < nums.length
                && nums[firstOccurrence + nums.length / 2] == target;
    }

    private int findFirstOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int min = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                min = mid;
                right = mid - 1;
            }
        }

        return min;
    }
}
