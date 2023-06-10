package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence
 * Difficulty: Easy
 */
public class CanMakeArithmeticProgressionFromSequence {

    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(log n)
     */
    public boolean canMakeArithmeticProgressionViaSorting(int[] arr) {
        Arrays.sort(arr);

        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) return false;
        }

        return true;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public boolean canMakeArithmeticProgressionViaSet(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (max == min) return true; // all elements are equal
        if ((max - min) % (arr.length - 1) != 0) return false;

        int diff = (max - min) / (arr.length - 1);
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) return false; // contains duplicates
            if ((max - num) % diff != 0) return false;
        }

        return true;
    }
}
