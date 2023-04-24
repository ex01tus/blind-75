package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words
 * Difficulty: Medium
 */
public class LongestPalindromeByConcatenatingTwoLetterWords {

    private static final int ALPHABET_SIZE = 26;

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int longestPalindromeVia2DArray(String[] words) {
        int[][] freqMap = new int[ALPHABET_SIZE][ALPHABET_SIZE];
        int result = 0;

        for (String word : words) {
            int a = word.charAt(0) - 'a';
            int b = word.charAt(1) - 'a';

            if (freqMap[b][a] > 0) {
                result += 4;
                freqMap[b][a]--;
            } else {
                freqMap[a][b]++;
            }
        }

        // look for a symmetrical pair to put in the middle (i.e. "aa")
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (freqMap[i][i] > 0) {
                return result + 2;
            }
        }

        return result;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int longestPalindromeViaMap(String[] words) {
        Map<String, Integer> freqMap = new HashMap<>();

        int pairs = 0;
        int symmetrical = 0;
        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (freqMap.getOrDefault(reversed, 0) > 0) {
                pairs++;
                freqMap.merge(reversed, -1, Integer::sum);
                if (word.charAt(0) == word.charAt(1)) symmetrical--;
            } else {
                freqMap.merge(word, 1, Integer::sum);
                if (word.charAt(0) == word.charAt(1)) symmetrical++;
            }
        }

        return pairs * 4 + (symmetrical > 0 ? 2 : 0);
    }
}
