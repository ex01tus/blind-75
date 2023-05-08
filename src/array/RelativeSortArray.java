package array;

/**
 * Description: https://leetcode.com/problems/relative-sort-array
 * Difficulty: Easy
 * Time complexity: O(m + n)
 * Space complexity: O(n)
 */
public class RelativeSortArray {

    private static final int MAX_POSSIBLE_VAL = 1000;

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freqMap = buildFreqMap(arr1);

        int[] sorted = new int[arr1.length];
        int pointer = 0;
        for (int num : arr2) {
            for (int i = 0; i < freqMap[num]; i++) {
                sorted[pointer++] = num;
            }

            freqMap[num] = 0;
        }

        for (int num = 0; num <= MAX_POSSIBLE_VAL; num++) {
            for (int i = 0; i < freqMap[num]; i++) {
                sorted[pointer++] = num;
            }
        }

        return sorted;
    }

    private int[] buildFreqMap(int[] arr) {
        int[] freqMap = new int[MAX_POSSIBLE_VAL + 1];
        for (int num : arr) {
            freqMap[num]++;
        }

        return freqMap;
    }
}
