package math;

/**
 * Description: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range
 * Difficulty: Easy
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class CountOddNumbersInIntervalRange {

    public int countOdds(int low, int high) {
        int count = (high - low) / 2;
        if (low % 2 != 0 || high % 2 != 0) {
            count++;
        }

        return count;
    }
}
