package recursion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/word-break
 * Difficulty: Medium
 * Time complexity: O(n^3)
 * Space complexity: O(n)
 */
public class WordBreak {

    public boolean wordBreakViaMemoization(String s, List<String> wordDict) {
        return backtrack(s, wordDict, new HashSet<>());
    }

    private boolean backtrack(String s, List<String> wordDict, Set<String> failedChecks) {
        if (s.isEmpty()) return true;
        if (failedChecks.contains(s)) return false;

        for (String word : wordDict) {
            boolean canBeSegmented = s.startsWith(word)
                    && backtrack(s.substring(word.length()), wordDict, failedChecks);

            if (canBeSegmented) {
                return true;
            } else {
                failedChecks.add(s);
            }
        }

        failedChecks.add(s);
        return false;
    }

    public boolean wordBreakViaDP(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int right = 1; right <= s.length(); right++) {
            for (int left = 0; left < right; left++) {
                if (dp[left] && wordDict.contains(s.substring(left, right))) {
                    dp[right] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
