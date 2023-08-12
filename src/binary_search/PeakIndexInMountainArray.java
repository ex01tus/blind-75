package binary_search;

/**
 * Description: https://leetcode.com/problems/peak-index-in-a-mountain-array
 * Difficulty: Medium
 * Time complexity: O(log n)
 * Space complexity: O(1)
 */
public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
