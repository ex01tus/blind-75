package array;

/**
 * Description: https://leetcode.com/problems/max-consecutive-ones
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int num : nums) {
            if (num == 1) {
                max = Math.max(max, count);
                count++;
            } else {
                count = 0;
            }
        }

        return max;
    }
}
