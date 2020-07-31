package td.problemsolving.leetcode;

import java.util.Objects;

/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/submissions/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers_recursive(l1, l2, 0);
    }

    private ListNode addTwoNumbers_recursive_inPlace(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return carry > 0 ? new ListNode(carry) : null;
        }

        int x = l1 != null ? l1.val : 0;
        int y = l2 != null ? l2.val : 0;
        int sum = x + y + carry;

        ListNode node = l1 != null ? l1 : l2;
        node.val = sum % 10;

        l1 = l1 != null ? l1.next : null;
        l2 = l2 != null ? l2.next : null;

        node.next = addTwoNumbers_recursive_inPlace(l1, l2, sum / 10);

        return node;
    }

    private ListNode addTwoNumbers_recursive(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return carry > 0 ? new ListNode(carry) : null;
        }

        int x = l1 != null ? l1.val : 0;
        int y = l2 != null ? l2.val : 0;
        int sum = x + y + carry;

        l1 = l1 != null ? l1.next : null;
        l2 = l2 != null ? l2.next : null;

        ListNode result = new ListNode(sum % 10);
        result.next = addTwoNumbers_recursive(l1, l2, sum / 10);

        return result;
    }

    private ListNode addTwoNumbers_iterative_inPlace(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode tail = l1;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            carry = sum / 10;
            tail.val = sum % 10;

            if (l1 != null || l2 != null) {
                tail.next = new ListNode();
                tail = tail.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }

    private ListNode addTwoNumbers_iterative(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
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

        public static void print(ListNode listNode) {
            System.out.print(listNode.val);

            if (listNode.next != null) {
                System.out.print(" -> ");
                print(listNode.next);
            } else {
                System.out.println();
            }
        }

        public static ListNode createListNode(int[] xs) {
            ListNode head = new ListNode();
            ListNode tail = head;
            tail.val = xs[0];

            for (int i = 1; i < xs.length; i++) {
                tail.next = new ListNode();
                tail = tail.next;
                tail.val = xs[i];
            }

            return head;
        }
    }


}
