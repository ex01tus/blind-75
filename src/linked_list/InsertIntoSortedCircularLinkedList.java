package linked_list;

/**
 * Description: https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class InsertIntoSortedCircularLinkedList {

    public Node insert(Node head, int insertVal) {
        if (head == null) return createCircularList(insertVal);

        Node current = findInsertionPosition(head, insertVal);
        Node next = current.next;
        Node inserted = new Node(insertVal);
        current.next = inserted;
        inserted.next = next;

        return head;
    }

    private Node findInsertionPosition(Node head, int insertVal) {
        Node current = head;

        while (current.next != head) {
            if (current.val <= current.next.val) {
                if (current.val <= insertVal && current.next.val >= insertVal) break;
            } else {
                if (current.val <= insertVal || current.next.val >= insertVal) break;
            }

            current = current.next;
        }

        return current;
    }

    private Node createCircularList(int insertVal) {
        Node head = new Node(insertVal);
        head.next = head;

        return head;
    }

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
