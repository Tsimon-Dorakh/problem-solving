package td.problemsolving.interviewbit.AllFactors;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void allFactors() {
        assertEquals(
                ImmutableList.of(1, 2, 3, 4, 6, 8, 9, 12, 16, 18, 24, 27, 32, 36, 48, 54, 64, 72, 81, 96, 108, 128, 144, 162, 192, 216, 256, 288, 324, 384, 432, 512, 576, 648, 768, 864, 1024, 1152, 1296, 1536, 1728, 2304, 2592, 3072, 3456, 4608, 5184, 6912, 9216, 10368, 13824, 20736, 27648, 41472, 82944),
                new Solution().allFactors(82944)
        );

        assertEquals(
                ImmutableList.of(1, 2, 3, 6),
                new Solution().allFactors(6)
        );

        assertEquals(
                ImmutableList.of(1),
                new Solution().allFactors(1)
        );
    }
}
