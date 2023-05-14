package design;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * Difficulty: Hard
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
public class InsertDeleteGetRandomDuplicatesAllowed {

    private static class RandomizedCollection {

        private final List<Integer> values;
        private final Map<Integer, Set<Integer>> indicesMap;
        private final Random random;

        public RandomizedCollection() {
            values = new ArrayList<>();
            indicesMap = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            values.add(val);
            Set<Integer> indices = indicesMap.computeIfAbsent(val, __ -> new HashSet<>());
            indices.add(values.size() - 1);

            return indices.size() == 1;
        }

        public boolean remove(int val) {
            Set<Integer> indices = indicesMap.getOrDefault(val, Set.of());
            if (indices.isEmpty()) return false;

            int idx = indices.iterator().next();
            indices.remove(idx);

            int lastIdx = values.size() - 1;

            if (idx != lastIdx) { // overwrite element to be removed with the last one
                int lastVal = values.get(lastIdx);
                values.set(idx, lastVal);

                Set<Integer> lastValIndices = indicesMap.get(lastVal);
                lastValIndices.remove(lastIdx);
                lastValIndices.add(idx);
            }

            values.remove(lastIdx); // remove the last element
            if (indices.isEmpty()) indicesMap.remove(val);

            return true;
        }

        public int getRandom() {
            int randomIdx = random.nextInt(values.size());
            return values.get(randomIdx);
        }
    }
}
