package stack;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        Set<Integer> indicesToRemove = findIndicesToRemove(s);
        return constructValidString(s, indicesToRemove);
    }

    private Set<Integer> findIndicesToRemove(String s) {
        Deque<Integer> stack = new LinkedList<>();
        Set<Integer> indicesToRemove = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                stack.push(i);
            } else if (current == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    indicesToRemove.add(i);
                }
            }
        }

        while (!stack.isEmpty()) {
            indicesToRemove.add(stack.pop());
        }

        return indicesToRemove;
    }

    private String constructValidString(String s, Set<Integer> indicesToRemove) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indicesToRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
