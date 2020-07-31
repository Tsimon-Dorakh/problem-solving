package td.problemsolving.interviewbit.MergeIntervals;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void insert() {
        assertEquals(
                toArrayList(ImmutableList.of(
                        new Solution.Interval(1, 2),
                        new Solution.Interval(3, 10),
                        new Solution.Interval(12, 16)
                )),
                new Solution().insert(
                        toArrayList(ImmutableList.of(
                                new Solution.Interval(1, 2),
                                new Solution.Interval(3, 5),
                                new Solution.Interval(6, 7),
                                new Solution.Interval(8, 10),
                                new Solution.Interval(12, 16)
                        )),
                        new Solution.Interval(4, 9)
                )
        );

        assertEquals(
                toArrayList(ImmutableList.of(
                        new Solution.Interval(1, 5),
                        new Solution.Interval(6, 9)
                )),
                new Solution().insert(
                        toArrayList(ImmutableList.of(
                                new Solution.Interval(1, 3),
                                new Solution.Interval(6, 9)
                        )),
                        new Solution.Interval(2, 5)
                )
        );

        assertEquals(
                toArrayList(ImmutableList.of(
                        new Solution.Interval(1, 2),
                        new Solution.Interval(3, 4),
                        new Solution.Interval(5, 6)
                )),
                new Solution().insert(
                        toArrayList(ImmutableList.of(
                                new Solution.Interval(1, 2),
                                new Solution.Interval(5, 6)
                        )),
                        new Solution.Interval(3, 4)
                )
        );

        assertEquals(
                toArrayList(ImmutableList.of(
                        new Solution.Interval(1, 2),
                        new Solution.Interval(3, 4),
                        new Solution.Interval(5, 6)
                )),
                new Solution().insert(
                        toArrayList(ImmutableList.of(
                                new Solution.Interval(3, 4),
                                new Solution.Interval(5, 6)
                        )),
                        new Solution.Interval(1, 2)
                )
        );

        assertEquals(
                toArrayList(ImmutableList.of(
                        new Solution.Interval(1, 2),
                        new Solution.Interval(3, 4),
                        new Solution.Interval(5, 6)
                )),
                new Solution().insert(
                        toArrayList(ImmutableList.of(
                                new Solution.Interval(1, 2),
                                new Solution.Interval(3, 4)
                        )),
                        new Solution.Interval(5, 6)
                )
        );

        assertEquals(
                toArrayList(ImmutableList.of(
                        new Solution.Interval(1, 2)
                )),
                new Solution().insert(
                        toArrayList(ImmutableList.of(
                        )),
                        new Solution.Interval(1, 2)
                )
        );

        assertEquals(
                toArrayList(ImmutableList.of(
                        new Solution.Interval(1, 12)
                )),
                new Solution().insert(
                        toArrayList(ImmutableList.of(
                                new Solution.Interval(3, 5),
                                new Solution.Interval(8, 10)
                        )),
                        new Solution.Interval(1, 12)
                )
        );

    }

    private ArrayList<Solution.Interval> toArrayList(List<Solution.Interval> xs) {
        return new ArrayList<>(xs);
    }
}
