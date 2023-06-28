package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/substring-with-concatenation-of-all-words
 * Difficulty: Hard
 * Time complexity: O(w + (s - w * wl) * (w + w * wl))
 * Space complexity: O(w + wl)
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        Map<String, Integer> freqMap = buildFreqMap(words);

        List<Integer> result = new ArrayList<>();
        for (int start = 0; start <= s.length() - words.length * wordLength; start++) {
            if (isMatch(s, words, wordLength, freqMap, start)) {
                result.add(start);
            }
        }

        return result;
    }

    private boolean isMatch(
            String s,
            String[] words,
            int wordLength,
            Map<String, Integer> freqMap,
            int start) {
        Map<String, Integer> freqMapCopy = new HashMap<>(freqMap);
        int found = 0;

        for (int i = 0; i < words.length; i++) {
            String word = s.substring(start + i * wordLength, start + i * wordLength + wordLength);
            int count = freqMapCopy.getOrDefault(word, 0);
            if (count <= 0) return false;

            freqMapCopy.merge(word, -1, Integer::sum);
            found += 1;

            if (found == words.length) return true;
        }

        return false;
    }

    private Map<String, Integer> buildFreqMap(String[] words) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.merge(word, 1, Integer::sum);
        }

        return freqMap;
    }
}
