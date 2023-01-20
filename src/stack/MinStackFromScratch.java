package stack;

/**
 * Description: https://leetcode.com/problems/min-stack
 * Difficulty: Medium
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
class MinStackFromScratch {

    private Node head;

    public void push(int val) {
        if (head == null) {
            head = new Node(val, null, val);
        } else {
            head = new Node(val, head, Math.min(val, head.min));
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private static class Node {
        int val;
        Node next;
        int min;

        public Node(int v, Node n, int m) {
            val = v;
            next = n;
            min = m;
        }
    }
}