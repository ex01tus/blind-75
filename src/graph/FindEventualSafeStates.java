package graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/find-eventual-safe-states
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class FindEventualSafeStates {

    private static final int WHITE = 0;
    private static final int GREY = 1;
    private static final int BLACK = 2;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visited = new int[graph.length];

        List<Integer> safeNodes = new ArrayList<>();
        for (int node = 0; node < graph.length; node++) {
            if (!hasCycle(graph, visited, node)) {
                safeNodes.add(node);
            }
        }

        return safeNodes;
    }

    private boolean hasCycle(int[][] graph, int[] visited, int start) {
        if (visited[start] != WHITE) {
            // if we've already visited the node, check if we were able to color it BLACK
            return visited[start] == GREY;
        }

        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (visited[current] == WHITE) {
                visited[current] = GREY;
                stack.push(current);

                for (int neighbor : graph[current]) {
                    if (visited[neighbor] == GREY) return true;
                    if (visited[neighbor] == WHITE) {
                        stack.push(neighbor);
                    }
                }
            } else if (visited[current] == GREY) {
                visited[current] = BLACK;
            }
        }

        return false;
    }
}
