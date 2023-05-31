package heap;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/find-k-closest-elements
 * Difficulty: Medium
 */
public class FindKClosestElements {

    /**
     * Time complexity: O(k + log n)
     * Space complexity: O(k)
     */
    public List<Integer> findClosestElementsViaBinarySearch(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // search for a start of a window [left; left + k) with a center closest to x
            if (x > (arr[mid] + arr[mid + k]) / 2.0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    /**
     * Time complexity: O(nlog k)
     * Space complexity: O(k)
     */
    public List<Integer> findClosestElementsViaMaxHeap(int[] arr, int k, int x) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> compare(a, b, x));

        for (int num : arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) maxHeap.poll();
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }

        Collections.sort(result);
        return result;
    }

    private int compare(int a, int b, int x) {
        int result = Integer.compare(Math.abs(b - x), Math.abs(a - x));
        return result == 0
                ? Integer.compare(b, a)
                : result;
    }
}
