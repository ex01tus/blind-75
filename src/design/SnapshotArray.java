package design;

import java.util.TreeMap;

/**
 * Description: https://leetcode.com/problems/snapshot-array
 * Difficulty: Medium
 * Time complexity: O(log n) for get(), O(1) for set() and snap()
 * Space complexity: O(n)
 */
public class SnapshotArray {

    private static class SnapshotArrayViaTreeMap {

        private final TreeMap<Integer, Integer>[] versionedValues;
        private int currentVersion;

        public SnapshotArrayViaTreeMap(int length) {
            this.versionedValues = new TreeMap[length];
            for (int i = 0; i < length; i++) {
                TreeMap<Integer, Integer> map = new TreeMap<>();
                map.put(0 ,0);
                versionedValues[i] = map;
            }
        }

        public void set(int index, int val) {
            versionedValues[index].put(currentVersion, val);
        }

        public int snap() {
            return currentVersion++;
        }

        public int get(int index, int snapshotId) {
            // find first less than or equal version
            return versionedValues[index].floorEntry(snapshotId).getValue();
        }
    }
}

