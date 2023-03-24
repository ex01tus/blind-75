package string;

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
            int count = charMap.getOrDefault(c, 0);
            if (count == 0) return false;
            
            charMap.merge(c, -1, Integer::sum);
        }

        return true;
    }

    private Map<Character, Integer> toCharMap(String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        return map;
    }
}
