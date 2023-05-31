package design;

import java.util.Random;

/**
 * Description: https://leetcode.com/problems/random-pick-with-weight
 * Difficulty: Medium
 * Time complexity: O(n) for constructor() and O(log n) for pickIndex()
 * Space complexity: O(n)
 */
public class RandomPickWithWeight {

    private static class RandomPicker {

        private final int[] prefixSums;
        private final Random random;

        public RandomPicker(int[] weights) {
            this.prefixSums = buildPrefixSums(weights);
            this.random = new Random();
        }

        public int pickIndex() {
            // - for [1, 4, 6] pick random element in range [0, 5]
            // - find index of a prefixSum greater than pick
            // - each prefixSum corresponds to a value in an original array
            int pick = random.nextInt(prefixSums[prefixSums.length - 1]);
            return findFirstGreaterThan(pick);
        }

        private int findFirstGreaterThan(int target) {
            int left = 0;
            int right = prefixSums.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (prefixSums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }

        // [1, 3, 2] -> [1, 3, 3, 3, 2, 2]
        // 1 – [0, 0] – <1
        // 3 – [1, 3] – <4
        // 2 – [4, 5] – <6
        // [1, 4, 6]
        private int[] buildPrefixSums(int[] weights) {
            int[] prefixSums = new int[weights.length];
            int prefixSum = 0;
            for (int i = 0; i < weights.length; i++) {
                prefixSum += weights[i];
                prefixSums[i] = prefixSum;
            }

            return prefixSums;
        }
    }
}
