package binary_search;

/**
 * Description: https://leetcode.com/problems/find-peak-element
 * Difficulty: Medium
 */
public class FindPeakElement {

    /**
     * Time complexity: O(log n)
     * Space complexity: O(1)
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;

        int left = 1;
        int right = nums.length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1; // rising slope, peak on the right
            } else {
                right = mid - 1; // falling slope, peak on the left
            }
        }

        return -1;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int findPeakElementViaLinearScan(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return i;
        }

        return nums.length - 1;
    }
}
