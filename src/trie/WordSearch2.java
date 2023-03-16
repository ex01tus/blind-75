package trie;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/word-search-ii
 * Difficulty: Hard
 * Time complexity: O(m * n * 3^word.length)
 * Space complexity: O(m * n)
 */
public class WordSearch2 {

    private int[][] directions;
    private int[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited = new int[board.length][board[0].length];

        Node trie = buildTrie(words);
        List<String> found = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, trie, found);
            }
        }

        return found;
    }

    private void search(char[][] board, int x, int y, Node parent, List<String> found) {
        Node child = parent.children.get(board[x][y]);
        if (child == null) return;

        if (child.word != null) {
            found.add(child.word);
            child.word = null; // "kill" the word, so that it won't be found by further searches
        }

        visited[x][y] = 1;
        for (int[] dir : directions) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];

            if (x1 >= 0 && x1 < board.length && y1 >= 0 && y1 < board[0].length
                    && visited[x1][y1] == 0) {
                search(board, x1, y1, child, found);
            }
        }
        visited[x][y] = 0;

        // optional optimization: recursively remove leaf nodes from the trie
        if (child.children.isEmpty()) {
            parent.children.remove(board[x][y]);
        }
    }

    private Node buildTrie(String[] words) {
        Node root = new Node();
        for (String word : words) {
            Node current = root;
            for (char c : word.toCharArray()) {
                Node child = current.children.computeIfAbsent(c, __ -> new Node());
                current = child;
            }
            current.word = word;
        }

        return root;
    }

    private static class Node {
        private final Map<Character, Node> children = new HashMap<>();
        private String word; // if != null -> terminal node
    }
}
