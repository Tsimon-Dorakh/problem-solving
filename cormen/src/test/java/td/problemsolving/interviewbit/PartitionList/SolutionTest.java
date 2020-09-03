package td.problemsolving.interviewbit.PartitionList;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void partition() {
        Solution.ListNode input;
        Solution.ListNode expected;

        input = createList(ImmutableList.of(1, 4, 3, 2, 5, 2));
        expected = createList(ImmutableList.of(1, 2, 2, 4, 3, 5));
        assertEquals(expected, new Solution().partition(input, 3));

        input = createList(ImmutableList.of(1, 4, 3, 2, 5, 2));
        expected = createList(ImmutableList.of(1, 4, 3, 2, 5, 2));
        assertEquals(expected, new Solution().partition(input, 0));

        input = createList(ImmutableList.of(1, 4, 3, 2, 5, 2));
        expected = createList(ImmutableList.of(1, 4, 3, 2, 5, 2));
        assertEquals(expected, new Solution().partition(input, 6));
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
