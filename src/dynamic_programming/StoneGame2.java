package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/stone-game-ii
 * Difficulty: Medium
 * Time complexity: O(n^3)
 * Space complexity: O(n^2)
 */
public class StoneGame2 {

    private static final int ALICE = 0;
    private static final int BOB = 1;

    public int stoneGameII(int[] piles) {
        return count(0, piles, 1, ALICE, new int[2][piles.length + 1][piles.length + 1]);
    }

    private int count(int idx, int[] piles, int limit, int player, int[][][] memo) {
        if (idx == piles.length) return 0;
        if (memo[player][idx][limit] != 0) return memo[player][idx][limit];

        int stones = 0;
        int result = player == ALICE ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int x = 1; x <= Math.min(limit * 2, piles.length - idx); x++) {
            stones += piles[idx + x - 1];

            if (player == ALICE) {
                // Alice tries to maximize her result
                result = Math.max(result, stones + count(idx + x, piles, Math.max(x, limit), BOB, memo));
            } else {
                // Bob tries to minimize Alice's result
                result = Math.min(result, count(idx + x, piles, Math.max(x, limit), ALICE, memo));
            }
        }

        memo[player][idx][limit] = result;
        return result;
    }
}
