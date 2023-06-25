package math;

/**
 * Description: https://leetcode.com/problems/factorial-trailing-zeroes
 * Difficulty: Medium
 * Time complexity: O(log n)
 * Space complexity: O(1)
 */
public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int zeroes = 0;
        while (n > 0) {
            // every 5 results in a zero because there will always be a corresponding 2
            // -> we need to count the number of factors of 5
            // e.g. 1 * 2 * 3 * (4) * [5] * 6 * 7 * 9 * 9 * [10] * 11 * 12 * 13 * 14 * [15] * (16) * 17 * 18 * 19 * [20] * 21 * 22 * 23 * 24 * [25]
            //                4 * 16 = 2 * 2 * 2 * 2 * 2 * 2
            // 5 * 10 * 15 * 20 * 25 = 5 * 5 * 5 * 5 * 5 * 5 * (2 * 3 * 4)
            // -> 25! = X000000
            n /= 5;
            zeroes += n;
        }

        return zeroes;
    }
}
