package td.problemsolving.cormen.heapsort;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class BinaryHeapSortProperties {
    @Property
    public void countProp(@Size(max = 100) List<@InRange(minInt = 0, maxInt = 1000) Integer> xs) {
        assertEquals(xs.size(), BinaryHeapSort.sort(toIntArray(xs)).length);
    }

    @Property
    public void sortedAscendingProp(List<Integer> xs) {
        assertTrue(isSortedAscending(BinaryHeapSort.sort(toIntArray(xs))));
    }

    private boolean isSortedAscending(int[] xs) {
        for (int i = 0; i < xs.length - 2; i++) {
            if (xs[i] > xs[i + 1]) return false;
        }

        return true;
    }

    private int[] toIntArray(List<Integer> list) {
        return list.stream().mapToInt(i -> i).toArray();
    }

}
