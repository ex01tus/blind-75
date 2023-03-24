package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/time-needed-to-inform-all-employees
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MinimumTimeToInformAllEmployees {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> subordinatesMap = buildSubordinatesMap(manager, n);
        return countMinTime(headID, subordinatesMap, informTime);
    }

    private int countMinTime(int current, Map<Integer, List<Integer>> subordinatesMap, int[] informTime) {
        int time = 0;
        for (int subordinate : subordinatesMap.getOrDefault(current, List.of())) {
            time = Math.max(time, countMinTime(subordinate, subordinatesMap, informTime));
        }

        return time + informTime[current];
    }

    private Map<Integer, List<Integer>> buildSubordinatesMap(int[] manager, int n) {
        Map<Integer, List<Integer>> subordinatesMap = new HashMap<>();
        for (int employee = 0; employee < n; employee++) {
            subordinatesMap.computeIfAbsent(manager[employee], __ -> new ArrayList<>()).add(employee);
        }

        return subordinatesMap;
    }
}
