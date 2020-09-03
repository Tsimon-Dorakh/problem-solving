package td.problemsolving.interviewbit.PartitionList;

import java.util.Objects;

/**
 * Partition List
 * https://www.interviewbit.com/problems/partition-list/
 */
public class Solution {
    public ListNode partition(ListNode a, int x) {
        ListNode l_h = null, l_t = null;
        ListNode r_h = null, r_t = null;

        while (a != null) {
            if (a.val < x) {
                if (l_t != null) {
                    l_t.next = a;
                }
                if (l_h == null) l_h = a;

                l_t = a;
            } else {
                if (r_t != null) {
                    r_t.next = a;
                }
                if (r_h == null) r_h = a;

                r_t = a;
            }

            a = a.next;
        }

        if (l_h == null) return r_h;
        if (r_t != null) r_t.next = null;
        l_t.next = r_h;

        return l_h;
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
