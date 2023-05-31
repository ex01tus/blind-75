package array;

/**
 * Description: https://leetcode.com/problems/next-permutation
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int firstDecreasing = nums.length - 2;
        // 1 5 8 [4] 7 6 5 3 1
        while (firstDecreasing >= 0
                && nums[firstDecreasing] >= nums[firstDecreasing + 1]) {
            firstDecreasing--;
        }

        if (firstDecreasing >= 0) {
            // 1 5 8 [4] 7 6 [5] 3 1
            int firstGreater = nums.length - 1;
            while (nums[firstGreater] <= nums[firstDecreasing]) {
                firstGreater--;
            }

            // 1 5 8 [4] 7 6 [5] 3 1 -> 1 5 8 [5] 7 6 [4] 3 1
            swap(nums, firstDecreasing, firstGreater);
        }

        // 1 5 8 5 [7 6 4 3 1] -> 1 5 8 5 [1 3 4 6 7]
        reverseStartingFrom(nums, firstDecreasing + 1);
    }

    private void reverseStartingFrom(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
