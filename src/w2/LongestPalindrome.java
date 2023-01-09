package w2;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/longest-palindrome
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> charMap = new HashMap<>();

        int maxLength = 0;
        for (char c : s.toCharArray()) {
            Integer count = charMap.get(c);
            if (count == null) {
                charMap.put(c, 1);
            } else {
                count++;
                if (count % 2 == 0) maxLength += 2;
                charMap.put(c, count);
            }
        }

        if (maxLength < s.length()) {
            maxLength++; // "aca", "abeba", etc.
        }

        return maxLength;
    }
}
