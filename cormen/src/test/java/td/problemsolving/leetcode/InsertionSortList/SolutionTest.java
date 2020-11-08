package td.problemsolving.leetcode.InsertionSortList;

import org.junit.jupiter.api.Test;
import td.problemsolving.leetcode.common.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void insertionSortList() {
        ListNode head;
        ListNode expected;

        head = ListNode.create(new int[]{});
        expected = ListNode.create(new int[]{});
        assertEquals(expected, new Solution().insertionSortList(head));

        head = ListNode.create(new int[]{4, 2, 1, 3});
        expected = ListNode.create(new int[]{1, 2, 3, 4});
        assertEquals(expected, new Solution().insertionSortList(head));
    }
}
