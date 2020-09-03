package td.problemsolving.interviewbit.IntersectionOfLinkedLists;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void getIntersectionNode() {
        Solution.ListNode a1 = new Solution.ListNode(1);
        Solution.ListNode a2 = new Solution.ListNode(2);
        Solution.ListNode b1 = new Solution.ListNode(3);
        Solution.ListNode b2 = new Solution.ListNode(4);
        Solution.ListNode b3 = new Solution.ListNode(5);
        Solution.ListNode c1 = new Solution.ListNode(6);
        Solution.ListNode c2 = new Solution.ListNode(7);
        Solution.ListNode c3 = new Solution.ListNode(8);

        a1.next = a2;
        b1.next = b2;
        b2.next = b3;
        a2.next = c1;
        b3.next = c1;
        c1.next = c2;
        c2.next = c3;

        assertEquals(c1, new Solution().getIntersectionNode(a1, b1));
    }

    @Test
    void getIntersectionNode2() {
        Solution.ListNode a = createList(ImmutableList.of(83, 44, 39, 95, 100, 36, 1, 94, 100, 70, 83, 78, 34, 59, 79));
        Solution.ListNode b = createList(ImmutableList.of(35, 97, 71, 32, 13, 11, 12, 15, 36, 1, 94, 100, 70, 83, 78, 34, 59, 79));
        Solution.ListNode expected = createList(ImmutableList.of(36, 1, 94, 100, 70, 83, 78, 34, 59, 79));

        assertEquals(expected, new Solution().getIntersectionNode(a, b));
    }

    Solution.ListNode createList(List<Integer> xs) {
        Solution.ListNode head = null;
        Solution.ListNode last = null;

        for (Integer x : xs) {
            if (last == null) {
                last = new Solution.ListNode(x);
                head = last;
            } else {
                last.next = new Solution.ListNode(x);
                last = last.next;
            }
        }

        return head;
    }

}
