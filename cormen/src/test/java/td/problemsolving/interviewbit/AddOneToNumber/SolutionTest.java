package td.problemsolving.interviewbit.AddOneToNumber;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class SolutionTest {
    @Test
    void plusOne() {
        assertEquals(
                ImmutableList.of(1, 2, 4),
                new Solution().plusOne(toArrayList(ImmutableList.of(1, 2, 3)))
        );
        assertEquals(
                ImmutableList.of(1, 2, 4),
                new Solution().plusOne(toArrayList(ImmutableList.of(0, 1, 2, 3)))
        );
        assertEquals(
                ImmutableList.of(1, 2, 4),
                new Solution().plusOne(toArrayList(ImmutableList.of(0, 0, 1, 2, 3)))
        );
        assertEquals(
                ImmutableList.of(1, 0, 0, 0),
                new Solution().plusOne(toArrayList(ImmutableList.of(0, 0, 9, 9, 9)))
        );
    }

    private ArrayList<Integer> toArrayList(List<Integer> xs) {
        return new ArrayList<>(xs);
    }
}
