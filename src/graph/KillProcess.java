package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/kill-process
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int process) {
        Map<Integer, List<Integer>> adjList = buildAdjList(pid, ppid);

        List<Integer> killed = new ArrayList<>();
        kill(process, adjList, killed);

        return killed;
    }

    private Map<Integer, List<Integer>> buildAdjList(List<Integer> pid, List<Integer> ppid) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            adjList.computeIfAbsent(ppid.get(i), __ -> new ArrayList<>()).add(pid.get(i));
        }

        return adjList;
    }

    private void kill(int process, Map<Integer, List<Integer>> adjList, List<Integer> killed) {
        killed.add(process);

        for (int child : adjList.getOrDefault(process, List.of())) {
            kill(child, adjList, killed);
        }
    }
}
