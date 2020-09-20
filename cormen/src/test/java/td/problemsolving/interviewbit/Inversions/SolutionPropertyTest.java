package td.problemsolving.interviewbit.Inversions;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class SolutionPropertyTest {
    @Property
    public void test(@Size(max = 20) ArrayList<@InRange(minInt = 0, maxInt = 10) Integer> xs) {
        Solution solution = new Solution();

        assertEquals(
                solution.N2Solution(xs),
                solution.NLogNSolution(xs)
        );
    }

}
