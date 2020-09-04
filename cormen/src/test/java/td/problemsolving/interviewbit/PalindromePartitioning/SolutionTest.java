package td.problemsolving.interviewbit.PalindromePartitioning;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void partition() {
        String input;
        ArrayList<ArrayList<String>> expected;

        input = "aab";
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of("a", "a", "b")),
                new ArrayList<>(ImmutableList.of("aa", "b"))
        ));
        assertEquals(expected, new Solution().partition(input));
    }
}
