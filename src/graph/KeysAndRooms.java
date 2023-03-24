package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/keys-and-rooms
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class KeysAndRooms {

    public boolean canVisitAllRoomsV1(List<List<Integer>> rooms) {
        int[] visited = new int[rooms.size()];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        int count = 0;
        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (visited[current] == 0) {
                stack.push(current);
                visited[current] = 1;

                for (int neighbor : rooms.get(current)) {
                    if (visited[neighbor] == 0) {
                        stack.push(neighbor);
                    }
                }
            } else if (visited[current] == 1) {
                visited[current] = 2;
                count++;
            }
        }

        return count == rooms.size();
    }

    public boolean canVisitAllRoomsV2(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (visited.add(current)) {
                for (int neighbor : rooms.get(current)) {
                    stack.push(neighbor);
                }
            }
        }

        return visited.size() == rooms.size();
    }
}
