package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/evaluate-reverse-polish-notation
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();

        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int result = eval(stack.pop(), stack.pop(), token);
                stack.push(result);
            } else {
                int num = Integer.parseInt(token);
                stack.push(num);
            }
        }

        return stack.pop();
    }

    private int eval(int b, int a, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException();
        };
    }
}
