package binary;

/**
 * Description: https://leetcode.com/problems/counting-bits
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            /*
            1. Unit digit of even numbers is always '0': 2 -> 10, 4 -> 100, 6 -> 110, 8 -> 1000
            2. Thus number of '1's for N and N / 2 is equal: 6 -> 110 && 3 -> 11, 10 -> 1010 && 5 -> 101
            3. For odd numbers one more '1' is added: 10 -> 1010 && 11 -> 1011, 2 -> 10 && 3 -> 11
             */
            dp[i] = dp[i / 2] + (i % 2);
        }

        return dp;
    }
}
