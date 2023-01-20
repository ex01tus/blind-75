package binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/time-based-key-value-store
 * Difficulty: Medium
 * Time complexity: O(log n)
 * Space complexity: O(n)
 */
public class TimeBasedKeyValueStore {

    private final Map<String, List<Node>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
                .add(new Node(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Node> list = map.get(key);
        if (list == null) return "";

        return search(list, timestamp);
    }

    private String search(List<Node> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        String result = "";
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid).timestamp == target) {
                return list.get(mid).value;
            }

            if (list.get(mid).timestamp > target) {
                right = mid - 1;
            } else {
                result = list.get(mid).value;
                left = mid + 1;
            }
        }

        return result;
    }

    private static class Node {
        String value;
        int timestamp;

        public Node(String v, int t) {
            value = v;
            timestamp = t;
        }
    }
}
