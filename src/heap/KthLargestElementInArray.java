package heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/proiblems/kth-largest-element-in-an-array
 * Difficulty: Medium
 */
public class KthLargestElementInArray {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int findKthLargestViaQuickSelect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivotPointer = lomutoPartition(nums, left, right);

        if (pivotPointer == k - 1) return nums[pivotPointer];

        if (pivotPointer > k - 1) {
            return quickSelect(nums, left, pivotPointer - 1, k);
        } else {
            return quickSelect(nums, pivotPointer + 1, right, k);
        }
    }

    private int lomutoPartition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int pivotPointer = left;

        for (int i = left; i < right; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, pivotPointer);
                pivotPointer++;
            }
        }

        swap(nums, pivotPointer, right);

        return pivotPointer;
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    /**
     * Time complexity: O(nlog k)
     * Space complexity: O(k)
     */
    public int findKthLargestViaMinHeap(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }

        return minHeap.peek();
    }
}
