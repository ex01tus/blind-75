package heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/last-stone-weight
 * Difficulty: Easy
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((s1, s2) -> Integer.compare(s2, s1)) ;
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if (first != second) {
                maxHeap.offer(first - second);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
