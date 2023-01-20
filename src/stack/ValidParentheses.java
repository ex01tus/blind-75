package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/valid-parentheses
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (isOpened(current)) {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char prev = stack.pop();
                if (!isValidPair(prev, current)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpened(char p) {
        return p == '(' || p == '[' || p == '{';
    }

    private boolean isValidPair(char opened, char closed) {
        return (opened == '(' && closed == ')')
                || (opened == '[' && closed == ']')
                || (opened == '{' && closed == '}');
    }
}
