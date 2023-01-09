package w3;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/longest-substring-without-repeating-characters
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int max = 0;

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (charMap.containsKey(c)) {
                // only reposition left pointer if the new value is greater, than the current one
                left = Math.max(charMap.get(c) + 1, left);
            }

            charMap.put(c, right);

            int length = right - left + 1;
            max = Math.max(length, max);

            right++;
        }

        return max;
    }
}
