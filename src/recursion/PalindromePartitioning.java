package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/palindrome-partitioning
 * Difficulty: Medium
 * Time complexity: O(2^n)
 * Space complexity: O(2^n)
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (!isPalindrome(s, start, end)) continue;

            currentPartition.add(s.substring(start, end + 1));
            backtrack(s, end + 1, currentPartition, result);
            currentPartition.remove(currentPartition.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
