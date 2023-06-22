package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Description: https://leetcode.com/problems/determine-if-two-strings-are-close
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class DetermineIfTwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> freqMap1 = buildFreqMap(word1);
        Map<Character, Integer> freqMap2 = buildFreqMap(word2);

        // both strings should have the same set of characters
        if (!Objects.equals(freqMap1.keySet(), freqMap2.keySet())) return false;

        // both strings should have the same frequencies of any characters
        return Objects.equals(
                freqMap1.values().stream().sorted().toList(), // sort is O(26) -> O(1)
                freqMap2.values().stream().sorted().toList());
    }

    private Map<Character, Integer> buildFreqMap(String word) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.merge(c, 1, Integer::sum);
        }

        return freqMap;
    }
}
