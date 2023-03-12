package linked_list;

/**
 * Description: https://leetcode.com/problems/linked-list-cycle-ii
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class LinkedListCycle2 {

    public ListNode detectCycleViaFloydAlgo(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode intersection = findIntersection(head);
        if (intersection == null) return null; // no cycle

        return findCycleStart(head, intersection);
    }

    private ListNode findIntersection(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return slow;
        }

        return null;
    }

    private ListNode findCycleStart(ListNode head, ListNode intersection) {
        ListNode slow = head;
        while (slow != intersection) {
            slow = slow.next;
            intersection = intersection.next;
        }

        return slow;
    }

    /*
    1) slow * 2 = fast
       slow = p + (C - x)
       fast = p + C + (C - x)
    2) 2p + 2C - 2x = p + 2C - x
       p = x

       p – distance before intersection
       C – length of the cycle
       x – distance between intersection and cycle start
     */

    private static class ListNode {
        ListNode next;
    }
}
