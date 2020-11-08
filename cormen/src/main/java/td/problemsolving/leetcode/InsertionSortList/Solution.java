package td.problemsolving.leetcode.InsertionSortList;

import td.problemsolving.leetcode.common.ListNode;

/**
 * 147. Insertion Sort List
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class Solution {
    public ListNode insertionSortList(ListNode curr) {
        ListNode dummy = new ListNode(0);
        ListNode prev, next;

        while (curr != null) {
            prev = dummy;
            next = dummy.next;

            while (next != null && next.val <= curr.val) {
                prev = next;
                next = prev.next;
            }

            ListNode nextIter = curr.next;

            prev.next = curr;
            curr.next = next;

            curr = nextIter;
        }

        return dummy.next;
    }
}
