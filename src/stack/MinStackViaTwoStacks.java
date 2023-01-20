package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

/**
 * Description: https://leetcode.com/problems/min-stack
 * Difficulty: Medium
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
class MinStackViaTwoStacks {

    private final Deque<Integer> minStack;
    private final Deque<Integer> valueStack;
    private int min = Integer.MAX_VALUE;

    public MinStackViaTwoStacks() {
        minStack = new LinkedList<>();
        valueStack = new LinkedList<>();
    }

    public void push(int val) {
        valueStack.push(val);
        if (val <= min) {
            minStack.push(val);
            min = val;
        }
    }

    public void pop() {
        int val = valueStack.pop();

        if (val == min) {
            minStack.pop();
            min = Optional.ofNullable(minStack.peek()).orElse(Integer.MAX_VALUE);
        }
    }

    public int top() {
        return valueStack.peek();
    }

    public int getMin() {
        return min;
    }
}