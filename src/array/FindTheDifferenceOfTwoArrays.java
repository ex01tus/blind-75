package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/find-the-difference-of-two-arrays
 * Difficulty: Easy
 * Time complexity: O(m + n)
 * Space complexity: O(m + n)
 */
public class FindTheDifferenceOfTwoArrays {

    public static void main(String[] args) {
        int n = 5;
        int times = n / 4 + (n % 4 == 0 ? 0 : 1);
        System.out.println(times);
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        Set<Integer> set1 = new HashSet<>();
        List<Integer> result1 = new ArrayList<>();
        for (int num : nums1) {
            set1.add(num);
            if (set2.add(num)) result1.add(num);
        }

        List<Integer> result2 = new ArrayList<>();
        for (int num : nums2) {
            if (set1.add(num)) result2.add(num);
        }

        return List.of(result1, result2);
    }
}
