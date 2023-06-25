package math;

/**
 * Description: https://leetcode.com/problems/integer-to-roman
 * Difficulty: Medium
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class IntegerToRoman {

    private static final int[] VALUES =
            new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS =
            new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRomanViaLoop(int num) {
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < VALUES.length; i++) {
            while (VALUES[i] <= num) {
                roman.append(SYMBOLS[i]);
                num -= VALUES[i];
            }
        }

        return roman.toString();
    }

    private static final String[] THOUSANDS = new String[]{"", "M", "MM", "MMM"};
    private static final String[] HUNDREDS = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] TENS = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ONES = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRomanViaMod(int num) {
        return THOUSANDS[num / 1000]
                + HUNDREDS[(num % 1000) / 100]
                + TENS[(num % 100) / 10]
                + ONES[num % 10];
    }
}
