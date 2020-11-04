package td.problemsolving.hackerrank.MaximumXor;

import static org.junit.jupiter.api.Assertions.*;
import static td.problemsolving.utils.Print.print;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void maxXor() {
        int[] arr;
        int[] queries;
        int[] expected;

        arr = new int[]{2, 1};
        queries = new int[]{0};
        expected = new int[]{2};
        assertArrayEquals(expected, Solution.maxXor(arr, queries));

        arr = new int[]{0, 1};
        queries = new int[]{5};
        expected = new int[]{5};
        assertArrayEquals(expected, Solution.maxXor(arr, queries));

        arr = new int[]{0, 1, 2};
        queries = new int[]{7, 3, 7, 2};
        expected = new int[]{7, 3, 7, 3};
        assertArrayEquals(expected, Solution.maxXor(arr, queries));

        arr = new int[]{1, 3, 5, 7};
        queries = new int[]{6, 17};
        expected = new int[]{7, 22};
        assertArrayEquals(expected, Solution.maxXor(arr, queries));

        arr = new int[]{0, 2};
        queries = new int[]{1};
        expected = new int[]{3};
//        print(Solution.bruteForce(arr, queries));
        assertArrayEquals(
                expected,
                Solution.trieSolution(arr, queries)
        );

        arr = new int[]{4};
        queries = new int[]{1};
        expected = new int[]{5};
        assertArrayEquals(
                expected,
                Solution.trieSolution(arr, queries)
        );

        arr = new int[]{5, 1, 7, 4, 3};
        queries = new int[]{2, 0};
        expected = new int[]{7, 7};
        assertArrayEquals(expected, Solution.maxXor(arr, queries));
    }
}
