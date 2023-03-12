package math;

/**
 * Description: https://leetcode.com/problems/powx-n
 * Difficulty: Medium
 */
public class PowXN {

    /**
     * Time complexity: O(log n)
     * Space complexity: O(log n)
     */
    public double myPowOptimalApproach(double x, int n) {
        if (x == 0 || x == 1) return x;
        return n >= 0
                ? pow(x, n)
                : 1 / pow(x, -n);
    }

    private double pow(double x, int n) {
        if (n == 0) return 1;
        // result = pow(x, n / 2);
        // result *= result;
        return n % 2 == 0
                ? pow(x * x, n / 2)      // 2^6 = (2^2)^3 = 4^3 = (4^2)^1 * 4 = 16^1 * 4 = 64
                : x * pow(x * x, n / 2); // 2^7 = (2^2)^3 * 2 = 4^3 * 2 = (4^2)^1 * 4 * 2 = 16^1 * 4 * 2 = 128
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public double myPowNaiveApproach(double x, int n) {
        double result = 1;

        for (int i = 0; i < Math.abs(n); i++) {
            result *= x;
        }

        return n >= 0
                ? result :
                1 / result;
    }
}
