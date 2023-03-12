package array;

/**
 * Description: https://leetcode.com/problems/sort-an-array
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(log n)
 */
public class SortAnArray {

    public int[] sortArrayViaQuickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int partition = lomutoPartition(nums, left, right);
        quickSort(nums, partition + 1, right);
        quickSort(nums, left, partition - 1);
    }

    private int lomutoPartition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int pivotPointer = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, pivotPointer);
                pivotPointer++;
            }
        }

        swap(nums, pivotPointer, right);
        return pivotPointer;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int[] sortArrayViaMergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int pointer = 0;

        while (l <= mid || r <= right) {
            if (l > mid || (r <= right && nums[l] > nums[r])) {
                tmp[pointer++] = nums[r++];
            } else {
                tmp[pointer++] = nums[l++];
            }
        }

        System.arraycopy(tmp, 0, nums, left, right - left + 1);
    }
}
