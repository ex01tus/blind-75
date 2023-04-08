package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/intersection-of-three-sorted-arrays
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class IntersectionOfThreeSortedArrays {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        List<Integer> intersection = new ArrayList<>();
        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
            if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
                intersection.add(arr1[p1]);
                p1++;
                p2++;
                p3++;
                continue;
            }

            int minValue = Math.min(arr1[p1], Math.min(arr2[p2], arr3[p3]));
            if (arr1[p1] == minValue) p1++;
            if (arr2[p2] == minValue) p2++;
            if (arr3[p3] == minValue) p3++;
        }

        return intersection;
    }
}
