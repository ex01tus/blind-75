package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/design-add-and-search-words-data-structure
 * Difficulty: Easy
 * Time complexity: O(n) for add(), O(alphabet^n) for search()
 * Space complexity: O(n)
 */
public class DesignAddAndSearchWordsDataStructure {

    private static class WordDictionary {

        private final Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node current = root;

            for (char c : word.toCharArray()) {
                Node child = current.children.computeIfAbsent(c, __ -> new Node());
                current = child;
            }

            current.isTerminal = true;
        }

        public boolean search(String word) {
            return search(word, 0, root);
        }

        private boolean search(String word, int start, Node current) {
            if (start == word.length()) return current.isTerminal;

            for (int i = start; i < word.length(); i++) {
                char c = word.charAt(i);

                if (c == '.') {
                    for (Node child : current.children.values()) {
                        boolean isFound = search(word, i + 1, child);
                        if (isFound) return true;
                    }

                    return false;
                } else {
                    Node next = current.children.get(c);
                    if (next == null) return false;
                    current = next;
                }

            }

            return current.isTerminal;
        }

        private static class Node {

            private final Map<Character, Node> children = new HashMap<>();
            private boolean isTerminal;
        }
    }
}
