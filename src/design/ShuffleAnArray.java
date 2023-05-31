package design;

import java.util.Arrays;
import java.util.Random;

/**
 * Description: https://leetcode.com/problems/shuffle-an-array
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ShuffleAnArray {

    private static class ArrayShufflerViaFisherYatesAlgo {

        private final Random random;
        private final int[] original;
        private final int[] nums;

        public ArrayShufflerViaFisherYatesAlgo(int[] nums) {
            this.random = new Random();
            this.original = Arrays.copyOf(nums, nums.length);
            this.nums = nums;
        }

        public int[] reset() {
            return original;
        }

        public int[] shuffle() {
            // each element has an equal chance to be swapped with i
            for (int i = nums.length - 1; i > 0; i--) {
                int j = random.nextInt(i + 1); // pick j in range [0, i]
                swap(nums, i, j);
            }

            return nums;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
