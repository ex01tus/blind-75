package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class FindThePrefixCommonArrayOfTwoArrays {

    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        Set<Integer> seen = new HashSet<>();

        int[] common = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            seen.add(a[i]);
            seen.add(b[i]);

            common[i] = 2 * (i + 1) - seen.size();
        }

        return common;
    }
}
