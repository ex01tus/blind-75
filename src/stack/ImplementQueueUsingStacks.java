package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/implement-queue-using-stacks
 * Difficulty: Easy
 * Time complexity: O(1) for push(), O(n) for pop() and peek()
 * Space complexity: O(n)
 */
public class ImplementQueueUsingStacks {

    private static class MyQueue {

        private final Deque<Integer> firstStack;
        private final Deque<Integer> secondStack;

        public MyQueue() {
            firstStack = new LinkedList<>();
            secondStack = new LinkedList<>();
        }

        public void push(int x) {
            firstStack.push(x);
        }

        public int pop() {
            if (secondStack.isEmpty()) {
                transferFromFirstToSecond();
            }

            return secondStack.pop();
        }

        public int peek() {
            if (secondStack.isEmpty()) {
                transferFromFirstToSecond();
            }

            return secondStack.peek();
        }

        public boolean empty() {
            return firstStack.isEmpty() && secondStack.isEmpty();
        }

        private void transferFromFirstToSecond() {
            while (!firstStack.isEmpty()) {
                int v = firstStack.pop();
                secondStack.push(v);
            }
        }
    }
}
