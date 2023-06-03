package binary_search;

/**
 * Description: https://leetcode.com/problems/guess-number-higher-or-lower
 * Difficulty: Easy
 * Time complexity: O(log n)
 * Space complexity: O(1)
 */
public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int guess = guess(mid);

            if (guess > 0) {
                left = mid + 1;
            } else if (guess < 0) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    // API call
    private int guess(int num) {
        return 0;
    }
}
