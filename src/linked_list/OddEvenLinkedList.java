package linked_list;

/**
 * Description: https://leetcode.com/problems/odd-even-linked-list
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;

        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    private static class ListNode {
        ListNode next;
    }
}
