package td.problemsolving.interviewbit.KReverseLinkedList;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


class SolutionTest {

    @Test
    void reverseList() {
        Solution.ListNode input;
        Solution.ListNode expected;

        input = createList(ImmutableList.of(1, 2, 3, 4, 5, 6));
        expected = createList(ImmutableList.of(2, 1, 4, 3, 6, 5));
        assertEquals(expected, new Solution().reverseList(input, 2));

        input = createList(ImmutableList.of(1, 2, 3, 4, 5));
        expected = createList(ImmutableList.of(2, 1, 4, 3, 5));
        assertEquals(expected, new Solution().reverseList(input, 2));

        input = createList(ImmutableList.of(1, 2, 3, 4, 5));
        expected = createList(ImmutableList.of(3, 2, 1, 5, 4));
        assertEquals(expected, new Solution().reverseList(input, 3));

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
