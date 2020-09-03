package td.problemsolving.interviewbit.ReverseLinkListII;

import java.util.Objects;

/**
 * Reverse Link List II
 * https://www.interviewbit.com/problems/reverse-link-list-ii/
 */
public class Solution {
    public ListNode reverseBetween(ListNode a, int n, int m) {
        return recursive(a, n, m);
    }

    ListNode recursive(ListNode a, int n, int m) {
        if (n > 1) {
            a.next = recursive(a.next, n - 1, m - 1);

            return a;
        } else {
            int count = 0;

            ListNode prev = null;
            ListNode curr = a;
            ListNode next;
            while (count < m) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;

                count++;
            }

            a.next = curr;

            return prev;
        }
    }

    ListNode iterative(ListNode a, int n, int m) {
        ListNode l = null;
        for (int i = 1; i < n; i++) {
            if (l == null) l = a;
            else l = l.next;
        }

        ListNode last = null;
        ListNode prev = null;
        ListNode curr = l != null ? l.next : a;
        ListNode next;
        int i = m - n;
        while (i >= 0) {
            next = curr.next;
            curr.next = prev;
            if (prev == null) last = curr;
            prev = curr;
            curr = next;

            i--;
        }

        last.next = curr;
        if (l == null) a = prev;
        else l.next = prev;

        return a;
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
