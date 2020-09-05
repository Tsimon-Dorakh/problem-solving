package td.problemsolving.interviewbit.Anagrams;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void anagrams() {
        List<String> input;
        ArrayList<ArrayList<Integer>> expected;

        input = new ArrayList<>(ImmutableList.of("cat", "dog", "god", "tca"));
        expected = new ArrayList<>(ImmutableList.of(
                new ArrayList<>(ImmutableList.of(1, 4)),
                new ArrayList<>(ImmutableList.of(2, 3))
        ));
        assertEquals(expected, new Solution().anagrams(input));
    }
}
