package string;

/**
 * Description: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
 * Difficulty: Medium
 */
public class FindTheIndexOfTheFirstOccurrenceInString {

    /**
     * Time complexity: O(n * m)
     * Space complexity: O(1)
     */
    public int strStrViaSlidingWindow(String original, String pattern) {
        if (pattern.length() > original.length()) return -1;

        for (int windowStart = 0; windowStart < original.length() - pattern.length() + 1; windowStart++) {
            for (int shift = 0; shift < pattern.length(); shift++) {
                if (pattern.charAt(shift) != original.charAt(windowStart + shift)) {
                    break;
                }

                if (shift == pattern.length() - 1) {
                    return windowStart;
                }
            }
        }

        return -1;
    }

    /**
     * Time complexity: O(n + m)
     * Space complexity: O(n + m)
     */
    public int strStrViaKnuthMorrisPrattAlgo(String original, String pattern) {
        return prefixFunction(pattern + "#" + original, pattern.length());
    }

    private int prefixFunction(String line, int patternLength) {
        char[] arr = line.toCharArray();
        int[] function = new int[line.length()];

        for (int i = 1; i < arr.length; i++) {
            int k = function[i - 1];

            while (k != 0 && arr[i] != arr[k]) {
                k = function[k - 1];
            }

            function[i] = arr[i] == arr[k] ? k + 1 : 0;
            if (function[i] == patternLength) {
                return i - 2 * patternLength;
            }
        }

        return -1;
    }
}
