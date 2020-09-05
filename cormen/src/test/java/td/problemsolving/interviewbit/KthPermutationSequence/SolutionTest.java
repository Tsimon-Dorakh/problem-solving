package td.problemsolving.interviewbit.KthPermutationSequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void getPermutation() {
//        assertEquals("231", new Solution().getPermutation(10, 3528800));
        assertEquals("231", new Solution().getPermutation(3, 4));
        assertEquals("1234567891011", new Solution().getPermutation(11, 1));
    }
}
