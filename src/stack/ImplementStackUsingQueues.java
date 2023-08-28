package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/implement-stack-using-queues
 * Difficulty: Easy
 * Time complexity: O(1) for push() and peek(), O(n) for pop()
 * Space complexity: O(n)
 */
public class ImplementStackUsingQueues {

    private static class MyStack {

        private Queue<Integer> main;
        private Queue<Integer> tmp;
        private int top;

        public MyStack() {
            this.main = new LinkedList<>();
            this.tmp = new LinkedList<>();
            this.top = -1;
        }

        public void push(int x) {
            top = x;
            main.offer(x);
        }

        public int pop() {
            while (main.size() > 1) {
                top = main.poll();
                tmp.offer(top);
            }

            Queue<Integer> swap = main;
            main = tmp;
            tmp = swap;

            return tmp.poll();
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return main.isEmpty();
        }
    }
}
