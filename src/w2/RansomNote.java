package w2;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/ransom-note
 * Difficulty: Easy
 * Time complexity: O(n + m)
 * Space complexity: O(1)
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charMap = toCharMap(magazine);

        for (char c : ransomNote.toCharArray()) {
            Integer count = charMap.get(c);

            if (count == null || count == 0) {
                return false;
            } else {
                charMap.put(c, --count);
            }
        }

        return true;
    }

    private Map<Character, Integer> toCharMap(String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()) {
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
