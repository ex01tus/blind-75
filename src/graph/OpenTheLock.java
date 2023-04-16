package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/open-the-lock
 * Difficulty: Medium
 * Time complexity: O(10^n * n^2 + d)
 * Space complexity: O(10^n + d)
 */
public class OpenTheLock {

    private static final String START = "0000";
    private final int[] directions = new int[]{1, -1};

    public int openLock(String[] deadends, String target) {
        if (START.equals(target)) return 0;

        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        if (deadendsSet.contains(START)) return -1;

        // BFS with 10^n nodes
        return findShortestPath(target, deadendsSet);
    }

    private int findShortestPath(String target, Set<String> deadends) {
        Queue<String> planned = new LinkedList<>();
        planned.offer(START);

        Set<String> visited = new HashSet<>();
        visited.add(START);

        int steps = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            steps++;

            for (int i = 0; i < levelSize; i++) {
                String current = planned.poll();

                for (String neighbor : findNeighbors(current)) {
                    if (!deadends.contains(neighbor) && visited.add(neighbor)) {
                        if (neighbor.equals(target)) return steps;
                        planned.offer(neighbor);
                    }
                }
            }
        }

        return -1;
    }

    // takes O(n * 2 * n) time – n dials, each can be turned in 2 directions, and we call substring(n)
    private List<String> findNeighbors(String current) {
        List<String> neighbors = new ArrayList<>();
        for (int dial = 0; dial < current.length(); dial++) {
            for (int dir : directions) {
                int turnedDial = (current.charAt(dial) - '0' + dir + 10) % 10;
                String next = current.substring(0, dial) + turnedDial + current.substring(dial + 1);
                neighbors.add(next);
            }
        }

        return neighbors;
    }
}
