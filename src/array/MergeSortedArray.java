package array;

/**
 * Description: https://leetcode.com/problems/merge-sorted-array
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MergeSortedArray {

    public void mergeWithSingleLoop(int[] nums1, int m, int[] nums2, int n) {
        int resultPointer = m + n - 1;
        int firstPointer = m - 1;
        int secondPointer = n - 1;

        while (secondPointer >= 0) {
            if (firstPointer >= 0 && nums1[firstPointer] >= nums2[secondPointer]) {
                nums1[resultPointer] = nums1[firstPointer];
                firstPointer--;
            } else {
                nums1[resultPointer] = nums2[secondPointer];
                secondPointer--;
            }

            resultPointer--;
        }
    }

    public void mergeWithTwoLoops(int[] nums1, int m, int[] nums2, int n) {
        int resultPointer = m + n - 1;
        int firstPointer = m - 1;
        int secondPointer = n - 1;

        while (firstPointer >= 0 && secondPointer >= 0) {
            if (nums1[firstPointer] >= nums2[secondPointer]) {
                nums1[resultPointer] = nums1[firstPointer];
                firstPointer--;
            } else {
                nums1[resultPointer] = nums2[secondPointer];
                secondPointer--;
            }

            resultPointer--;
        }

        while (secondPointer >= 0) {
            nums1[resultPointer] = nums2[secondPointer];
            secondPointer--;
            resultPointer--;
        }
    }
}
