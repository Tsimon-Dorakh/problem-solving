package td.problemsolving.interviewbit.MaximumConsecutiveGap;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(JUnitQuickcheck.class)
public class SolutionQuickCheckTest {
    @Property
    public void differentImplementation(List<@InRange(min = "0", max = "9") Integer> xs) {
        Assert.assertEquals(
                new Solution().nLogNSolution(xs),
                new Solution().nSolution(xs)
        );
    }
}
