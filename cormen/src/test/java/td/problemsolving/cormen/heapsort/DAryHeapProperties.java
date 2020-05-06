package td.problemsolving.cormen.heapsort;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class DAryHeapProperties {
    @Property(/*trials = 5*/)
    public void parentProp(@From(DAryHeapGenerator.class) DAryHeap dAryHeap,
                           @InRange(minInt = 0, maxInt = 1000) int i) {
        assertEquals(i, dAryHeap.parent(dAryHeap.child(i, generateRandomOffset(dAryHeap.d))));
    }

    private int generateRandomOffset(int d) {
        return 1 + (int) (Math.random() * d);
    }

}
