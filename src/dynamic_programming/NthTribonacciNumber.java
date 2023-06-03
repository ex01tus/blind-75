package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/n-th-tribonacci-number
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class NthTribonacciNumber {

    public int tribonacci(int n) {
        if (n <= 1) return n;
        if (n == 2) return 1;

        int prev1 = 0;
        int prev2 = 1;
        int prev3 = 1;

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2 + prev3;
            prev1 = prev2;
            prev2 = prev3;
            prev3 = current;
        }

        return prev3;
    }
}
