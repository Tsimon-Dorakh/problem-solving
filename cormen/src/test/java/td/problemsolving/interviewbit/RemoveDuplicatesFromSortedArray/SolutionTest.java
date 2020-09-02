package td.problemsolving.interviewbit.RemoveDuplicatesFromSortedArray;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void removeDuplicates() {
        ArrayList<Integer> xs;
        ArrayList<Integer> expected;

        xs = new ArrayList<>(ImmutableList.of(5000, 5000, 5000));
        expected = new ArrayList<>(ImmutableList.of(5000));
        assertEquals(1, new Solution().removeDuplicates(xs));
        assertEquals(expected, xs);

        xs = new ArrayList<>(ImmutableList.of(1, 1, 2));
        expected = new ArrayList<>(ImmutableList.of(1, 2));
        assertEquals(2, new Solution().removeDuplicates(xs));
        assertEquals(expected, xs);

    }
}
