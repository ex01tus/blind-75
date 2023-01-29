package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/k-closest-points-to-origin
 * Difficulty: Medium
 */
public class KClosestPointsToOrigin {

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(log n)
     */
    public int[][] kClosestViaSorting(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> Integer.compare(distance(p1), distance(p2)));
        return Arrays.copyOfRange(points, 0, k);
    }

    /**
     * Time complexity: O(nlog k)
     * Space complexity: O(k)
     */
    public int[][] kClosestViaMinHeap(int[][] points, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(distance(p2), distance(p1)));

        for (int[] point : points) {
            minHeap.offer(point);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
