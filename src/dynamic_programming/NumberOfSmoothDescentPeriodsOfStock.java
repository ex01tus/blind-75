package dynamic_programming;

/**
 * Description: https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class NumberOfSmoothDescentPeriodsOfStock {

    public long getDescentPeriods(int[] prices) {
        int smoothPeriodsEndingAtCurrentIndex = 0;
        long total = 0;

        int prev = 0;
        for (int price : prices) {
            smoothPeriodsEndingAtCurrentIndex = prev - price == 1 ? ++smoothPeriodsEndingAtCurrentIndex : 1;
            total += smoothPeriodsEndingAtCurrentIndex;
            prev = price;
        }

        return total;
    }
}
