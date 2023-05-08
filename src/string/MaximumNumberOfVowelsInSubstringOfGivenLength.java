package string;

import java.util.Set;

/**
 * Description: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaximumNumberOfVowelsInSubstringOfGivenLength {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int vowels = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (VOWELS.contains(s.charAt(i))) vowels++;
            if (i > k - 1 && VOWELS.contains(s.charAt(i - k))) vowels--;

            max = Math.max(max, vowels);
        }

        return max;
    }
}
