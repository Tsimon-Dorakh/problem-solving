package td.problemsolving.hackerrank.MaximumXor;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class SolutionPropertyTest {
    @Property
    public void maxXor(@InRange(minInt = 0, maxInt = 20)int@Size(min = 1, max = 10)[] arr,
                       @InRange(minInt = 0, maxInt = 20)int@Size(min = 1, max = 10)[] queries) {
        assertArrayEquals(
                Solution.bruteForce(arr, queries),
                Solution.trieSolution(arr, queries)
        );
    }
}
