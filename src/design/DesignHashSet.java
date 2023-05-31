package design;

/**
 * Description: https://leetcode.com/problems/design-hashset
 * Difficulty: Easy
 * Time complexity: O(keys / buckets)
 * Space complexity: O(keys + buckets)
 */
public class DesignHashSet {

    private static class MyHashSet {

        private static final int DEFAULT_SIZE = 10_000;

        private final Bucket[] buckets;

        public MyHashSet() {
            this.buckets = new Bucket[DEFAULT_SIZE];
            for (int i = 0; i < DEFAULT_SIZE; i++) {
                buckets[i] = new Bucket();
            }
        }

        public void add(int key) {
            Bucket bucket = getBucket(key);
            if (bucket.contains(key)) return;

            bucket.addToTail(new ListNode(key));
        }

        public void remove(int key) {
            getBucket(key).remove(key);
        }

        public boolean contains(int key) {
            return getBucket(key).contains(key);
        }

        private Bucket getBucket(int key) {
            return buckets[key % buckets.length];
        }

        private static class Bucket {

            private final ListNode dummyHead;
            private final ListNode dummyTail;

            public Bucket() {
                dummyHead = new ListNode(-1);
                dummyTail = new ListNode(-1);
                dummyHead.next = dummyTail;
                dummyTail.prev = dummyHead;
            }

            public void addToTail(ListNode added) {
                ListNode prev = dummyTail.prev;
                prev.next = added;
                added.next = dummyTail;
                added.prev = prev;
                dummyTail.prev = added;
            }

            public void remove(int key) {
                ListNode found = find(key);
                if (found != null) remove(found);
            }

            public boolean contains(int key) {
                return find(key) != null;
            }

            private ListNode find(int key) {
                ListNode current = dummyHead.next;
                while (current != null) {
                    if (current.key == key) return current;
                    current = current.next;
                }

                return null;
            }

            private void remove(ListNode removed) {
                removed.prev.next = removed.next;
                removed.next.prev = removed.prev;
            }
        }

        private static class ListNode {

            private final int key;
            private ListNode next;
            private ListNode prev;

            public ListNode(int key) {
                this.key = key;
            }
        }
    }


}
