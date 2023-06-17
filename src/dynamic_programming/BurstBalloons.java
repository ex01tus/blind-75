package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/burst-balloons
 * Difficulty: Hard
 * Time complexity: O(n^3)
 * Space complexity: O(n^2)
 */
public class BurstBalloons {

    public int maxCoinsViaRecursion(int[] nums) {
        return maxCoins(nums, 0, nums.length - 1, new int[nums.length][nums.length]);
    }

    private int maxCoins(int[] nums, int left, int right, int[][] memo) {
        if (left > right) return 0;
        if (memo[left][right] != 0) return memo[left][right];

        int max = 0;

        // `i` is the last balloon to burst
        // -> we can burst [left; i - 1] and [i + 1; right] independently
        for (int i = left; i <= right; i++) {
            int leftBurst = maxCoins(nums, left, i - 1, memo);
            int rightBurst = maxCoins(nums, i + 1, right, memo);

            // at this point we've already bursted [left; i - 1] and [i + 1; right]
            // -> leftBalloon will be the one on `left - 1`
            // -> rightBalloon will be the one on the `right + 1`
            int leftBalloon = left > 0 ? nums[left - 1] : 1;
            int rightBalloon = right < nums.length - 1 ? nums[right + 1] : 1;
            int currentBurst = leftBalloon * nums[i] * rightBalloon;

            max = Math.max(max, leftBurst + currentBurst + rightBurst);
        }

        memo[left][right] = max;
        return max;
    }
}
