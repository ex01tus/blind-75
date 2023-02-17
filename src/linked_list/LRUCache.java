package linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/lru-cache
 * Difficulty: Medium
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
public class LRUCache {

    private static class CustomLRUCache {

        private final Map<Integer, Node> nodeMap;
        private final NodeList nodeList;
        private final int capacity;

        public CustomLRUCache(int capacity) {
            this.nodeMap = new HashMap<>();
            this.nodeList = new NodeList();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!nodeMap.containsKey(key)) return -1;

            Node node = nodeMap.get(key);
            nodeList.moveToHead(node);

            return node.val;
        }

        public void put(int key, int value) {
            if (nodeMap.containsKey(key)) {
                update(key, value);
                return;
            }

            if (nodeMap.size() == capacity) {
                removeLeastRecentlyUsed();
            }

            Node added = new Node(key, value);
            nodeMap.put(key, added);
            nodeList.addToHead(added);
        }

        private void update(int key, int value) {
            Node updated = nodeMap.get(key);
            updated.val = value;
            nodeList.moveToHead(updated);
        }

        private void removeLeastRecentlyUsed() {
            Node removed = nodeList.removeTail();
            nodeMap.remove(removed.key);
        }

        private static class NodeList {

            private final Node dummyHead;
            private final Node dummyTail;

            public NodeList() {
                this.dummyHead = new Node(0, 0);
                this.dummyTail = new Node(0, 0);
                dummyHead.next = dummyTail;
                dummyTail.prev = dummyHead;
            }

            public void addToHead(Node added) {
                Node next = dummyHead.next;
                dummyHead.next = added;
                added.prev = dummyHead;
                added.next = next;
                next.prev = added;
            }

            public void moveToHead(Node moved) {
                remove(moved);
                addToHead(moved);
            }

            public Node removeTail() {
                return remove(dummyTail.prev);
            }

            private Node remove(Node removed) {
                removed.prev.next = removed.next;
                removed.next.prev = removed.prev;

                return removed;
            }
        }

        private static class Node {

            private final int key;
            private int val;
            private Node prev;
            private Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

    public static void main(String[] args) {
        CustomLRUCache cache = new CustomLRUCache(2);

        cache.put(1, 1);                  // {1=1}
        cache.put(2, 2);                  // {2=2, 1=1}
        System.out.println(cache.get(1)); // 1
        cache.put(3, 3);                  // {3=3, 1=1}, 2 was LRU and was evicted
        System.out.println(cache.get(2)); // -1
        cache.put(4, 4);                  // {4=4, 3=3}, 1 was LRU and was evicted
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}
