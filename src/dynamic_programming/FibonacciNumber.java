package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/fibonacci-number
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class FibonacciNumber {

    public int fib(int n) {
        if (n <= 1) return n;

        int leftPrev = 0;
        int rightPrev = 1;

        for (int i = 2; i <= n; i++) {
            int sum = leftPrev + rightPrev;
            leftPrev = rightPrev;
            rightPrev = sum;
        }

        return rightPrev;
    }
}
