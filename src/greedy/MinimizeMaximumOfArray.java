package greedy;

/**
 * Description: https://leetcode.com/problems/minimize-maximum-of-array
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MinimizeMaximumOfArray {

    public int minimizeArrayValue(int[] nums) {
        long result = 0;
        long prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // ceil(a / b) = (a + b - 1) / b
            // a = prefixSum, b = i + 1
            // ceil(prefixSum / (i + 1)) = (prefixSum + i + 1 - 1) / (i + 1) = (prefixSum + i) / (i + 1)
            result = Math.max(result, (prefixSum + i) / (i + 1));
        }

        return (int) result;
    }
}
