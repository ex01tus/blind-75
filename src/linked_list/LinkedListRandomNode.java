package linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description: https://leetcode.com/problems/linked-list-random-node
 * Difficulty: Medium
 */
public class LinkedListRandomNode {

    /**
     * Time complexity: O(n) for constructor and O(n) for getRandom()
     * Space complexity: O(1)
     */
    private static class SolutionWithLinearTimeAndConstantSpace {

        private final ListNode head;
        private final int length;
        private final Random random;

        public SolutionWithLinearTimeAndConstantSpace(ListNode head) {
            this.head = head;
            this.length = getLength(head);
            this.random = new Random();
        }

        public int getRandom() {
            int randomIdx = random.nextInt(length);
            ListNode current = head;
            for (int i = 0; i < randomIdx; i++) {
                current = current.next;
            }

            return current.val;
        }

        private int getLength(ListNode head) {
            int length = 0;
            while (head != null) {
                head = head.next;
                length++;
            }

            return length;
        }
    }

    /**
     * Time complexity: O(n) for constructor and O(1) for getRandom()
     * Space complexity: O(n)
     */
    private static class SolutionWithConstantTimeAndLinearSpace {

        private final List<Integer> values;
        private final Random random;

        public SolutionWithConstantTimeAndLinearSpace(ListNode head) {
            this.values = initValues(head);
            this.random = new Random();
        }

        public int getRandom() {
            int idx = random.nextInt(values.size());
            return values.get(idx);
        }

        private List<Integer> initValues(ListNode head) {
            List<Integer> values = new ArrayList<>();
            while (head != null) {
                values.add(head.val);
                head = head.next;
            }

            return values;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
