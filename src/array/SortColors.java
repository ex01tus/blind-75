package array;

/**
 * Description: https://leetcode.com/problems/sort-colors
 * Difficulty: Medium
 */
public class SortColors {

    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public void sortColorsViaDutchFlagAlgo(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = nums.length - 1;

        while (white <= blue) {
            if (nums[white] == WHITE) {
                white++;
            } else if (nums[white] == RED) {
                swap(nums, white, red);
                white++;
                red++;
            } else { // nums[white] == BLUE
                swap(nums, white, blue);
                blue--;
            }
        }
    }

    /**
     * Time complexity: O(n * k)
     * Space complexity: O(k)
     */
    public void sortColorsViaCountingSort(int[] nums) {
        int[] count = new int[3];

        for (int color : nums) {
            count[color]++;
        }

        int k = 0;
        for (int i = 0; i < count.length; i++) {
            int colorCount = count[i];
            for (int j = 0; j < colorCount; j++) {
                nums[k] = i;
                k++;
            }
        }
    }

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(log n)
     */
    public void sortColorsViaInPlaceQuickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int l = left;
        int r = right;
        int pivot = nums[l + (r - l) / 2];

        while (l <= r) {
            if (nums[l] < pivot) {
                l++;
            } else if (nums[r] > pivot) {
                r--;
            } else {
                swap(nums, l, r);
                l++;
                r--;
            }
        }

        quickSort(nums, left, r);
        quickSort(nums, l, right);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
