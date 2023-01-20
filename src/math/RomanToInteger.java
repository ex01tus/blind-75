package math;

import java.util.Map;

/**
 * Description: https://leetcode.com/problems/roman-to-integer
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);

        int result = 0;
        int prev = 0;

        for (char c : s.toCharArray()) {
            int current = map.get(c);

            if (current > prev) {
                result -= prev;
            } else {
                result += prev;
            }

            prev = current;
        }

        result += prev;
        return result;
    }
}
