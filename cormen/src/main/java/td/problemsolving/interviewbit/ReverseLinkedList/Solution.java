package td.problemsolving.interviewbit.ReverseLinkedList;

import java.util.Objects;

/**
 * Reverse Linked List
 * https://www.interviewbit.com/problems/reverse-linked-list/
 */
public class Solution {
    public ListNode reverseList(ListNode a) {
        ListNode head = null;

        while (a != null) {
            ListNode node = new ListNode(a.val);
            node.next = head;
            head = node;

            a = a.next;
        }

        return head;
    }

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val &&
                    Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}
