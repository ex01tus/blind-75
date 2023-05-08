package array;

/**
 * Description: https://leetcode.com/problems/range-sum-query-immutable
 * Difficulty: Easy
 * Time complexity: O(n) for constructor and O(1) for sumRange()
 * Space complexity: O(n)
 */
public class RangeSumQueryImmutable {

    private static class NumArray {

        private final int[] prefixSums;

        public NumArray(int[] nums) {
            prefixSums = new int[nums.length + 1];

            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                prefixSums[i + 1] = sum;
            }
        }

        public int sumRange(int left, int right) {
            return prefixSums[right + 1] - prefixSums[left];
        }
    }
}
