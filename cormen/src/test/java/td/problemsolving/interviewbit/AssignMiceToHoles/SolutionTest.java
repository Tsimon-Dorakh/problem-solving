package td.problemsolving.interviewbit.AssignMiceToHoles;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void mice() {
        ArrayList<Integer> xs;
        ArrayList<Integer> ys;
        int expected;

        xs = new ArrayList<>(ImmutableList.of(-94, -85, -79, -79, -28, -10, 67, 93));
        ys = new ArrayList<>(ImmutableList.of(-31,  -2,   9,  23,  25,  50, 69, 78));
        expected = 102;
        assertEquals(expected, new Solution().mice(xs, ys));


        xs = new ArrayList<>(ImmutableList.of(-49, 58, 72, -78, 9, 65, -42, -3));
        ys = new ArrayList<>(ImmutableList.of(30, -13, -70, 58, -34, 79, -36, 27));
        expected = 28;
        assertEquals(expected, new Solution().mice(xs, ys));

        xs = new ArrayList<>(ImmutableList.of(4, -4, 2));
        ys = new ArrayList<>(ImmutableList.of(4, 0, 5));
        expected = 4;
        assertEquals(expected, new Solution().mice(xs, ys));


    }
}
