package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/implement-trie-prefix-tree
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ImplementTrie {

    private static class Trie {

        private final Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node current = root;

            for (char c : word.toCharArray()) {
                Node child = current.children.computeIfAbsent(c, __ -> new Node());
                current = child;
            }

            current.isTerminal = true;
        }

        public boolean search(String word) {
            Node current = root;

            for (char c : word.toCharArray()) {
                Node next = current.children.get(c);
                if (next == null) return false;

                current = next;
            }

            return current.isTerminal;
        }

        public boolean startsWith(String prefix) {
            Node current = root;

            for (char c : prefix.toCharArray()) {
                Node next = current.children.get(c);
                if (next == null) return false;

                current = next;
            }

            return true;
        }

        private static class Node {

            private final Map<Character, Node> children = new HashMap<>();
            private boolean isTerminal;
        }
    }
}
