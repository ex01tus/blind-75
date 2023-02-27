package linked_list;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: https://leetcode.com/problems/merge-k-sorted-lists
 * Difficulty: Hard
 * Time complexity: O(nlog k)
 * Space complexity: O(k)
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap = buildMinHeapOfRoots(lists);

        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (!minHeap.isEmpty()) {
            ListNode root = minHeap.poll();
            if (root.next != null) { // add the new root of the list to the heap
                minHeap.offer(root.next);
            }

            current.next = root;
            current = current.next;
        }

        return dummy.next;
    }

    private Queue<ListNode> buildMinHeapOfRoots(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.val, n2.val));
        for (ListNode root : lists) {
            if (root != null) {
                minHeap.offer(root);
            }
        }

        return minHeap;
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
