package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/distinct-subsequences
 * Difficulty: Hard
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        return count(s, t, 0, 0, new HashMap<>());
    }

    private int count(
            String original,
            String target,
            int originalPointer,
            int targetPointer,
            Map<String, Integer> memo) {
        if (originalPointer == original.length()
                || targetPointer == target.length()
                || original.length() - originalPointer < target.length() - targetPointer) {
            return targetPointer == target.length() ? 1 : 0;
        }

        String key = originalPointer + ":" + targetPointer;
        if (memo.containsKey(key)) return memo.get(key);

        // skip and move on
        int count = count(original, target, originalPointer + 1, targetPointer, memo);

        // pick and move on
        if (original.charAt(originalPointer) == target.charAt(targetPointer)) {
            count += count(original, target, originalPointer + 1, targetPointer + 1, memo);
        }

        memo.put(key, count);
        return count;
    }
}
