package td.problemsolving.interviewbit.PalindromeList;

import java.util.Objects;

/**
 * Palindrome List
 * https://www.interviewbit.com/problems/palindrome-list/
 */
public class Solution {
    public int lPalin(ListNode a) {
        return O1SpaceSolution(a);
    }

    int O1SpaceSolution(ListNode a) {
        int len_a = length(a);
        int mid_pos = (int) Math.ceil(len_a / 2.);
        ListNode mid = a;

        for (int i = 0; i < mid_pos; i++) mid = mid.next;

        mid = reverse(mid);

        for (int i = 0; i < len_a / 2; i++) {
            if (a.val != mid.val) return 0;
            a = a.next;
            mid = mid.next;
        }

        return 1;
    }

    ListNode reverse(ListNode a) {
        ListNode prev = null;
        ListNode curr = a;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    int OnSpaceSolution(ListNode a) {
        int[] xs = new int[length(a)];

        for (int i = 0; i < xs.length; i++) {
            xs[i] = a.val;
            a = a.next;
        }

        for (int i = 0; i < (xs.length + 1) / 2; i++) {
            if (xs[i] != xs[xs.length - 1 - i]) return 0;
        }

        return 1;
    }

    int length(ListNode a) {
        int len = 0;

        while (a != null) {
            len++;
            a = a.next;
        }

        return len;
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
