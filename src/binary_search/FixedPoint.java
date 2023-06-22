package binary_search;

/**
 * Description: https://leetcode.com/problems/fixed-point
 * Difficulty: Easy
 * Time complexity: O(log n)
 * Space complexity: O(1)
 */
public class FixedPoint {

    public int fixedPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        int min = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > mid) {
                right = mid - 1;
            } else if (arr[mid] < mid) {
                left = mid + 1;
            } else {
                min = mid;
                right = mid - 1;
            }
        }

        return min;
    }
}
