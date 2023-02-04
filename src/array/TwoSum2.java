package array;

/**
 * Description: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }

        throw new RuntimeException();
    }
}
