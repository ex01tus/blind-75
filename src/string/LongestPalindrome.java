package string;

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
        int maxLength = 0;

        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = charMap.merge(c, 1, Integer::sum);
            if (count % 2 == 0) maxLength += 2;
        }

        if (maxLength < s.length()) {
            maxLength++; // "aca", "abeba", etc.
        }

        return maxLength;
    }
}
