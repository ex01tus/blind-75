package linked_list;

/**
 * Description: https://leetcode.com/problems/design-linked-list
 * Difficulty: Medium
 * Time complexity: O(1) for addAtHead() and addAtTail(), O(n) for get(), addAtIndex() and deleteAtIndex()
 * Space complexity: O(n)
 */
public class DesignLinkedList {

    private static class MyLinkedList {

        private final Node dummyHead;
        private final Node dummyTail;
        private int length;

        public MyLinkedList() {
            this.dummyHead = new Node(-1);
            this.dummyTail = new Node(-1);
            this.length = 0;

            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        public int get(int index) {
            if (index < 0 || index >= length) return -1;

            // can be optimised by searching from the tail for indices in the second half of the list
            Node current = dummyHead.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current.val;
        }

        public void addAtHead(int val) {
            length++;
            Node added = new Node(val);
            Node next = dummyHead.next;
            dummyHead.next = added;
            added.prev = dummyHead;
            added.next = next;
            next.prev = added;
        }

        public void addAtTail(int val) {
            length++;
            Node added = new Node(val);
            Node prev = dummyTail.prev;
            dummyTail.prev = added;
            added.next = dummyTail;
            added.prev = prev;
            prev.next = added;
        }

        public void addAtIndex(int index, int val) {
            if (index > length) return;

            // weird test case treats negative indices as zero
            if (index <= 0) {
                addAtHead(val);
                return;
            }

            if (index == length) {
                addAtTail(val);
                return;
            }

            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }

            length++;
            Node added = new Node(val);
            Node next = prev.next;
            prev.next = added;
            added.prev = prev;
            added.next = next;
            next.prev = added;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= length) return;

            length--;
            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }

            Node deleted = prev.next;
            prev.next = deleted.next;
            deleted.next.prev = prev;
        }

        private static class Node {

            private final int val;
            private Node next;
            private Node prev;

            public Node(int val) {
                this.val = val;
            }
        }
    }
}
