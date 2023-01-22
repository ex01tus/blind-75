package array;

/**
 * Description: https://leetcode.com/problems/squares-of-a-sorted-array
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[right]) >= Math.abs(nums[left])) {
                squares[i] = nums[right] * nums[right];
                right--;
            } else {
                squares[i] = nums[left] * nums[left];
                left++;
            }
        }

        return squares;
    }
}
