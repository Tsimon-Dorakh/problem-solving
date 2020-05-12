package td.problemsolving.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class NRepeatedElementInSize2nArrayTest {
    @Test
    void repeatedNTimes() {
        assertEquals(3, new NRepeatedElementInSize2nArray().repeatedNTimes(new int[]{1,2,3,3}));
        assertEquals(2, new NRepeatedElementInSize2nArray().repeatedNTimes(new int[]{2,1,2,5,3,2}));
        assertEquals(5, new NRepeatedElementInSize2nArray().repeatedNTimes(new int[]{5,1,5,2,5,3,5,4}));
        assertEquals(9, new NRepeatedElementInSize2nArray().repeatedNTimes(new int[]{9,5,6,9}));
    }
}
