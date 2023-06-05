package trie;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/search-suggestions-system
 * Difficulty: Medium
 */
public class SearchSuggestionsSystem {

    private static final int SUGGESTIONS_SIZE_LIMIT = 3;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node trie = buildTrie(products);

        List<List<String>> suggestions = new ArrayList<>();
        boolean noMoreSuggestions = false;
        for (char c : searchWord.toCharArray()) {
            Node child = trie.children.get(c);
            if (child == null) noMoreSuggestions = true;

            if (noMoreSuggestions) {
                suggestions.add(List.of());
            } else {
                suggestions.add(child.suggestions);
                trie = child;
            }
        }

        return suggestions;
    }

    private Node buildTrie(String[] products) {
        Arrays.sort(products);

        Node root = new Node();
        for (String product : products) {
            Node current = root;
            for (char c : product.toCharArray()) {
                Node child = current.children.computeIfAbsent(c, __ -> new Node());
                child.addSuggestion(product);
                current = child;
            }
        }

        return root;
    }

    private static class Node {

        private final Map<Character, Node> children;
        private final List<String> suggestions;

        public Node() {
            this.children = new HashMap<>();
            this.suggestions = new ArrayList<>();
        }

        public void addSuggestion(String product) {
            if (suggestions.size() < SUGGESTIONS_SIZE_LIMIT) {
                suggestions.add(product);
            }
        }
    }
}
