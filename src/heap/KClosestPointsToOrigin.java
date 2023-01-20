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
    public int[][] kClosestViaMaxHeap(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(distance(p2), distance(p1)));

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
