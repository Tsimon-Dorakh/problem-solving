package td.problemsolving.interviewbit.WordBreakII;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void wordBreak() {
        String s;
        ArrayList<String> xs;
        ArrayList<String> expected;

        s = "catsanddog";
        xs = new ArrayList<>(ImmutableList.of("cat", "cats", "and", "sand", "dog"));
        expected = new ArrayList<>(ImmutableList.of("cat sand dog", "cats and dog"));
        assertEquals(expected, new Solution().wordBreak(s, xs));

        s = "b";
        xs = new ArrayList<>(ImmutableList.of("aabbb"));
        expected = new ArrayList<>(ImmutableList.of());
        assertEquals(expected, new Solution().wordBreak(s, xs));
    }
}
