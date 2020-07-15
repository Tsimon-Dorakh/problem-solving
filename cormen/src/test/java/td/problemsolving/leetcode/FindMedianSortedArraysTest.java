package td.problemsolving.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FindMedianSortedArraysTest {
    @Test
    void findMedianSortedArrays() {
        assertEquals(
                2,
                new FindMedianSortedArrays().findMedianSortedArrays(
                        new int[]{1, 3},
                        new int[]{2}
                ),
                0.0
        );

        assertEquals(
                2.5,
                new FindMedianSortedArrays().findMedianSortedArrays(
                        new int[]{1, 2},
                        new int[]{3, 4}
                ),
                0.0
        );
    }
}
