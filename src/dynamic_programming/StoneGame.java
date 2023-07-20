package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/stone-game
 * Difficulty: Medium
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */
public class StoneGame {

    private static final int ALICE = 0;
    private static final int BOB = 1;

    public boolean stoneGame(int[] piles) {
        // we track Alice's score as positive and Bob's as negative
        // if total score is greater than 0 -> Alice wins
        return play(0, piles.length - 1, piles, ALICE, new int[piles.length][piles.length]) > 0;
    }

    private int play(int left, int right, int[] piles, int player, int[][] memo) {
        if (left > right) return 0;
        if (memo[left][right] != 0) return memo[left][right];

        if (player == ALICE) {
            // Alice tries to maximize her result
            int takeLeft = piles[left] + play(left + 1, right, piles, BOB, memo);
            int takeRight = piles[right] + play(left, right - 1, piles, BOB, memo);
            memo[left][right] = Math.max(takeLeft, takeRight);
        } else {
            // Bob tries to maximize his result, but we track his score as negative
            int takeLeft = -piles[left] + play(left + 1, right, piles, ALICE, memo);
            int takeRight = -piles[right] + play(left, right - 1, piles, ALICE, memo);
            memo[left][right] = Math.min(takeLeft, takeRight);
        }

        return memo[left][right];
    }
}
