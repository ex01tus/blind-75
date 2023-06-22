package binary;

/**
 * Description: https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MinimumFlipsToMakeAOrBEqualToC {

    public int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a != 0 || b != 0 || c != 0) {
            int aBit = (a & 1);
            int bBit = (b & 1);
            int cBit = (c & 1);

            if ((aBit | bBit) != cBit) {
                if (cBit == 1) {
                    flips += 1;
                } else {
                    flips += (aBit == 1) ? 1 : 0;
                    flips += (bBit == 1) ? 1 : 0;
                }
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }
}
