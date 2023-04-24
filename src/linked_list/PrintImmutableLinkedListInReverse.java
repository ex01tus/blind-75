package linked_list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: https://leetcode.com/problems/print-immutable-linked-list-in-reverse
 * Difficulty: Medium
 */
public class PrintImmutableLinkedListInReverse {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public void printLinkedListInReverseViaStack(ImmutableListNode head) {
        Deque<ImmutableListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.getNext();
        }

        while (!stack.isEmpty()) {
            stack.pop().printValue();
        }
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public void printLinkedListInReverseWithNoExtraSpace(ImmutableListNode head) {
        int length = length(head);
        for (int i = length - 1; i >= 0; i--) {
            printNthNode(head, i);
        }
    }

    private void printNthNode(ImmutableListNode head, int n) {
        while (n != 0) {
            head = head.getNext();
            n--;
        }

        head.printValue();
    }

    private int length(ImmutableListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.getNext();
        }

        return length;
    }

    interface ImmutableListNode {

        void printValue();

        ImmutableListNode getNext();
    }
}
