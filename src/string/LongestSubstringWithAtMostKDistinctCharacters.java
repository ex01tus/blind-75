package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(k)
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();

        int longest = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            freqMap.merge(s.charAt(right), 1, Integer::sum);

            while (freqMap.size() > k) {
                int count = freqMap.merge(s.charAt(left), -1, Integer::sum);
                if (count == 0) freqMap.remove(s.charAt(left));

                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}
