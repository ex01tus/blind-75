package string;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/diet-plan-performance
 * Difficulty: Easy
 * Time complexity: O(m + n)
 * Space complexity: O(n)
 */
public class FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {
        int[] freqMap = buildFreqMap(chars);

        int sum = 0;
        for (String word : words) {
            if (isGood(word, freqMap)) sum += word.length();
        }

        return sum;
    }

    private int[] buildFreqMap(String chars) {
        int[] freqMap = new int[26];
        for (char c : chars.toCharArray()) {
            freqMap[c - 'a']++;
        }

        return freqMap;
    }

    private boolean isGood(String word, int[] freqMap) {
        int[] tmp = Arrays.copyOf(freqMap, freqMap.length); // not to mutate original freqMap
        for (char c : word.toCharArray()) {
            if (tmp[c - 'a']-- == 0) return false;
        }

        return true;
    }
}
