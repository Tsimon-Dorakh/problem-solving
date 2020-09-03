package td.problemsolving.interviewbit.ReverseLinkedList;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void reverseList() {
        Solution.ListNode input;
        Solution.ListNode expected;

        input = createList(ImmutableList.of(1, 2, 3, 4, 5));
        expected = createList(ImmutableList.of(5, 4, 3, 2, 1));
        assertEquals(expected, new Solution().reverseList(input));

        input = createList(ImmutableList.of());
        expected = createList(ImmutableList.of());
        assertEquals(expected, new Solution().reverseList(input));

        input = createList(ImmutableList.of(1));
        expected = createList(ImmutableList.of(1));
        assertEquals(expected, new Solution().reverseList(input));
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
