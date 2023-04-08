package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/next-greater-element-i
 * Difficulty: Easy
 */
public class NextGreaterElement {

    /**
     * Time complexity: O(n + m)
     * Space complexity: O(m)
     */
    public int[] nextGreaterElementViaStack(int[] nums1, int[] nums2) {
        Deque<Integer> decreasingStack = new LinkedList<>();
        Map<Integer, Integer> firstGreaterMap = new HashMap<>();
        for (int num : nums2) {
            while (!decreasingStack.isEmpty() && num > decreasingStack.peek() ) {
                firstGreaterMap.put(decreasingStack.pop(), num);
            }

            decreasingStack.push(num);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = firstGreaterMap.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    /**
     * Time complexity: O(n * m)
     * Space complexity: O(m)
     */
    public int[] nextGreaterElementNaiveApproach(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            numToIndex.put(nums2[i], i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = numToIndex.get(nums1[i]);
            while (j < nums2.length) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }

                j++;
            }

            if (j == nums2.length) {
                result[i] = -1;
            }
        }

        return result;
    }
}
