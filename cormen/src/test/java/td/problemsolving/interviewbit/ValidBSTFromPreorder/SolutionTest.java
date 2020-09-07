package td.problemsolving.interviewbit.ValidBSTFromPreorder;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solve() {
        ArrayList<Integer> xs;

        xs = new ArrayList<>(ImmutableList.of(40, 30, 35, 80, 100));
        assertEquals(1, new Solution().solve(xs));

        xs = new ArrayList<>(ImmutableList.of(315, 279, 263, 205, 187, 184, 70, 68, 141, 100, 176, 185, 193, 309, 839, 749, 491, 384, 364, 416, 392, 386, 418, 417, 457, 433, 655, 645, 596, 584, 524, 630, 748, 667, 658, 692, 735, 732, 805, 787, 773, 763, 763, 796, 897, 896, 859, 863, 886, 960, 948, 943, 969, 996, 989));
        assertEquals(1, new Solution().solve(xs));
    }
}
