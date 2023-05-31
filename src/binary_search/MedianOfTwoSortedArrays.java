package binary_search;

/**
 * Description: https://leetcode.com/problems/median-of-two-sorted-arrays
 * Difficulty: Hard
 */
public class MedianOfTwoSortedArrays {

    /**
     * Time complexity: O(log min(m, n))
     * Space complexity: O(1)
     */
    public double findMedianSortedArraysViaBinarySearchV1(int[] small, int[] large) {
        if (small.length > large.length) {
            return findMedianSortedArraysViaBinarySearchV1(large, small);
        }

        int total = small.length + large.length;
        int half = total / 2;

        int left = 0;
        int right = small.length;
        while (left <= right) {
            int smallCut = left + (right - left) / 2; // 1 2 3 4 <_>
            int smallLeft = smallCut > 0 ? small[smallCut - 1] : Integer.MIN_VALUE; // 1 2 3 [4] <_>
            int smallRight = smallCut < small.length ? small[smallCut] : Integer.MAX_VALUE; // 1 2 3 4 [+inf]

            int largeCut = half - smallCut; // 5 <6> 7 8 9 10
            int largeLeft = largeCut > 0 ? large[largeCut - 1] : Integer.MIN_VALUE; // [5] <6> 7 8 9 10
            int largeRight = largeCut < large.length ? large[largeCut] : Integer.MAX_VALUE; // 5 [6] 7 8 9 10

            if (largeLeft > smallRight) {
                left = smallCut + 1;
            } else if (smallLeft > largeRight) {
                right = smallCut - 1;
            } else {
                if (total % 2 == 0) { // even
                    return (Math.max(smallLeft, largeLeft) + Math.min(smallRight, largeRight)) / 2.0;
                } else { // odd
                    return Math.min(smallRight, largeRight);
                }
            }
        }

        throw new RuntimeException();
    }

    /**
     * Time complexity: O(log min(m, n))
     * Space complexity: O(1)
     */
    public double findMedianSortedArraysViaBinarySearchV2(int[] small, int[] large) {
        if (small.length > large.length) {
            return findMedianSortedArraysViaBinarySearchV2(large, small);
        }

        int total = small.length + large.length;

        int left = 0;
        int right = small.length * 2;
        while (left <= right) {
            int smallCut = left + (right - left) / 2;
            int smallLeft = smallCut > 0 ? small[(smallCut - 1) / 2] : Integer.MIN_VALUE;
            int smallRight = smallCut < small.length * 2 ? small[smallCut / 2] : Integer.MAX_VALUE;

            int largeCut = total - smallCut;
            int largeLeft = largeCut > 0 ? large[(largeCut - 1) / 2] : Integer.MIN_VALUE;
            int largeRight = largeCut < large.length * 2 ? large[largeCut / 2] : Integer.MAX_VALUE;

            if (largeLeft > smallRight) {
                left = smallCut + 1;
            } else if (smallLeft > largeRight) {
                right = smallCut - 1;
            } else {
                return (Math.max(largeLeft, smallLeft) + Math.min(largeRight, smallRight)) / 2.0;
            }
        }

        throw new RuntimeException();
    }

    /**
     * Time complexity: O(m + n)
     * Space complexity: O(m + n)
     */
    public double findMedianSortedArraysViaMerge(int[] first, int[] second) {
        int[] merged = merge(first, second);
        int length = merged.length;
        return length % 2 == 0
                ? (merged[length / 2 - 1] + merged[length / 2]) / 2.0
                : (double) merged[length / 2];
    }

    private int[] merge(int[] first, int[] second) {
        int[] merged = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                merged[k++] = first[i++];
            } else {
                merged[k++] = second[j++];
            }
        }

        while (i < first.length) {
            merged[k++] = first[i++];
        }

        while (j < second.length) {
            merged[k++] = second[j++];
        }

        return merged;
    }
}
