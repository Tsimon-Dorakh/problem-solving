package td.problemsolving.interviewbit.AddTwoNumbersAsLists;

import java.util.Objects;

/**
 * Add Two Numbers as Lists
 * https://www.interviewbit.com/problems/add-two-numbers-as-lists/
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        int curry = 0;
        ListNode head = null;
        ListNode tail = null;

        while (a != null || b != null) {
            int sum = curry;
            if (a != null) sum += a.val;
            if (b != null) sum += b.val;

            curry = sum / 10;
            sum = sum % 10;

            if (tail == null) {
                tail = new ListNode(sum);
                head = tail;
            }
            else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }

            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }

        if (curry > 0) {
            tail.next = new ListNode(curry);
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
