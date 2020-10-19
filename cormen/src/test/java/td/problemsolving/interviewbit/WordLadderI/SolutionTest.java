package td.problemsolving.interviewbit.WordLadderI;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solve() {
        String from;
        String to;
        ArrayList<String> dict;
        int expected;

        from = "hit";
        to = "cog";
        dict = new ArrayList<>(ImmutableList.of("hot", "dot", "dog", "lot", "log"));
        expected = 5;
        assertEquals(expected, new Solution().solve(from, to, dict));
    }
}
