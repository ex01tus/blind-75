package w1;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: https://leetcode.com/problems/linked-list-cycle
 * Difficulty: Easy
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) return true;
        }

        return false;
    }

    public boolean hasCycleWithExcessiveMemoryUsage(ListNode head) {
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
