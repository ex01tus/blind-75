package graph;

import java.util.*;

import static java.util.Collections.emptyList;

/**
 * Description: https://leetcode.com/problems/course-schedule
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class CourseSchedule {

    private Map<Integer, List<Integer>> adjList;
    private int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjList = toAdjList(prerequisites);
        visited = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (visited[course] == 0) {
                boolean hasCycle = hasCycle(course);
                if (hasCycle) return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int start) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (visited[current] == 0) {
                visited[current] = 1;
                stack.push(current);

                List<Integer> vertices = Optional.ofNullable(adjList.get(current)).orElse(emptyList());
                for (int v : vertices) {
                    if (visited[v] == 0) {
                        stack.push(v);
                    } else if (visited[v] == 1) {
                        return true;
                    }
                }
            } else if (visited[current] == 1) {
                visited[current] = 2;
            }
        }

        return false;
    }

    private Map<Integer, List<Integer>> toAdjList(int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] p : prerequisites) {
            List<Integer> vertices = adjList.get(p[1]);
            if (vertices == null) {
                vertices = new ArrayList<>();
            }

            vertices.add(p[0]);
            adjList.put(p[1], vertices);
        }

        return adjList;
    }
}
