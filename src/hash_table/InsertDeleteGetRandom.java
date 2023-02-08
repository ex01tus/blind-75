package hash_table;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/insert-delete-getrandom-o1
 * Difficulty: Medium
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
public class InsertDeleteGetRandom {

    private static class RandomizedSet {

        private final List<Integer> values;
        private final Map<Integer, Integer> indicesMap;
        private final Random random;

        public RandomizedSet() {
            values = new ArrayList<>();
            indicesMap = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (indicesMap.containsKey(val)) return false;

            values.add(val);
            indicesMap.put(val, values.size() - 1);

            return true;
        }

        public boolean remove(int val) {
            if (!indicesMap.containsKey(val)) return false;

            int idx = indicesMap.get(val);
            int lastIdx = values.size() - 1;

            if (idx != lastIdx) { // overwrite element to be removed with the last one
                int lastVal = values.get(lastIdx);
                values.set(idx, lastVal);
                indicesMap.put(lastVal, idx);
            }

            values.remove(lastIdx); // remove the last element
            indicesMap.remove(val);

            return true;
        }

        public int getRandom() {
            int randomIdx = random.nextInt(values.size());
            return values.get(randomIdx);
        }
    }
}
