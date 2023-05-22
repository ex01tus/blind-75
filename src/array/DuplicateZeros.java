package array;

/**
 * Description: https://leetcode.com/problems/duplicate-zeros
 * Difficulty: Easy
 */
public class DuplicateZeros {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public void duplicateZerosOptimalApproach(int[] arr) {
        int shifts = 0;
        int pointer = 0;

        // if (pointer + shifts >= arr.length), we can no longer do the shifts
        for (; pointer + shifts < arr.length; pointer++) {
            if (arr[pointer] == 0) shifts++;
        }

        for (pointer = pointer - 1; shifts > 0; pointer--) {
            if (pointer + shifts < arr.length) arr[pointer + shifts] = arr[pointer];
            if (arr[pointer] == 0) arr[pointer + --shifts] = arr[pointer];
        }
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public void duplicateZerosNaiveApproach(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) continue;
            for (int j = arr.length - 1; j > i; j--) {
                arr[j] = arr[j - 1];
            }

            i++;
        }
    }
}
