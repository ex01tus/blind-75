package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/basic-calculator-ii
 * Difficulty: Medium
 */
public class BasicCalculator2 {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int calculateWithStack(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int currentValue = 0;
        char prevOperator = '+';

        for (char current : s.toCharArray()) {
            if (current == ' ') continue;

            if (Character.isDigit(current)) {
                currentValue = currentValue * 10 + Character.getNumericValue(current);
            } else {
                eval(stack, currentValue, prevOperator);
                currentValue = 0;
                prevOperator = current;
            }
        }

        eval(stack, currentValue, prevOperator); // for the last integer in the expression

        return getResult(stack);
    }

    private void eval(Deque<Integer> stack, int currentValue, char prevOperator) {
        switch (prevOperator) {
            case '+' -> stack.push(currentValue);
            case '-' -> stack.push(-currentValue);
            case '*' -> stack.push(stack.pop() * currentValue);
            case '/' -> stack.push(stack.pop() / currentValue);
            default -> throw new IllegalArgumentException();
        }
    }

    private int getResult(Deque<Integer> stack) {
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int calculateWithoutStack(String s) {
        int currentValue = 0;
        int prevValue = 0;
        char prevOperator = '+';

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentValue = currentValue * 10 + Character.getNumericValue(currentChar);
            }

            if ((!Character.isDigit(currentChar) && currentChar != ' ')
                    || i == s.length() - 1) {
                switch (prevOperator) {
                    case '+' -> {
                        result += prevValue;                          // 3 + 2 (*) 4 -> result += 3; prevValue = 2
                        prevValue = currentValue;
                    }
                    case '-' -> {                                     // 3 - 2 (*) 4 -> result += 3; prevValue = -2
                        result += prevValue;
                        prevValue = -currentValue;
                    }
                    case '*' -> prevValue = prevValue * currentValue; // 3 - 2 * (4) -> prevValue = -8
                    case '/' -> prevValue = prevValue / currentValue; // 3 - 2 / (4) -> prevValue = 0
                }

                currentValue = 0;
                prevOperator = currentChar;
            }
        }

        return result + prevValue;
    }
}
