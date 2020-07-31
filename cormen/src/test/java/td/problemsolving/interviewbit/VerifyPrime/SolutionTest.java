package td.problemsolving.interviewbit.VerifyPrime;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void isPrime() {
        assertEquals(0, new Solution().isPrime(1));
        assertEquals(1, new Solution().isPrime(2));
        assertEquals(1, new Solution().isPrime(3));
        assertEquals(0, new Solution().isPrime(4));
        assertEquals(1, new Solution().isPrime(7));
    }
}
