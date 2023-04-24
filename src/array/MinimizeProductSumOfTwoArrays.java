package array;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/minimize-product-sum-of-two-arrays
 * Difficulty: Medium
 */
public class MinimizeProductSumOfTwoArrays {

    private static final int LOWER_DATA_BOUND = 0;
    private static final int UPPER_DATA_BOUND = 100;

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int minProductSumViaCountingSort(int[] nums1, int[] nums2) {
        int[] counter1 = new int[UPPER_DATA_BOUND + 1];
        int[] counter2 = new int[UPPER_DATA_BOUND + 1];

        for (int i = 0; i < nums1.length; i++) {
            counter1[nums1[i]]++;
            counter2[nums2[i]]++;
        }

        int p1 = LOWER_DATA_BOUND;
        int p2 = UPPER_DATA_BOUND;
        int dotProduct = 0;

        while (p1 <= UPPER_DATA_BOUND && p2 > LOWER_DATA_BOUND) {
            while (p1 <= UPPER_DATA_BOUND && counter1[p1] == 0) {
                p1++;
            }

            while (p2 > LOWER_DATA_BOUND && counter2[p2] == 0) {
                p2--;
            }

            if (p1 > UPPER_DATA_BOUND || p2 == LOWER_DATA_BOUND) break;

            int occurrences = Math.min(counter1[p1], counter2[p2]);
            dotProduct += occurrences * p1 * p2;
            counter1[p1] -= occurrences;
            counter2[p2] -= occurrences;
        }

        return dotProduct;
    }

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(log n)
     */
    public int minProductSumViaSorting(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int dotProduct = 0;
        for (int i = 0; i < nums1.length; i++) {
            dotProduct += nums1[i] * nums2[nums1.length - 1 - i];
        }

        return dotProduct;
    }
}
