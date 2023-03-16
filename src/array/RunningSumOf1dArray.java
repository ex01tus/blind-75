package array;

/**
 * Description: https://leetcode.com/problems/running-sum-of-1d-array
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {
        int[] running = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            running[i] = sum;
        }

        return running;
    }
}
