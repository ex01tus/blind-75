package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/generate-parentheses
 * Difficulty: Medium
 * Time complexity: O(2^2n)
 * Space complexity: O(n)
 */
public class GenerateParentheses {

    public List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", n, 0, 0, result);

        return result;
    }

    private void backtrack(String prefix, int max, int opened, int closed, List<String> result) {
        if (prefix.length() == max * 2) {
            result.add(prefix);
            return;
        }

        if (opened < max) {
            backtrack(prefix + "(", max, opened + 1, closed, result);
        }

        if (opened > closed) {
            backtrack(prefix + ")", max, opened, closed + 1, result);
        }
    }
}
