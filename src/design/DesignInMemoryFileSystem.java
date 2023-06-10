package design;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/design-in-memory-file-system
 * Difficulty: Hard
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class DesignInMemoryFileSystem {

    private static class FileSystemViaTrie {

        private final Node trie;

        public FileSystemViaTrie() {
            this.trie = new Node();
            trie.children.put("", new Node());
        }

        public List<String> ls(String path) {
            // "/".split("/") returns an empty array
            String[] dirs = path.equals("/") ? new String[]{""} : path.split("/");

            Node found = find(dirs);
            if (found == null) return List.of();

            if (found.isFile) {
                // return file name
                return List.of(dirs[dirs.length - 1]);
            }

            return found.children.keySet().stream()
                    .sorted()
                    .toList();
        }

        public void mkdir(String path) {
            String[] dirs = path.split("/");
            findOrCreate(dirs);
        }

        public void addContentToFile(String filePath, String content) {
            String[] dirs = filePath.split("/");

            Node found = findOrCreate(dirs);
            found.isFile = true;
            found.content.append(content);
        }

        public String readContentFromFile(String filePath) {
            String[] dirs = filePath.split("/");

            Node found = find(dirs);
            if (found == null) return "";

            return found.content.toString();
        }

        private Node find(String[] path) {
            Node current = trie;
            for (String dir : path) {
                Node child = current.children.get(dir);
                if (child == null) return null;
                current = child;
            }

            return current;
        }

        private Node findOrCreate(String[] path) {
            Node current = trie;
            for (String dir : path) {
                Node child = current.children.computeIfAbsent(dir, __ -> new Node());
                current = child;
            }

            return current;
        }

        private static class Node {

            private final Map<String, Node> children;
            private final StringBuilder content;
            private boolean isFile;

            public Node() {
                this.children = new HashMap<>();
                this.content = new StringBuilder();
            }
        }
    }
}
