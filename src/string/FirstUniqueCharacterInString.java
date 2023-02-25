package string;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/first-unique-character-in-a-string
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        int[] charMap = buildCharMap(s);
        return findFirstUniqueCharacter(s, charMap);
    }

    private int[] buildCharMap(String s) {
        int[] charMap = new int[26];
        for (int c : s.toCharArray()) {
            charMap[c - 'a']++;
        }

        return charMap;
    }

    private int findFirstUniqueCharacter(String s, int[] charMap) {
        for (int i = 0; i < s.length(); i++) {
            if (charMap[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }

    public int firstUniqCharForDataStreamScenario(String s) {
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!seen.contains(current)) {
                map.put(current, i);
                seen.add(current);
            } else {
                map.remove(current);
            }
        }

        return map.size() == 0
                ? -1
                : map.entrySet().iterator().next().getValue(); // first added value, that was not removed
    }
}
