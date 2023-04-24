package design;

/**
 * Description: https://leetcode.com/problems/design-hashmap
 * Difficulty: Easy
 * Time complexity: O(keys / buckets)
 * Space complexity: O(keys + buckets)
 */
public class DesignHashMap {

    private static class MyHashMap {

        private static final int DEFAULT_SIZE = 10_000;

        private final Bucket[] buckets;

        public MyHashMap() {
            this.buckets = new Bucket[DEFAULT_SIZE];
            for (int i = 0; i < DEFAULT_SIZE; i++) {
                buckets[i] = new Bucket();
            }
        }

        public void put(int key, int value) {
            getBucket(key).update(key, value);
        }

        public int get(int key) {
            return getBucket(key).find(key);
        }

        public void remove(int key) {
            getBucket(key).remove(key);
        }

        private Bucket getBucket(int key) {
            return buckets[key % buckets.length];
        }

        private static class Bucket {

            private final ListNode dummyHead;

            public Bucket() {
                this.dummyHead = new ListNode(-1, -1);
            }

            public int find(int key) {
                ListNode current = dummyHead.next;
                while (current != null) {
                    if (current.key == key) return current.val;
                    current = current.next;
                }

                return -1;
            }

            public void update(int key, int val) {
                ListNode current = dummyHead.next;
                ListNode prev = dummyHead;

                while (current != null) {
                    if (current.key == key) {
                        current.val = val;
                        return;
                    }

                    prev = current;
                    current = current.next;
                }

                prev.next = new ListNode(key, val);
            }

            public void remove(int key) {
                ListNode current = dummyHead.next;
                ListNode prev = dummyHead;
                while (current != null) {
                    if (current.key == key) {
                        prev.next = prev.next.next;
                        return;
                    }

                    prev = current;
                    current = current.next;
                }
            }
        }

        private static class ListNode {

            private final int key;
            private int val;
            private ListNode next;

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
