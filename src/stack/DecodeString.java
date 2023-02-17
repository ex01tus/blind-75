package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/decode-string
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class DecodeString {

    public String decodeString(String s) {
        Deque<Integer> numbersStack = new LinkedList<>();
        int currentNumber = 0;

        Deque<StringBuilder> valuesStack = new LinkedList<>();
        valuesStack.push(new StringBuilder());

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNumber = 10 * currentNumber + Character.getNumericValue(c);
            } else if (c == '[') {
                numbersStack.push(currentNumber);
                currentNumber = 0;

                valuesStack.push(new StringBuilder());
            } else if (c == ']') {
                int times = numbersStack.pop();
                StringBuilder previousValue = valuesStack.pop();

                StringBuilder newValue = new StringBuilder();
                for (int i = 0; i < times; i++) {
                    newValue.append(previousValue);
                }

                valuesStack.peek().append(newValue);
            } else {
                valuesStack.peek().append(c);
            }
        }

        return valuesStack.pop().toString();
    }
}
