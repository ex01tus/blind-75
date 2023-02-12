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

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int[][] kClosestViaQuickSelect(int[][] points, int k) {
        return quickSelect(points, 0, points.length - 1, k);
    }

    private int[][] quickSelect(int[][] points, int left, int right, int k) {
        int partition = lomutoPartition(points, left, right);
        if (partition == k - 1) return Arrays.copyOfRange(points, 0, k);

        if (partition > k - 1) {
            return quickSelect(points, left, partition - 1, k);
        } else {
            return quickSelect(points, partition + 1, right, k);
        }
    }

    private int lomutoPartition(int[][] points, int left, int right) {
        int pivotDistance = distance(points[right]);
        int pivotPointer = left;

        for (int i = left; i < right; i++) {
            if (distance(points[i]) < pivotDistance) {
                swap(points, i, pivotPointer);
                pivotPointer++;
            }
        }

        swap(points, right, pivotPointer);

        return pivotPointer;
    }

    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(log n)
     */
    public int[][] kClosestViaSorting(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> Integer.compare(distance(p1), distance(p2)));
        return Arrays.copyOfRange(points, 0, k);
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
