package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/online-stock-span
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class OnlineStockSpan {

    private static class StockSpanner {

        private final Deque<Record> stack;

        public StockSpanner() {
            this.stack = new LinkedList<>();
        }

        public int next(int price) {
            int span = 1;
            while (!stack.isEmpty() && price >= stack.peek().price) {
                span += stack.pop().span;
            }
            stack.push(new Record(price, span));

            return span;
        }

        private record Record(int price, int span) {
        }
    }
}
