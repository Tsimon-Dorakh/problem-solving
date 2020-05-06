package td.problemsolving.cormen.heapsort;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class BinaryHeapProperties {
    @Property(trials = 5)
    public void leftParent(@InRange(min = "1", max = "100") int i) {
        assertEquals(i, BinaryHeap.parent(BinaryHeap.left(i)));
    }

    @Property(trials = 5)
    public void rightParent(@InRange(min = "1", max = "100") int i) {
        assertEquals(i, BinaryHeap.parent(BinaryHeap.right(i)));
    }
}
