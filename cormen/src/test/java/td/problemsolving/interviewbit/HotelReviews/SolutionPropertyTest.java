package td.problemsolving.interviewbit.HotelReviews;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class SolutionPropertyTest {
    @Property
    public void test(@From(StringGenerator.class) String dictionary,
                     @Size(max = 20) List<@From(StringGenerator.class) String> xs) {
        assertEquals(
                new Solution().n2Solution(dictionary, new ArrayList<>(xs)),
                new Solution().nSolution(dictionary, new ArrayList<>(xs)));
    }
}
