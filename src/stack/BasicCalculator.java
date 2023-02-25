package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/basic-calculator
 * Difficulty: Hard
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BasicCalculator {

    public int calculate(String s) {
        int sign = 1;
        int currentValue = 0;
        int result = 0;

        Deque<Integer> signStack = new LinkedList<>();
        Deque<Integer> resultStack = new LinkedList<>(); // can use a single stack to store both signs and results

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentValue = currentValue * 10 + Character.getNumericValue(currentChar);
            } else if (i == s.length() - 1
                    || (!Character.isDigit(currentChar) && currentChar != ' ')) {
                result += currentValue * sign;
                currentValue = 0;

                switch (currentChar) {
                    case '+' -> sign = 1;
                    case '-' -> sign = -1;
                    case '(' -> {
                        resultStack.push(result);
                        result = 0;
                        signStack.push(sign);
                        sign = 1;
                    }
                    case ')' -> result = signStack.pop() * result + resultStack.pop();
                }
            }
        }

        return result;
    }
}
