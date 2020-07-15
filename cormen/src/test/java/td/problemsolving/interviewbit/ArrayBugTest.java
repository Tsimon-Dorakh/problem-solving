package td.problemsolving.interviewbit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class ArrayBugTest {

    @Test
    void rotateArray() {
        assertEquals(
                Arrays.asList(2, 3, 4, 5, 6, 1),
                new ArrayBug().rotateArray(Arrays.asList(1, 2, 3, 4, 5, 6), 1)
        );
    }
}
