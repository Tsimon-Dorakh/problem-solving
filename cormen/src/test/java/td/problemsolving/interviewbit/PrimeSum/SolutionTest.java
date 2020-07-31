package td.problemsolving.interviewbit.PrimeSum;

import static org.junit.jupiter.api.Assertions.*;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void primesum() {
        assertEquals(
                ImmutableList.of(2, 2),
                new Solution().primesum(4)
        );
    }
}
