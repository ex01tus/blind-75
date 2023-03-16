package binary_search;

/**
 * Description: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * Difficulty: Medium
 * Time complexity: O(log n)
 * Space complexity: O(1)
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int from = findBound(nums, target, true);
        int to = findBound(nums, target, false);

        return new int[] {from, to};
    }

    private int findBound(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                bound = mid;
                if (isLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return bound;
    }
}
