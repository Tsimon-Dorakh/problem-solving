package td.problemsolving.interviewbit.IntersectionOfLinkedLists;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Intersection of Linked Lists
 * https://www.interviewbit.com/problems/intersection-of-linked-lists/
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        return O1SpaceSolution(a, b);
    }

    ListNode O1SpaceSolution(ListNode a, ListNode b) {
        if (length(a) < length(b)) {
            ListNode tmp = a;
            a = b;
            b = tmp;
        }

        int diff = length(a) - length(b);
        for (int i = 0; i < diff; i++) a = a.next;

        while (a != null && b != null) {
            if (a.equals(b)) return a;

            a = a.next;
            b = b.next;
        }

        return a;
    }

    int length(ListNode h) {
        int len = 0;

        while (h != null) {
            len++;
            h = h.next;
        }

        return len;
    }

    ListNode OnSpaceSolution(ListNode a, ListNode b) {
        Set<ListNode> set = new HashSet<>();

        ListNode h = a;
        while (h != null) {
            set.add(h);

            h = h.next;
        }

        h = b;
        while (h != null) {
            if (set.contains(h)) {
                return h;
            }

            h = h.next;
        }

        return null;
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
