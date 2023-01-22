package array;

/**
 * Description: https://leetcode.com/problems/move-zeroes
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int zero = 0;
        int nonZero = 0;

        while (nonZero < nums.length) {
            if (nums[nonZero] == 0) {
                nonZero++;
            } else {
                swap(nums, zero, nonZero);
                zero++;
                nonZero++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
