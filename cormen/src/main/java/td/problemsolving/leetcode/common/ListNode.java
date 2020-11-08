package td.problemsolving.leetcode.common;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
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
        StringBuilder r = new StringBuilder(String.valueOf(val));
        ListNode next = this.next;

        while (next != null) {
            r.append(" ");
            r.append(next.val);
            next = next.next;
        }

        return r.toString();
    }

    public static ListNode create(int[] xs) {
        return create(xs, 0);
    }

    static ListNode create(int[] xs, int i) {
        if (i >= xs.length) return null;

        ListNode head = new ListNode(xs[i]);
        head.next = create(xs, i + 1);

        return head;
    }
}
