package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/longest-repeating-character-replacement
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int mostFrequentCharFrequency = 0;
        int maxLength = 0;

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            int currentCharFrequency = frequencyMap.merge(s.charAt(right), 1, Integer::sum);
            mostFrequentCharFrequency = Math.max(mostFrequentCharFrequency, currentCharFrequency);

            int charsToReplace = right - left + 1 - mostFrequentCharFrequency;
            if (charsToReplace > k) {
                frequencyMap.merge(s.charAt(left), -1, Integer::sum);
                left++;
            }

            int length = right - left + 1;
            maxLength = Math.max(maxLength, length);

            right++;
        }

        return maxLength;
    }
}
