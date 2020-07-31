package td.problemsolving.interviewbit.PrimeNumbers;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void sieve() {
        assertEquals(
                ImmutableList.of(2, 3, 5, 7),
                new Solution().sieve(7)
        );
    }
}
