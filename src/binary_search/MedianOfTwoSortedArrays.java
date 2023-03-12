package binary_search;

/**
 * Description: https://leetcode.com/problems/median-of-two-sorted-arrays
 * Difficulty: Hard
 * Time complexity: O(log min(m, n))
 * Space complexity: O(1)
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArraysV1(int[] small, int[] large) {
        if (small.length > large.length) {
            return findMedianSortedArraysV1(large, small);
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

    public double findMedianSortedArraysV2(int[] small, int[] large) {
        if (small.length > large.length) {
            return findMedianSortedArraysV2(large, small);
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
}
