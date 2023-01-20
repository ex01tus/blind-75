package linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/linked-list-cycle
 * Difficulty: Easy
 */
public class LinkedListCycle {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean hasCycleViaTwoPointers(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) return true;
        }

        return false;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public boolean hasCycleWithMemoization(ListNode head) {
        Set<ListNode> seen = new HashSet<>();

        while (head != null) {
            if (seen.contains(head)) return true;
            seen.add(head);
            head = head.next;
        }

        return false;
    }

    private static class ListNode {
        ListNode next;
    }
}
