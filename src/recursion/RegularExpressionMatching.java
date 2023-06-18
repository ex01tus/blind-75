package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/regular-expression-matching
 * Difficulty: Hard
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0, new HashMap<>());
    }

    private boolean isMatch(
            String original,
            String pattern,
            int originalPointer,
            int patternPointer,
            Map<String, Boolean> memo) {
        if (patternPointer == pattern.length()) return originalPointer == original.length();

        String key = originalPointer + ":" + patternPointer;
        if (memo.containsKey(key)) return memo.get(key);

        // check if current char matches
        boolean isCurrentMatch = originalPointer < original.length()
                && (pattern.charAt(patternPointer) == original.charAt(originalPointer)
                || pattern.charAt(patternPointer) == '.');

        boolean result;
        if (isStarNext(pattern, patternPointer)) {
            // '*' means 0 or more matches -> we check for zero (skip) or for one (pick)
            boolean skip = isMatch(original, pattern, originalPointer, patternPointer + 2, memo);
            boolean pick = isCurrentMatch
                    && isMatch(original, pattern, originalPointer + 1, patternPointer, memo);
            result = skip || pick;
        } else {
            // move on
            result = isCurrentMatch
                    && isMatch(original, pattern, originalPointer + 1, patternPointer + 1, memo);
        }

        memo.put(key, result);
        return result;
    }

    private static boolean isStarNext(String pattern, int patternPointer) {
        return patternPointer + 1 < pattern.length() && pattern.charAt(patternPointer + 1) == '*';
    }
}
