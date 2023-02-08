package string;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/permutation-in-string
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class PermutationInString {

    public boolean checkInclusion(String permutation, String line) {
        if (permutation.length() > line.length()) return false;

        int[] permutationFrequencyMap = new int[26];
        int[] windowFrequencyMap = new int[26];

        int left = 0;
        int right = 0;

        while (right < permutation.length()) {
            permutationFrequencyMap[permutation.charAt(right) - 'a']++;
            windowFrequencyMap[line.charAt(right) - 'a']++;
            right++;
        }

        if (Arrays.equals(permutationFrequencyMap, windowFrequencyMap)) return true;

        while (right < line.length()) {
            windowFrequencyMap[line.charAt(right) - 'a']++;
            windowFrequencyMap[line.charAt(left) - 'a']--;

            if (Arrays.equals(permutationFrequencyMap, windowFrequencyMap)) return true;

            left++;
            right++;
        }

        return false;
    }
}
