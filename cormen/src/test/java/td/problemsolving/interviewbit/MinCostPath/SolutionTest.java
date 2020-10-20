package td.problemsolving.interviewbit.MinCostPath;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solve() {
        ArrayList<String> xs;
        int expected;

        xs = new ArrayList<>(ImmutableList.of(
                "DUDRURRLDR",
                "DULRLULDRD",
                "DLULUDLLDL",
                "RLRRDURDLD",
                "LURULLRDLL",
                "RRLDURURDL",
                "DULDURUDRL",
                "RUUUDUDLDR",
                "RRRRDLULRL",
                "DLRRUDRUUU"
        ));
        expected = 5;
        assertEquals(expected, new Solution().solve(xs.size(), xs.get(0).length(), xs));

        xs = new ArrayList<>(ImmutableList.of(
                "RRR",
                "DDD",
                "UUU"
        ));
        expected = 1;
        assertEquals(expected, new Solution().solve(xs.size(), xs.get(0).length(), xs));

        xs = new ArrayList<>(ImmutableList.of(
                "LLLL"
        ));
        expected = 3;
        assertEquals(expected, new Solution().solve(xs.size(), xs.get(0).length(), xs));
    }
}
