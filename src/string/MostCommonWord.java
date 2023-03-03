package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/most-common-word
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> freqMap = buildFrequencyMap(paragraph, banned);
        return findMostFrequentWord(freqMap);
    }

    private String findMostFrequentWord(Map<String, Integer> freqMap) {
        String mostFreqWord = "";
        int maxFreq = 0;
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostFreqWord = entry.getKey();
            }
        }

        return mostFreqWord;
    }

    private Map<String, Integer> buildFrequencyMap(String paragraph, String[] banned) {
        String[] words = paragraph.split("[!?',;. ]+");

        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.merge(word.toLowerCase(), 1, Integer::sum);
        }

        for (String ban : banned) {
            freqMap.remove(ban);
        }

        return freqMap;
    }
}
