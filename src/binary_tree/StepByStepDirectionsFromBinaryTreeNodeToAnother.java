package binary_tree;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another
 * Difficulty: Medium
 */
public class StepByStepDirectionsFromBinaryTreeNodeToAnother {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public String getDirectionsViaBFS(TreeNode root, int startValue, int destValue) {
        Map<TreeNode, TreeNode> rootToParentMap = new HashMap<>();
        findParents(root, rootToParentMap);

        // can find it while building parents map not to traverse the graph one more time
        TreeNode start = find(root, startValue);

        return findShortestPath(start, destValue, rootToParentMap);
    }

    private String findShortestPath(TreeNode start, int target, Map<TreeNode, TreeNode> rootToParentMap) {
        Queue<Pair> planned = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        planned.offer(new Pair(start, ""));

        while (!planned.isEmpty()) {
            int levelSize = planned.size();
            for (int i = 0; i < levelSize; i++) {
                Pair current = planned.poll();
                TreeNode currentNode = current.node;
                if (currentNode.val == target) return current.path;

                if (currentNode.left != null && visited.add(currentNode.left)) {
                    planned.offer(new Pair(currentNode.left, current.path + "L"));
                }

                if (currentNode.right != null && visited.add(currentNode.right)) {
                    planned.offer(new Pair(currentNode.right, current.path + "R"));
                }

                TreeNode parent = rootToParentMap.get(currentNode);
                if (parent != null && visited.add(parent)) {
                    planned.offer(new Pair(parent, current.path + "U"));
                }
            }
        }

        return "";
    }

    private TreeNode find(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        TreeNode left = find(root.left, val);
        TreeNode right = find(root.right, val);

        return left != null ? left : right;
    }

    private void findParents(TreeNode root, Map<TreeNode, TreeNode> parents) {
        if (root == null) return;

        if (root.left != null) {
            parents.put(root.left, root);
            findParents(root.left, parents);
        }

        if (root.right != null) {
            parents.put(root.right, root);
            findParents(root.right, parents);
        }
    }

    private record Pair(TreeNode node, String path) {
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public String getDirectionsViaLCA(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);
        String fromStart = buildPathFromStart(lca, startValue, new StringBuilder()); // start -> lca
        String toDest = buildPathToDest(lca, destValue, new StringBuilder());        // lca -> dest

        return fromStart + toDest;
    }

    private String buildPathFromStart(TreeNode root, int start, StringBuilder path) {
        if (root == null) return null;
        if (root.val == start) return path.toString();

        path.append("U");
        String left = buildPathFromStart(root.left, start, path);
        String right = buildPathFromStart(root.right, start, path);
        path.deleteCharAt(path.length() - 1);

        return left != null ? left : right;
    }

    private String buildPathToDest(TreeNode root, int dest, StringBuilder path) {
        if (root == null) return null;
        if (root.val == dest) return path.toString();

        path.append("L");
        String left = buildPathToDest(root.left, dest, path);
        path.deleteCharAt(path.length() - 1);

        path.append("R");
        String right = buildPathToDest(root.right, dest, path);
        path.deleteCharAt(path.length() - 1);

        return left != null ? left : right;
    }

    private TreeNode findLCA(TreeNode root, int first, int second) {
        if (root == null) return null;
        if (root.val == first || root.val == second) return root;

        TreeNode left = findLCA(root.left, first, second);
        TreeNode right = findLCA(root.right, first, second);
        if (left == null) return right;
        if (right == null) return left;

        return root;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public String getDirectionsViaTwoPaths(TreeNode root, int startValue, int destValue) {
        String pathToStart = buildPath(root, startValue, new StringBuilder());
        String pathToDest = buildPath(root, destValue, new StringBuilder());

        // skip the common part of two paths
        int skip = 0;
        while (skip < pathToStart.length()
                && skip < pathToDest.length()
                && pathToStart.charAt(skip) == pathToDest.charAt(skip)) {
            skip++;
        }

        // replace all the pathToStart directions with 'U'
        StringBuilder directions = new StringBuilder();
        for (int j = skip; j < pathToStart.length(); j++) {
            directions.append("U");
        }

        return directions.append(pathToDest.substring(skip)).toString();
    }

    private String buildPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) return null;
        if (root.val == target) return path.toString();

        path.append("L");
        String left = buildPath(root.left, target, path);
        path.deleteCharAt(path.length() - 1);

        path.append("R");
        String right = buildPath(root.right, target, path);
        path.deleteCharAt(path.length() - 1);

        return left != null ? left : right;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
