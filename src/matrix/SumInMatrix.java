package matrix;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/sum-in-a-matrix
 * Difficulty: Medium
 */
public class SumInMatrix {

    /**
     * Time complexity: O(m * nlog n + m * n)
     * Space complexity: O(log n)
     */
    public int matrixSumViaSorting(int[][] nums) {
        for (int[] row : nums) {
            Arrays.sort(row);
        }

        int score = 0;
        for (int col = 0; col < nums[0].length; col++) {
            int max = 0;
            for (int row = 0; row < nums.length; row++) {
                max = Math.max(max, nums[row][col]);
            }

            score += max;
        }

        return score;
    }

    /**
     * Time complexity: O(m * nlog n + m * n * nlog n)
     * Space complexity: O(m * n)
     */
    public int matrixSumViaMaxHeaps(int[][] nums) {
        List<Queue<Integer>> heaps = new ArrayList<>();
        for (int row = 0; row < nums.length; row++) {
            Queue<Integer> rowMaxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            heaps.add(rowMaxHeap);
            for (int col = 0; col < nums[0].length; col++) {
                rowMaxHeap.offer(nums[row][col]);
            }
        }

        int score = 0;
        for (int round = 0; round < nums[0].length; round++) {
            int max = 0;
            for (Queue<Integer> maxHeap : heaps) {
                max = Math.max(max, maxHeap.poll());
            }

            score += max;
        }

        return score;
    }
}
