package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Description: https://leetcode.com/problems/backspace-string-compare
 * Difficulty: Easy
 */
public class BackspaceStringCompare {

    /**
     * Time complexity: O(n + m)
     * Space complexity: O(1)
     */
    public boolean backspaceCompareViaTwoPointers(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            i = skip(s, i);
            j = skip(t, j);

            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            if ((i >= 0 && j < 0) || (i < 0 && j >= 0)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }

    private int skip(String s, int i) {
        int back = 0;
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                back++;
                i--;
            } else if (back > 0) {
                back--;
                i--;
            } else {
                break;
            }
        }

        return i;
    }

    /**
     * Time complexity: O(n + m)
     * Space complexity: O(n + m)
     */
    public boolean backspaceCompareViaTwoStacks(String s, String t) {
        Deque<Character> stack1 = toStack(s);
        Deque<Character> stack2 = toStack(t);

        return Objects.equals(stack1, stack2);
    }

    private Deque<Character> toStack(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack;
    }
}
