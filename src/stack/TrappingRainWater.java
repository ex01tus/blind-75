package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/trapping-rain-water
 * Difficulty: Hard
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class TrappingRainWater {

    public int trap(int[] heights) {
        Deque<Rectangle> decreasingStack = new LinkedList<>();

        int totalAmount = 0;
        for (int current = 0; current < heights.length; current++) {
            int start = current;
            while (!decreasingStack.isEmpty()
                    && heights[current] >= decreasingStack.peek().height) {
                // 1) 4 2 0 [3]
                // 2) pop(0): totalAmount += 1 * (min(2, 3) - 0)
                // 3) pop(2): totalAmount += 2 * (min(4, 3) - 2)
                // 4) 4 3 []
                Rectangle prev = decreasingStack.pop();
                if (decreasingStack.isEmpty()) break;

                int width = current - prev.start;
                int boundaryHeight = Math.min(decreasingStack.peek().height, heights[current]);
                int waterHeight = boundaryHeight - prev.height;
                totalAmount += width * waterHeight;

                start = prev.start;
            }

            decreasingStack.push(new Rectangle(start, heights[current]));
        }

        return totalAmount;
    }

    private static class Rectangle {
        int start;
        int height;

        public Rectangle(int start, int height) {
            this.start = start;
            this.height = height;
        }
    }
}
