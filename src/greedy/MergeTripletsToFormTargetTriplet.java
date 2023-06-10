package greedy;

import java.util.Arrays;

/**
 * Description: https://leetcode.com/problems/merge-triplets-to-form-target-triplet
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MergeTripletsToFormTargetTriplet {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] result = new int[3];
        for (int[] triplet : triplets) {
            // if we merge with such a triplet, we will never be able to form a target value
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) continue;

            result[0] = Math.max(result[0], triplet[0]);
            result[1] = Math.max(result[1], triplet[1]);
            result[2] = Math.max(result[2], triplet[2]);
        }

        return Arrays.equals(result, target);
    }
}
