package td.problemsolving.interviewbit.NUMRANGE;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class SolutionPropTest {
    @Property(/*trials = 5*/)
    public void propTest(@Size(max = 10) ArrayList<@InRange(minInt = 0, maxInt = 10) Integer> xs,
                         @InRange(minInt = 0, maxInt = 10) Integer a,
                         @InRange(minInt = 0, maxInt = 10) Integer b) {
        assertEquals(new Solution().On2Solution(xs, a, b),
                new Solution().OnSolution(xs, a, b));
    }
}
