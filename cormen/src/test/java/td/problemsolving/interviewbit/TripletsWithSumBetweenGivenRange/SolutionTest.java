package td.problemsolving.interviewbit.TripletsWithSumBetweenGivenRange;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solve() {
        assertEquals(
                1,
                new Solution().solve(new ArrayList<>(ImmutableList.of("0.6", "0.7", "0.8", "1.2", "0.4")))
        );
        assertEquals(
                0,
                new Solution().solve(new ArrayList<>(ImmutableList.of("1.6", "1.7", "1.8", "1.2", "1.4")))
        );
        assertEquals(
                1,
                new Solution().solve(new ArrayList<>(ImmutableList.of("0.366507", "0.234601", "2.126313", "1.372403", "2.022170", "0.308558", "2.120754", "1.561462")))
        );
        assertEquals(
                1,
                new Solution().solve(new ArrayList<>(ImmutableList.of("0.503094", "0.648924", "0.999298", "0.853928", "3.457635", "5.030008", "2.434625", "3.081333", "4.629904", "0.551040", "2.950470", "2.248522", "1.426132", "4.848954", "4.624663", "1.095358", "0.980046", "3.620912", "3.504833", "1.930379")))
        );
    }
}
