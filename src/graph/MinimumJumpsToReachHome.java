package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/minimum-jumps-to-reach-home
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MinimumJumpsToReachHome {

    private static final int START = 0;
    private static final int LIMIT = 6000; // too much math involved to prove

    private static final int BACKWARD = 0;
    private static final int FORWARD = 1;
    private static final int UNDEFINED = -1;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int f : forbidden) {
            forbiddenSet.add(f);
        }

        return findShortestPath(x, a, b, forbiddenSet);
    }

    private int findShortestPath(int target, int forward, int backward, Set<Integer> forbidden) {
        Set<Node> visited = new HashSet<>();
        visited.add(new Node(START, BACKWARD));
        visited.add(new Node(START, FORWARD));

        Queue<Node> planned = new LinkedList<>();
        planned.offer(new Node(START, UNDEFINED));

        int steps = 0;
        while (!planned.isEmpty()) {
            int levelSize = planned.size();

            for (int i = 0; i < levelSize; i++) {
                Node current = planned.poll();
                if (current.idx == target) return steps;

                Node moveForward = new Node(current.idx + forward, FORWARD);
                Node moveBackward = new Node(current.idx - backward, BACKWARD);

                if (!forbidden.contains(moveForward.idx)
                        && moveForward.idx <= LIMIT
                        && visited.add(moveForward)) {
                    planned.offer(moveForward);
                }

                if (current.direction != BACKWARD // can't jump backward twice
                        && !forbidden.contains(moveBackward.idx)
                        && moveBackward.idx >= 0
                        && visited.add(moveBackward)) {
                    planned.offer(moveBackward);
                }
            }

            steps++;
        }

        return -1;
    }

    private record Node(int idx, int direction) {
    }
}
