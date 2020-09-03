package td.problemsolving.interviewbit.ReverseLinkListII;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void reverseBetween() {
        Solution.ListNode input;
        Solution.ListNode expected;

        input = createList(ImmutableList.of(1, 2, 3, 4, 5));
        expected = createList(ImmutableList.of(1, 4, 3, 2, 5));
        assertEquals(expected, new Solution().reverseBetween(input, 2, 4));

        input = createList(ImmutableList.of(1, 2, 3, 4, 5));
        expected = createList(ImmutableList.of(1, 5, 4, 3, 2));
        assertEquals(expected, new Solution().reverseBetween(input, 2, 5));

        input = createList(ImmutableList.of(1, 2, 3, 4, 5));
        expected = createList(ImmutableList.of(5, 4, 3, 2, 1));
        assertEquals(expected, new Solution().reverseBetween(input, 1, 5));
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
