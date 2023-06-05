package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/course-schedule-ii
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class CourseSchedule2 {

    private int[] visited;
    private Deque<Integer> topologicalPath;

    public int[] findOrderViaTopologicalSort(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        topologicalPath = new LinkedList<>();
        Map<Integer, List<Integer>> adjList = buildAdjList(prerequisites);

        for (int course = 0; course < numCourses; course++) {
            if (visited[course] == 0) {
                boolean hasCycle = hasCycle(adjList, course);
                if (hasCycle) return new int[0];
            }
        }

        int[] sortedCourses = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            sortedCourses[i] = topologicalPath.poll();
        }

        return sortedCourses;
    }

    private Map<Integer, List<Integer>> buildAdjList(int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            List<Integer> children = adjList.computeIfAbsent(prerequisite[1], __ -> new ArrayList<>());
            children.add(prerequisite[0]);
        }

        return adjList;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> adjList, int start) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (visited[current] == 0) {
                visited[current] = 1;
                stack.push(current);

                List<Integer> children = adjList.getOrDefault(current, List.of());
                for (int child : children) {
                    if (visited[child] == 1) return true;
                    if (visited[child] == 0) {
                        stack.push(child);
                    }
                }
            } else if (visited[current] == 1) {
                visited[current] = 2;
                topologicalPath.push(current);
            }
        }

        return false;
    }
}
