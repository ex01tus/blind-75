package math;

/**
 * Description: https://leetcode.com/problems/missing-number-in-arithmetic-progression
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MissingNumberInArithmeticProgression {

    public int missingNumber(int[] arr) {
        int expectedSum = (int) ((arr[0] + arr[arr.length - 1]) / 2.0 * (arr.length + 1));
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}
