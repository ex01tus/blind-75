package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/remove-k-digits
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class RemoveKDigits {

    public String removeKdigitsViaStringBuilder(String num, int k) {
        StringBuilder smallest = new StringBuilder();
        for (char current : num.toCharArray()) {
            while (!smallest.isEmpty() && k > 0 && smallest.charAt(smallest.length() - 1) > current) {
                smallest.deleteCharAt(smallest.length() - 1);
                k--;
            }

            // skip trailing zeroes
            if (smallest.isEmpty() && current == '0') continue;
            smallest.append(current);
        }

        // still have digits to remove (e.g. 12345) -> remove from the end of the number
        while (!smallest.isEmpty() && k > 0) {
            smallest.deleteCharAt(smallest.length() - 1);
            k--;
        }

        return smallest.isEmpty() ? "0" : smallest.toString();
    }

    public String removeKdigitsViaMonotonicStack(String num, int k) {
        Deque<Character> stack = new LinkedList<>();
        for (char current : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > current) {
                stack.pop();
                k--;
            }

            stack.push(current);
        }

        // still have digits to remove (e.g. 12345) -> remove from the end of the number
        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        StringBuilder smallest = new StringBuilder();
        while (!stack.isEmpty()) {
            smallest.append(stack.pop());
        }

        // skip trailing zeroes
        while (smallest.length() > 0 && smallest.charAt(smallest.length() - 1) == '0') {
            smallest.deleteCharAt(smallest.length() - 1);
        }

        return smallest.isEmpty() ? "0" : smallest.reverse().toString();
    }
}
