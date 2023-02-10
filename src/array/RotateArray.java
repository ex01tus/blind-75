package array;

/**
 * Description: https://leetcode.com/problems/rotate-array
 * Difficulty: Medium
 */
public class RotateArray {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public void rotateViaExtraArray(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;

        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[(i + k) % tmp.length] = nums[i];
        }

        for (int i = 0; i < tmp.length; i++) {
            nums[i] = tmp[i];
        }
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public void rotateViaTripleReversal(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
                                                    // k = 3
        reverse(nums, 0, nums.length - 1); // 1 2 3 4 5 -> 5 4 3 2 1
        reverse(nums, 0, k - 1);           // 5 4 3 2 1 -> 3 4 5 2 1
        reverse(nums, k, nums.length - 1);     // 3 4 5 2 1 -> 3 4 5 1 2
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
