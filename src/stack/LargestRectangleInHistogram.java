package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/largest-rectangle-in-histogram
 * Difficulty: Hard
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LargestRectangleInHistogram {

    public int largestRectangleAreaWithHelperClass(int[] heights) {
        Deque<Rectangle> increasingStack = new LinkedList<>();
        int maxArea = 0;

        for (int current = 0; current < heights.length; current++) {
            int start = current;
            while (!increasingStack.isEmpty()
                    && increasingStack.peek().height >= heights[current]) {
                // 1) 1 2 3 [1]: 3 can not be extended further to the right
                // 2) compute the area of all the previous rectangles with lesser or equal height: 3*1, 2*2, 1*3
                // 3) save last popped rectangle start as current rectangle start, because it can be extended to the left
                Rectangle prev = increasingStack.pop();
                int width = current - prev.start;

                maxArea = Math.max(maxArea, prev.height * width);
                start = prev.start;
            }

            increasingStack.push(new Rectangle(start, heights[current]));
        }

        while (!increasingStack.isEmpty()) {
            Rectangle prevRectangle = increasingStack.pop();
            int width = heights.length - prevRectangle.start;

            maxArea = Math.max(maxArea, prevRectangle.height * width);
        }

        return maxArea;
    }

    private static class Rectangle {
        int start;
        int height;

        public Rectangle(int start, int height) {
            this.start = start;
            this.height = height;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> nonDecreasingStack = new LinkedList<>();
        int maxArea = 0;

        for (int rectangleEnd = 0; rectangleEnd < heights.length; rectangleEnd++) {
            while (!nonDecreasingStack.isEmpty()
                    && heights[rectangleEnd] < heights[nonDecreasingStack.peek()]) { // rectangle can not be extended any further to the right
                // compute area of all possible rectangles with lesser height
                int rectangleArea = computeRectangleArea(heights, nonDecreasingStack, rectangleEnd);
                maxArea = Math.max(maxArea, rectangleArea);
            }

            nonDecreasingStack.push(rectangleEnd);
        }

        // now all the rectangles left in the stack are in non-decreasing order
        while (!nonDecreasingStack.isEmpty()) {
            int rectangleArea = computeRectangleArea(heights, nonDecreasingStack, heights.length);
            maxArea = Math.max(maxArea, rectangleArea);
        }

        return maxArea;
    }

    private int computeRectangleArea(
            int[] heights,
            Deque<Integer> stack,
            int rectangleEnd) {
        int height = heights[stack.pop()];
        int rectangleStart = stack.isEmpty() ? 0 : stack.peek() + 1;
        int width = rectangleEnd - rectangleStart;

        return height * width;
    }
}
