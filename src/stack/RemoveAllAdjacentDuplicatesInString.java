package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicatesViaStack(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public String removeDuplicatesViaStringBuilder(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
