package td.problemsolving.interviewbit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpiralOrderMatrixITest {
    @Test
    void spiralOrder() {
        assertEquals(
                Arrays.asList(1, 2, 4, 3),
                new SpiralOrderMatrixI().spiralOrder(toList(
                        new int[][] {
                                new int[]{1, 2},
                                new int[]{3, 4},
                        }
                ))
        );

        assertEquals(
                Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5),
                new SpiralOrderMatrixI().spiralOrder(toList(
                        new int[][] {
                                new int[]{1, 2, 3},
                                new int[]{4, 5, 6},
                                new int[]{7, 8, 9},
                        }
                ))
        );

        assertEquals(
                Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
                new SpiralOrderMatrixI().spiralOrder(toList(
                        new int[][] {
                                new int[]{1,  2,  3,  4},
                                new int[]{5,  6,  7,  8},
                                new int[]{9, 10, 11, 12},
                        }
                ))
        );
    }

    private List<List<Integer>> toList(int[][] xss) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < xss.length; i++) {
            List<Integer> xs = new ArrayList<>();

            for (int x : xss[i]) {
                xs.add(x);
            }

            result.add(xs);
        }

        return result;
    }
}
