package heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists
 * Difficulty: Hard
 * Time complexity: O(nlog m)
 * Space complexity: O(m)
 */
public class SmallestRangeCoveringElementsFromKLists {

    public int[] smallestRange(List<List<Integer>> nums) {
        Queue<Tuple> minHeap = new PriorityQueue<>(Comparator.comparingInt(t -> t.val));
        int currentRangeMax = Integer.MIN_VALUE;

        // heap always contains ONE value from each row -> [heap.poll; currentRangeMax] is always a valid range
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);
            minHeap.offer(new Tuple(row.get(0), i, 0));
            currentRangeMax = Math.max(currentRangeMax, row.get(0));
        }

        int start = 0;
        int end = Integer.MAX_VALUE;
        while (minHeap.size() == nums.size()) {
            Tuple current = minHeap.poll();
            if (end - start > currentRangeMax - current.val) {
                // smaller range found
                start = current.val;
                end = currentRangeMax;
            }

            if (current.idx + 1 < nums.get(current.row).size()) {
                // update heap
                int next = nums.get(current.row).get(current.idx + 1);
                minHeap.offer(new Tuple(next, current.row, current.idx + 1));
                currentRangeMax = Math.max(currentRangeMax, next);
            }
        }

        return new int[]{start, end};
    }

    private record Tuple(int val, int row, int idx) {
    }
}
