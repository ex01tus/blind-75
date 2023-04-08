package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/letter-case-permutation
 * Difficulty: Medium
 * Time complexity: O(2^n)
 * Space complexity: O(2^n)
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        List<String> permutations = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), permutations);
        return permutations;
    }

    private void backtrack(String s, int index, StringBuilder currentPermutation, List<String> permutations) {
        if (index == s.length()) {
            permutations.add(currentPermutation.toString());
            return;
        }

        char current = s.charAt(index);

        if (Character.isDigit(current)) {
            currentPermutation.append(current);
            backtrack(s, index + 1, currentPermutation, permutations);
            currentPermutation.deleteCharAt(currentPermutation.length() - 1);
        } else {
            currentPermutation.append(Character.toLowerCase(current));
            backtrack(s, index + 1, currentPermutation, permutations);
            currentPermutation.deleteCharAt(currentPermutation.length() - 1);

            currentPermutation.append(Character.toUpperCase(current));
            backtrack(s, index + 1, currentPermutation, permutations);
            currentPermutation.deleteCharAt(currentPermutation.length() - 1);
        }
    }
}
