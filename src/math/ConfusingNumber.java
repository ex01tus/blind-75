package math;

import java.util.Map;

/**
 * Description: https://leetcode.com/problems/confusing-number
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ConfusingNumber {

    private static final Map<Integer, Integer> MAPPING = Map.of(
            0, 0,
            1, 1,
            6, 9,
            8, 8,
            9, 6);

    public boolean confusingNumber(int n) {
        int original = n;
        int rotated = 0;
        while (n != 0) {
            int digit = n % 10;
            if (!MAPPING.containsKey(digit)) return false;

            rotated = rotated * 10 + MAPPING.get(digit);
            n /= 10;
        }

        return original != rotated;
    }
}
