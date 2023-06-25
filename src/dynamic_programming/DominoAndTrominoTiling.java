package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/domino-and-tromino-tiling
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class DominoAndTrominoTiling {

    // since the answer may be too large, return it modulo 10^9 + 7
    private static final int MOD = 1_000_000_007;

    public int numTilings(int n) {
        if (n <= 2) return n;

        // number of ways to fully cover a 2xN board
        long[] fullCoverage = new long[n + 1];
        fullCoverage[1] = 1L;
        fullCoverage[2] = 2L;

        // number of ways to partially cover (one cell not being covered) a 2xN board
        long[] partialCoverage = new long[n + 1];
        partialCoverage[2] = 1L;

        for (int i = 3; i <= n; i++) {
            fullCoverage[i] = (fullCoverage[i - 1] + fullCoverage[i - 2] + 2 * partialCoverage[i - 1]) % MOD;
            partialCoverage[i] = (partialCoverage[i - 1] + fullCoverage[i - 2]) % MOD;
        }

        return (int) fullCoverage[n];
    }
}
