package td.problemsolving.interviewbit.Subtract;

import java.util.Objects;

/**
 * SUBTRACT
 * https://www.interviewbit.com/problems/subtract/
 */
public class Solution {
    public ListNode subtract(ListNode a) {
        return OnSolution(a);
    }

    ListNode OnSolution(ListNode a) {
        int length = length(a);
        ListNode mid = getItem(a, (length + 1) / 2);
        int k = length / 2;
        a = rotate(a, k);
        ListNode l = a;

        for (int i = 0; i < k; i++) {
            l.val = mid.val - l.val;
            l = l.next;
            mid = mid.next;
        }

        return rotate(a, k);
    }

    ListNode rotate(ListNode a, int k) {
        if (k == 0) return a;

        ListNode prev = null;
        ListNode curr = a;
        ListNode next = null;

        while (curr != null && k > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        a.next = next;

        return prev;
    }

    ListNode On2Solution(ListNode a) {
        int length = length(a);

        for (int i = 0; i < length / 2; i++) {
            getItem(a, i).val = getItem(a, length - 1 - i).val - getItem(a, i).val;
        }

        return a;
    }

    int length(ListNode a) {
        int length = 0;

        while (a != null) {
            length++;
            a = a.next;
        }

        return length;
    }

    ListNode getItem(ListNode a, int i) {
        while (i-- > 0) {
            a = a.next;
        }

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
