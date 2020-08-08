package td.problemsolving.interviewbit.WaveArray;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void wave() {
        assertEquals(
                new ArrayList<>(ImmutableList.of(2, 1, 4, 3, 5)),
                new Solution().wave(new ArrayList<>(ImmutableList.of(1, 2, 3, 4, 5)))
        );
        assertEquals(
                new ArrayList<>(ImmutableList.of(2, 1, 4, 3, 6, 5)),
                new Solution().wave(new ArrayList<>(ImmutableList.of(1, 2, 3, 4, 5, 6)))
        );
        assertEquals(
                new ArrayList<>(ImmutableList.of(2, 1, 4, 3)),
                new Solution().wave(new ArrayList<>(ImmutableList.of(1, 2, 3, 4)))
        );
    }
}
