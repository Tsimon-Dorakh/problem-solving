package td.problemsolving.interviewbit.AddTwoNumbersAsLists;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void addTwoNumbers() {
        Solution.ListNode a;
        Solution.ListNode b;
        Solution.ListNode expected;

        a = createList(ImmutableList.of(2, 4, 3));
        b = createList(ImmutableList.of(5, 6, 4));
        expected = createList(ImmutableList.of(7, 0, 8));
        assertEquals(expected, new Solution().addTwoNumbers(a, b));

        a = createList(ImmutableList.of(9, 9, 9));
        b = createList(ImmutableList.of(2));
        expected = createList(ImmutableList.of(1, 0, 0, 1));
        assertEquals(expected, new Solution().addTwoNumbers(a, b));
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
