package td.problemsolving.hackerrank.FindTheRunningMedian;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void runningMedian() {
        int[] xs;
        double[] expected;

        xs = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        expected = new double[] {1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5, 5, 5.5};
        assertArrayEquals(expected, Solution.runningMedian(xs));

        xs = new int[] {12, 4, 5, 3, 8, 7};
        expected = new double[] {12.0, 8.0, 5.0, 4.5, 5.0, 6.0};
        assertArrayEquals(expected, Solution.runningMedian(xs));
    }
}
