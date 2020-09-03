package td.problemsolving.interviewbit.KReverseLinkedList;

import java.util.Objects;

/**
 * K reverse linked list
 * https://www.interviewbit.com/problems/k-reverse-linked-list/
 */
public class Solution {
    ListNode mainHead;
    ListNode next_head;
    ListNode head;
    ListNode tail;

    public ListNode reverseList(ListNode a, int k) {
        mainHead = reverse(a, k);
        ListNode currentTail = tail;
        currentTail.next = next_head;

        while (next_head != null) {
            reverse(next_head, k);
            currentTail.next = head;
            currentTail = tail;
        }

        return mainHead;
    }

    ListNode reverse(ListNode a, int k) {
        head = null;
        tail = null;

        ListNode prev = null;
        ListNode curr = a;
        ListNode next = null;

        while (curr != null && k != 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            next_head = next;

            if (tail == null) tail = prev;

            k--;
        }

        head = prev;

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

        @Override
        public String toString() {
            String s = String.valueOf(this.val);

            if (this.next != null) {
                s += " -> ";
                s += this.next.toString();
            }

            return s;
        }
    }
}
