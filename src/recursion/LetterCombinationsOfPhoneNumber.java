package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Description:https://leetcode.com/problems/letter-combinations-of-a-phone-number
 * Difficulty: Medium
 * Time complexity: O(4^n)
 * Space complexity: O(4^n)
 */
public class LetterCombinationsOfPhoneNumber {

    private static final Map<Character, String> MAP = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return List.of();

        List<String> result = new ArrayList<>();
        backtrack(digits, "", 0, result);
        return result;
    }

    private void backtrack(String digits, String prefix, int current, List<String> result) {
        if (prefix.length() == digits.length()) {
            result.add(prefix);
            return;
        }

        String letters = MAP.get(digits.charAt(current));
        for (char c : letters.toCharArray()) {
            backtrack(digits, prefix + c, current + 1, result);
        }
    }
}
