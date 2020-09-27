package td.problemsolving.interviewbit.JumpGameArray;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void canJump() {
        ArrayList<Integer> xs;
        int expected;

        xs = new ArrayList<>(ImmutableList.of(10, 0, 1, 1, 0));
        expected = 1;
        assertEquals(expected, new Solution().canJump(xs));

        xs = new ArrayList<>(ImmutableList.of(2,3,1,1,4));
        expected = 1;
        assertEquals(expected, new Solution().canJump(xs));

        xs = new ArrayList<>(ImmutableList.of(3,2,1,0,4));
        expected = 0;
        assertEquals(expected, new Solution().canJump(xs));
    }
}
