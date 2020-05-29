package td.problemsolving.cormen.countingsort;

import static org.junit.Assert.assertTrue;
import static td.problemsolving.cormen.countingsort.CountingSort.countingSort;
import static td.problemsolving.cormen.countingsort.CountingSort.countingSortInverted;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class CountingSortProperties {
    @Property
    public void sortedAscendingProp(@InRange(minInt = 0, maxInt = 1000)int[] xs) {
        assertTrue(isSortedAscending(countingSort(xs, 1000)));
    }

    @Property
    public void sortedInvertedAscendingProp(@InRange(minInt = 0, maxInt = 1000)int[] xs) {
        assertTrue(isSortedAscending(countingSortInverted(xs, 1000)));
    }

    private boolean isSortedAscending(int[] xs) {
        for (int i = 0; i < xs.length - 2; i++) {
            if (xs[i] > xs[i + 1]) return false;
        }

        return true;
    }
}
