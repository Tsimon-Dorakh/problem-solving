package td.problemsolving.interviewbit.MaximumAbsoluteDifference;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxArr() {
        assertEquals(
                5,
                new Solution().maxArr(toArrayList(ImmutableList.of(1, 3, -1)))
        );
    }

    private ArrayList<Integer> toArrayList(List<Integer> xs) {
        return new ArrayList<>(xs);
    }
}
