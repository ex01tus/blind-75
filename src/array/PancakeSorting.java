package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/pancake-sorting
 * Difficulty: Medium
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
public class PancakeSorting {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> flips = new ArrayList<>();
        for (int current = arr.length; current > 0; current--) {
            int index = find(arr, current);
            if (index == current - 1) continue; // already in place

            if (index != 0) {
                // flip to the head
                flips.add(index + 1);
                flip(arr, index + 1);
            }

            // flip to the tail
            flips.add(current);
            flip(arr, current);
        }

        return flips;
    }

    private void flip(int[] arr, int index) {
        for (int i = 0; i < index / 2; i++) {
            swap(arr, i, index - i - 1);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int find(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) return i;
        }

        return -1;
    }
}
