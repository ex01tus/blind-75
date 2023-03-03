package binary_tree;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/serialize-and-deserialize-binary-tree
 * Difficulty: Hard
 * Time complexity: O(n)
 * Space complexity: O(h)
 */
public class SerializeAndDeserializeBinaryTree {

    private static class CodecViaPreorderTraversal {

        public String serialize(TreeNode root) {
            StringBuilder preorder = new StringBuilder();
            serialize(root, preorder);

            return preorder.toString();
        }

        private void serialize(TreeNode root, StringBuilder preorder) {
            if (root == null) {
                preorder.append("null").append(",");
                return;
            }

            preorder.append(root.val).append(",");
            serialize(root.left, preorder);
            serialize(root.right, preorder);
        }

        public TreeNode deserialize(String data) {
            Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(nodes);
        }

        private TreeNode deserialize(Queue<String> nodes) {
            String current = nodes.poll();
            if (current.equals("null")) return null;

            TreeNode node = new TreeNode();
            node.val = Integer.parseInt(current);
            node.left = deserialize(nodes);
            node.right = deserialize(nodes);

            return node;
        }
    }

    private static class CodecViaBFS {

        public String serialize(TreeNode root) {
            StringBuilder bfs = new StringBuilder();
            Queue<TreeNode> planned = new LinkedList<>();
            planned.offer(root);

            while (!planned.isEmpty()) {
                TreeNode current = planned.poll();
                if (current == null) {
                    bfs.append("null").append(",");
                    continue;
                }

                bfs.append(current.val).append(",");
                planned.offer(current.left);
                planned.offer(current.right);
            }

            return bfs.toString();
        }

        public TreeNode deserialize(String data) {
            String[] values = data.split(",");
            if (values[0].equals("null")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));

            Queue<TreeNode> planned = new LinkedList<>();
            planned.offer(root);

            for (int i = 1; i < values.length; i += 2) {
                TreeNode current = planned.poll();

                String left = values[i];
                if (!left.equals("null")) {
                    current.left = new TreeNode(Integer.parseInt(left));
                    planned.offer(current.left);
                }

                String right = values[i + 1];
                if (!right.equals("null")) {
                    current.right = new TreeNode(Integer.parseInt(right));
                    planned.offer(current.right);
                }
            }

            return root;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
