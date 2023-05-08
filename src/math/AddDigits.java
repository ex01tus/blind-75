package math;

/**
 * Description: https://leetcode.com/problems/add-digits
 * Difficulty: Easy
 */
public class AddDigits {

    /**
     * Time complexity: O(log10 n)
     * Space complexity: O(1)
     */
    public int addDigitsViaLoop(int num) {
        int digitalRoot = 0;
        while (num > 0) {
            digitalRoot += num % 10;
            num = num / 10;

            if (num == 0 && digitalRoot > 9) {
                num = digitalRoot;
                digitalRoot = 0;
            }
        }

        return digitalRoot;
    }

    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public int addDigitsViaFormula(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}
