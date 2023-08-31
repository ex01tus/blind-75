package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ConvertArrayInto2DArrayWithConditions {

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> matrix = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            int count = freqMap.merge(num, 1, Integer::sum);

            if (count > matrix.size()) {
                matrix.add(new ArrayList<>());
            }

            matrix.get(count - 1).add(num);
        }


        return matrix;
    }
}
