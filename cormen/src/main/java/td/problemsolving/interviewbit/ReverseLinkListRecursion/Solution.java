package td.problemsolving.interviewbit.ReverseLinkListRecursion;

import java.util.Objects;

/**
 * Reverse Link List Recursion
 * https://www.interviewbit.com/problems/reverse-link-list-recursion/
 */
public class Solution {
    public ListNode reverseList(ListNode a) {
        return reverseListRecursion2(a);
    }

    public ListNode reverseListRecursion(ListNode prev, ListNode curr) {
        if (curr == null) return prev;

        ListNode next = curr.next;
        curr.next = prev;

        return reverseListRecursion(curr, next);
    }

    public ListNode reverseListRecursion2(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }

        ListNode head = reverseListRecursion2(a.next);
        a.next.next = a;
        a.next = null;

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
