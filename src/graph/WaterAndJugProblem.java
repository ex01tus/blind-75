package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/water-and-jug-problem
 * Difficulty: Medium
 * Time complexity: O(xy)
 * Space complexity: O(xy)
 */
public class WaterAndJugProblem {

    public boolean canMeasureWater(int first, int second, int target) {
        if (target > first + second) return false;

        State start = new State(0, 0); // both jugs are empty
        Set<State> visited = new HashSet<>();
        visited.add(start);

        Queue<State> planned = new LinkedList<>();
        planned.offer(start);

        while (!planned.isEmpty()) {
            State current = planned.poll();
            if (current.first + current.second == target) return true;

            for (State neighbor : findNeighbors(current, first, second)) {
                if (visited.add(neighbor)) {
                    planned.offer(neighbor);
                }
            }
        }

        return false;
    }

    private List<State> findNeighbors(State current, int small, int large) {
        return List.of(
                new State(small, current.second), // fill first
                new State(current.first, small), // fill second
                new State(0, current.second), // empty first
                new State(current.first, 0), // empty second
                new State( // first -> second
                        current.first - Math.min(current.first, large - current.second),
                        current.second + Math.min(current.first, large - current.second)),
                new State( // second -> first
                        current.first + Math.min(current.second, small - current.first),
                        current.second - Math.min(current.second, small - current.first)));
    }

    private record State(int first, int second) {
    }
}
