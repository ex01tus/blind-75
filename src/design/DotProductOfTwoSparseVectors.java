package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/dot-product-of-two-sparse-vectors
 * Difficulty: Medium
 * Time complexity: O(n) for constructor and O(min(m,n)) for dotProduct()
 * Space complexity: O(n) for constructor and O(1) gor dotProduct()
 */
public class DotProductOfTwoSparseVectors {

    private static class SparseVectorViaMap {

        private final Map<Integer, Integer> indicesMap;

        public SparseVectorViaMap(int[] nums) {
            indicesMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) indicesMap.put(i, nums[i]);
            }
        }

        public int dotProduct(SparseVectorViaMap other) {
            // iterate through smaller map
            return this.indicesMap.size() < other.indicesMap.size()
                    ? dotProduct(this.indicesMap, other.indicesMap)
                    : dotProduct(other.indicesMap, this.indicesMap);
        }

        private int dotProduct(Map<Integer, Integer> small, Map<Integer, Integer> large) {
            int dotProduct = 0;

            for (Map.Entry<Integer, Integer> entry : small.entrySet()) {
                dotProduct += entry.getValue() * large.getOrDefault(entry.getKey(), 0);
            }

            return dotProduct;
        }
    }

    private static class SparseVectorViaList {

        private final List<int[]> indicesList;

        public SparseVectorViaList(int[] nums) {
            indicesList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) indicesList.add(new int[]{i, nums[i]});
            }
        }

        public int dotProduct(SparseVectorViaList other) {
            int first = 0;
            int second = 0;

            int dotProduct = 0;
            while (first < this.indicesList.size() && second < other.indicesList.size()) {
                if (this.indicesList.get(first)[0] < other.indicesList.get(second)[0]) {
                    first++;
                } else if (this.indicesList.get(first)[0] > other.indicesList.get(second)[0]) {
                    second++;
                } else {
                    dotProduct += this.indicesList.get(first)[1] * other.indicesList.get(second)[1];
                    first++;
                    second++;
                }
            }

            return dotProduct;
        }
    }
}
