package td.problemsolving.interviewbit.RotatedSortedArraySearch;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void search() {
        List<Integer> input;

        input = ImmutableList.of(4, 5, 6, 7, 0, 1, 2, 3);
        assertEquals(0, new Solution().search(input, 4));

        input = ImmutableList.of(0, 1, 2, 3);
        assertEquals(2, new Solution().search(input, 2));

        input = ImmutableList.of(0, 1, 2, 3);
        assertEquals(-1, new Solution().search(input, 4));
    }
}
