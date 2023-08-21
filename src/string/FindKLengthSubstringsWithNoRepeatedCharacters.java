package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class FindKLengthSubstringsWithNoRepeatedCharacters {

    public int numKLenSubstrNoRepeatsViaSet(String s, int k) {
        Set<Character> seen = new HashSet<>();

        int substrings = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(s.charAt(right));

            if (right - left + 1 == k) {
                substrings++;
                seen.remove(s.charAt(left));
                left++;
            }
        }

        return substrings;
    }

    public int numKLenSubstrNoRepeatsViaFreqMap(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();

        int substrings = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            freqMap.merge(s.charAt(right), 1, Integer::sum);
            while (freqMap.get(s.charAt(right)) > 1) {
                freqMap.merge(s.charAt(left), -1, Integer::sum);
                left++;
            }

            if (right - left + 1 == k) {
                substrings++;
                freqMap.merge(s.charAt(left), -1, Integer::sum);
                left++;
            }
        }

        return substrings;
    }
}
