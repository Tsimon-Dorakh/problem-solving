package td.problemsolving.interviewbit.NmaxPairCombinations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import java.util.ArrayList;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class SolutionPropertyTest {
    @Property(/*trials = 5*/)
    public void propTest(
            @Size(min = 5, max = 5) ArrayList<@InRange(minInt = -10, maxInt = 10) Integer> xs,
            @Size(min = 5, max = 5) ArrayList<@InRange(minInt = -10, maxInt = 10) Integer> ys) {
        Solution solution = new Solution();

        assertEquals(solution.OnSquareSolution(xs, ys), solution.OnSolution(xs, ys));
    }
}
