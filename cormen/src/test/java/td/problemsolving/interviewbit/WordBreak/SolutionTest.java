package td.problemsolving.interviewbit.WordBreak;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void wordBreak() {
        String s;
        ArrayList<String> xs;
        int expected;

        s = "myinterviewtrainer";
        xs = new ArrayList<>(ImmutableList.of("trainer", "my", "interview"));
        expected = 1;
        assertEquals(expected, new Solution().wordBreak(s, xs));

        s = "a";
        xs = new ArrayList<>(ImmutableList.of("aaa"));
        expected = 0;
        assertEquals(expected, new Solution().wordBreak(s, xs));
    }
}
