package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/minimum-window-substring
 * Difficulty: Hard
 * Time complexity: O(m + n)
 * Space complexity: O(1)
 */
public class MinimumWindowSubstring {

    public String minWindow(String original, String pattern) {
        if (pattern.length() > original.length()) return "";

        Map<Character, Integer> charMap = toCharMap(pattern);
        int charsToFind = charMap.size();

        int minWindow = Integer.MAX_VALUE;
        int from = -1;
        int to = -1;

        int left = 0;
        for (int right = 0; right < original.length(); right++) {
            char rightChar = original.charAt(right);
            if (charMap.containsKey(rightChar)) {
                if (charMap.get(rightChar) == 1) charsToFind--;
                charMap.merge(rightChar, -1, Integer::sum);
            }

            while (charsToFind == 0) {
                int windowSize = right - left + 1;
                if (minWindow > windowSize) {
                    minWindow = windowSize;
                    from = left;
                    to = right;
                }

                char leftChar = original.charAt(left);
                if (charMap.containsKey(leftChar)) {
                    if (charMap.get(leftChar) == 0) charsToFind++;
                    charMap.merge(leftChar, 1, Integer::sum);
                }

                left++;
            }
        }

        return minWindow == Integer.MAX_VALUE
                ? ""
                : original.substring(from, to + 1);
    }

    private Map<Character, Integer> toCharMap(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.merge(c, 1, Integer::sum);
        }

        return charMap;
    }
}
