package binary_tree;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Description: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class AllNodesDistanceKToBinaryTree {

    private Map<TreeNode, TreeNode> nodeToParent;
    private Set<TreeNode> visited;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        nodeToParent = new HashMap<>();
        findParents(root, null); // we need to know each node's parent to treat this tree like a graph

        visited = new HashSet<>();

        return findKthGraphLevel(target, k) // run BFS from the target node
                .stream()
                .map(node -> node.val)
                .collect(toList());
    }

    private void findParents(TreeNode current, TreeNode parent) {
        if (current == null) return;

        if (parent != null) {
            nodeToParent.put(current, parent);
        }

        findParents(current.left, current);
        findParents(current.right, current);
    }

    private List<TreeNode> findKthGraphLevel(TreeNode start, int k) {
        Queue<TreeNode> planned = new LinkedList<>();
        planned.offer(start);
        visited.add(start);

        int level = 0;
        while (!planned.isEmpty()) {
            if (level == k) return new ArrayList<>(planned);
            level++;

            int levelSize = planned.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = planned.poll();

                if (current.left != null && visited.add(current.left)) {
                    planned.offer(current.left);
                }

                if (current.right != null && visited.add(current.right)) {
                    planned.offer(current.right);
                }

                TreeNode parent = nodeToParent.get(current);
                if (parent != null && visited.add(parent)) {
                    planned.offer(parent);
                }
            }
        }

        return List.of();
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
