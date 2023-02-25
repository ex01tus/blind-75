package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/longest-valid-parentheses
 * Difficulty: Hard
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        // stack always contains invalid parentheses combination
        Deque<Integer> stack = new LinkedList<>();

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // valid combination was found
            if (current == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();

                int prevInvalid = stack.isEmpty() ? -1 : stack.peek();
                int length = i - prevInvalid; // distance between current index and previous invalid one
                maxLength = Math.max(maxLength, length);
            } else {
                stack.push(i);
            }
        }

        return maxLength;
    }
}
