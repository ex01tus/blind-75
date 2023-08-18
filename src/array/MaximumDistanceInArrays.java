package array;

import java.util.List;

/**
 * Description: https://leetcode.com/problems/maximum-distance-in-arrays
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaximumDistanceInArrays {

    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);

        int maxDistance = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++) {
            int last = arrays.get(i).size() - 1;

            maxDistance = Math.max(
                    maxDistance,
                    Math.max(
                            Math.abs(arrays.get(i).get(last) - min),
                            Math.abs(max - arrays.get(i).get(0))));

            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(last));
        }

        return maxDistance;
    }
}
