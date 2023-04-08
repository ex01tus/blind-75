package stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/next-greater-element-ii
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class NextGreaterElement2 {

    public int[] nextGreaterElementsWithSingleLoop(int[] nums) {
        Deque<Integer> decreasingIndexStack = new LinkedList<>();

        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < 2 * nums.length; i++) {
            int j = i % nums.length;
            while (!decreasingIndexStack.isEmpty() && nums[j] > nums[decreasingIndexStack.peek()]) {
                result[decreasingIndexStack.pop()] = nums[j];
            }

            // no need to push elements during the second pass
            if (i < nums.length) decreasingIndexStack.push(j);
        }

        return result;
    }

    public int[] nextGreaterElementsWithTreeLoops(int[] nums) {
        Deque<Integer> decreasingIndexStack = new LinkedList<>();

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!decreasingIndexStack.isEmpty() && nums[i] > nums[decreasingIndexStack.peek()]) {
                result[decreasingIndexStack.pop()] = nums[i];
            }

            decreasingIndexStack.push(i);
        }

        for (int i = 0; i < nums.length; i++) {
            while (!decreasingIndexStack.isEmpty() && nums[i] > nums[decreasingIndexStack.peek()]) {
                result[decreasingIndexStack.pop()] = nums[i];
            }
        }

        while (!decreasingIndexStack.isEmpty()) {
            result[decreasingIndexStack.pop()] = -1;
        }

        return result;
    }
}
