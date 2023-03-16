package binary_search;

/**
 * Description: https://leetcode.com/problems/search-insert-position
 * Difficulty: Easy
 * Time complexity: O(log n)
 * Space complexity: O(1)
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
