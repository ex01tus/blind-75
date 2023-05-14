package string;

/**
 * Description: https://leetcode.com/problems/repeated-substring-pattern
 * Difficulty: Easy
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPatternViaBruteForce(String s) {
        for (int patternLength = s.length() / 2; patternLength > 0; patternLength--) {
            if (s.length() % patternLength != 0) continue;

            int times = s.length() / patternLength;
            String pattern = s.substring(0, patternLength);
            int repeated = 0;
            while (repeated < times) {
                int left = repeated * patternLength;
                int right = left + patternLength;
                if (!pattern.equals(s.substring(left, right))) break;

                repeated++;
            }

            if (repeated == times) return true;
        }

        return false;
    }

    public boolean repeatedSubstringPatternViaTrick(String s) {
        // "abcabc" contains a repeating substring
        // -> we can shift and wrap around the string N times to get the original one
        // abcabc -> bcabca -> cabcab -> abcabc
        // -> instead we can check if (s + s).contains(s)
        // but we don't want to match the first or the second half
        // -> we remove the first char of the first half and the last char of the second half
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }
}
