package design;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: https://leetcode.com/problems/lfu-cache
 * Difficulty: Hard
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
public class LFUCache {

    private static class CustomLFUCache {

        private final Map<Integer, Node> nodeMap;
        private final Map<Integer, NodeList> frequencyMap; // nodes in each bucket are sorted by the use recency
        private final int capacity;
        private int currentMinFrequency;

        public CustomLFUCache(int capacity) {
            this.nodeMap = new HashMap<>();
            this.frequencyMap = new HashMap<>();
            this.capacity = capacity;
            this.currentMinFrequency = 1;
        }

        public int get(int key) {
            if (!nodeMap.containsKey(key)) return -1;

            Node found = nodeMap.get(key);
            updateFrequency(found);

            return found.val;
        }

        public void put(int key, int value) {
            if (nodeMap.containsKey(key)) {
                update(key, value);
                return;
            }

            if (nodeMap.size() == capacity) {
                removeLeastFrequentlyUsed();
            }

            currentMinFrequency = 1;
            Node added = new Node(key, value);
            nodeMap.put(key, added);
            frequencyMap.computeIfAbsent(1, __ -> new NodeList()).addToHead(added);
        }

        private void update(int key, int val) {
            Node updated = nodeMap.get(key);
            updated.val = val;
            updateFrequency(updated);
        }

        private void removeLeastFrequentlyUsed() {
            NodeList bucket = frequencyMap.get(currentMinFrequency); // get bucket with the least frequently used nodes
            Node removed = bucket.removeTail(); // remove the least recently used node in the bucket
            nodeMap.remove(removed.key);
            if (bucket.isEmpty()) frequencyMap.remove(removed.frequency);
        }

        private void updateFrequency(Node touched) {
            NodeList outdated = frequencyMap.get(touched.frequency);
            outdated.remove(touched);

            // no more nodes with such frequency
            if (outdated.isEmpty()) {
                frequencyMap.remove(touched.frequency);
                // if we removed the last node with min frequency, new min frequency is equal to the currently updated one
                if (touched.frequency == currentMinFrequency) currentMinFrequency++;
            }

            touched.frequency++;
            frequencyMap.computeIfAbsent(touched.frequency, __ -> new NodeList()).addToHead(touched);
        }
    }

    private static class NodeList {

        private final Node dummyHead;
        private final Node dummyTail;
        private int size;

        public NodeList() {
            this.dummyHead = new Node(0, 0);
            this.dummyTail = new Node(0, 0);
            this.size = 0;
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        public void addToHead(Node added) {
            size++;

            Node next = dummyHead.next;
            dummyHead.next = added;
            added.prev = dummyHead;
            added.next = next;
            next.prev = added;
        }

        public Node remove(Node removed) {
            size--;

            removed.prev.next = removed.next;
            removed.next.prev = removed.prev;

            return removed;
        }

        public Node removeTail() {
            return remove(dummyTail.prev);
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    private static class Node {

        private final int key;
        private int val;
        private int frequency;
        private Node next;
        private Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    public static void main(String[] args) {
        CustomLFUCache cache = new CustomLFUCache(2);

        cache.put(1, 1);                  // {1=1}
        cache.put(2, 2);                  // {2=2, 1=1}
        System.out.println(cache.get(1)); // 1, cnt(1) = 2, cnt(2) = 1
        cache.put(3, 3);                  // {3=3, 1=1}, 2 was LFU and was evicted
        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 3, cnt(3) = 2, cnt(1) = 2
        cache.put(4, 4);                  // {4=4, 3=3}, 1 and 3 are both LFU, but 1 is LRU and was evicted
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3, cnt(3) = 3, cnt(4) = 1
        System.out.println(cache.get(4)); // 4, cnt(3) = 3, cnt(4) = 2
    }
}
