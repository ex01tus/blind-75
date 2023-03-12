package greedy;

/**
 * Description: https://leetcode.com/problems/jump-game
 * Difficulty: Medium
 */
public class JumpGame {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean canJumpViaGreedyAlgo(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }

        return true;
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public boolean canJumpViaDP(int[] nums) {
        if (nums.length == 1) return true;

        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;

        for (int current = nums.length - 1; current > 0; current--) {
            if (!dp[current]) continue;

            for (int prev = 0; prev < current; prev++) {
                if (nums[prev] >= current - prev) {
                    dp[prev] = true;
                    if (prev == 0) return true;
                }
            }
        }

        return false;
    }
}
