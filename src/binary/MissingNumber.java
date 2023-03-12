package binary;

/**
 * Description: https://leetcode.com/problems/missing-number
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MissingNumber {

    public int missingNumberViaBitManipulation(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) { // 3, 0, 1
            missing = missing ^ nums[i] ^ i;    // XOR: 3 ^ (3 ^ 0) ^ (0 ^ 1) ^ (1 ^ 2) = 2
        }

        return missing;
    }

    public int missingNumberViaArithmeticProgression(int[] nums) {
        // sum = ((a1 + an) / 2) * n
        // a1 = 0; an = nums.length
        // n = nums.length + 1, because one number is missing
        int expectedSum = (int) ((0 + nums.length) / 2.0 * (nums.length + 1));

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}
