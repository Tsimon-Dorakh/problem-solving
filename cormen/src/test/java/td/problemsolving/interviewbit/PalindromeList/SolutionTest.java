package td.problemsolving.interviewbit.PalindromeList;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lPalin() {
        Solution.ListNode input;

        input = createList(ImmutableList.of(4, 28, 6, 23, 46, 46, 23, 6, 28, 4));
        assertEquals(1, new Solution().lPalin(input));

        input = createList(ImmutableList.of(3));
        assertEquals(1, new Solution().lPalin(input));

        input = createList(ImmutableList.of(1, 2, 1));
        assertEquals(1, new Solution().lPalin(input));

        input = createList(ImmutableList.of(1, 2, 3));
        assertEquals(0, new Solution().lPalin(input));
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
