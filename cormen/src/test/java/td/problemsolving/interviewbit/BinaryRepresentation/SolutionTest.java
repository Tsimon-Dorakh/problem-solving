package td.problemsolving.interviewbit.BinaryRepresentation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void findDigitsInBinary() {
        assertEquals(
                "110",
                new Solution().findDigitsInBinary(6)
        );
        assertEquals(
                "1000",
                new Solution().findDigitsInBinary(8)
        );
        assertEquals(
                "0",
                new Solution().findDigitsInBinary(0)
        );
    }
}
