package td.problemsolving.interviewbit.Flip;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void flip() {
        String s;
        ArrayList<Integer> expected;

        s = "1101010001";
        expected = new ArrayList<>(ImmutableList.of(3, 9));

        assertEquals(expected, new Solution().flip(s));

        s = "010";
        expected = new ArrayList<>(ImmutableList.of(1, 1));

        assertEquals(expected, new Solution().flip(s));

        s = "111";
        expected = new ArrayList<>();

        assertEquals(expected, new Solution().flip(s));
    }
}
