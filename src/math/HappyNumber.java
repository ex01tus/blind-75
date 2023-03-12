package math;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/happy-number
 * Difficulty: Easy
 */
public class HappyNumber {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public boolean isHappyViaSet(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            if (!seen.add(n)) return false;
            n = sumOfSquares(n);
        }

        return true;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean isHappyViaLinkedListCycleDetection(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));

            if (fast == 1) return true;
        } while (slow != fast);

        // [17] -> 50 -> 25 -> 29 -> 85 -> 89 -> 145 -> 41 -> [17]
        return false;
    }

    private int sumOfSquares(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }

        return sum;
    }
}
