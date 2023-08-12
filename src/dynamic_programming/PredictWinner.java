package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/predict-the-winner
 * Difficulty: Medium
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */
public class PredictWinner {

    private static final int FIRST_PLAYER = 0;
    private static final int SECOND_PLAYER = 1;

    public boolean predictTheWinner(int[] nums) {
        // we track FIRST_PLAYER's score as positive and SECOND_PLAYER's as negative
        // if total score is greater or equal than 0 -> FIRST_PLAYER wins
        return play(nums, 0, nums.length - 1, FIRST_PLAYER, new int[nums.length][nums.length]) >= 0;
    }

    private int play(int[] nums, int left, int right, int player, int[][] memo) {
        if (left > right) return 0;
        if (memo[left][right] != 0) return memo[left][right];

        if (player == FIRST_PLAYER) {
            int takeLeft = nums[left] + play(nums, left + 1, right, SECOND_PLAYER, memo);
            int takeRight = nums[right] + play(nums, left, right - 1, SECOND_PLAYER, memo);
            memo[left][right] = Math.max(takeLeft, takeRight);
        } else {
            int takeLeft = -nums[left] + play(nums, left + 1, right, FIRST_PLAYER, memo);
            int takeRight = -nums[right] + play(nums, left, right - 1, FIRST_PLAYER, memo);
            memo[left][right] = Math.min(takeLeft, takeRight);
        }

        return memo[left][right];
    }
}
