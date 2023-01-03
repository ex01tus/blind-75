package w1;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/valid-anagram
 * Difficulty: Easy
 * Time complexity: O(m + n)
 * Space complexity: O(m + n)
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> firstWord = toCharMap(s);
        Map<Character, Integer> secondWord = toCharMap(t);

        return firstWord.equals(secondWord);
    }

    private Map<Character, Integer> toCharMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, ++count);
            }
        }

        return map;
    }
}
