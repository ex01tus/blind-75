package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/clone-graph
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class CloneGraph {

    private Map<Integer, Integer> visited;
    private Map<Integer, Node> newNodes;

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        visited = new HashMap<>();
        newNodes = new HashMap<>();

        dfs(node);

        return newNodes.get(1);
    }

    private void dfs(Node start) {
        Deque<Node> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (visited.get(current.val) == null) {
                Node currentCopy = clone(current);
                visited.put(current.val, 1);
                stack.push(current);

                for (Node neighbor : current.neighbors) {
                    Node neighborCopy = clone(neighbor);
                    currentCopy.neighbors.add(neighborCopy);

                    if (visited.get(neighbor.val) == null) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    private Node clone(Node current) {
        Node copyNode = newNodes.get(current.val);
        if (copyNode == null) {
            copyNode = new Node(current.val);
            newNodes.put(current.val, copyNode);
        }

        return copyNode;
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }
}
