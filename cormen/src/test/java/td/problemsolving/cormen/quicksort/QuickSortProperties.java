package td.problemsolving.cormen.quicksort;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static td.problemsolving.cormen.quicksort.QuickSort.quicksort;
import static td.problemsolving.cormen.quicksort.QuickSort.quicksort_;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class QuickSortProperties {
    @Property
    public void sortProperty(int[] xs) {
        quicksort(xs);

        assertTrue(isSortedAscending(xs));
    }

    @Property
    public void partition_Property(int @Size (min = 1, max = 100)[] xs) {
        int[] idxs = QuickSort.partition_(xs, 0, xs.length - 1);

        for (int i = 0; i < xs.length; i++) {
            if (i < idxs[0]) {
                assertTrue(xs[i] < xs[idxs[0]]);
            } else if (i <= idxs[1]) {
                assertEquals(xs[i], xs[idxs[0]]);
            } else {
                assertTrue(xs[i] > xs[idxs[1]]);
            }
        }
    }

    @Property
    public void quicksort_sorted(int[] xs) {
        quicksort_(xs);

        assertTrue(isSortedAscending(xs));
    }

    private boolean isSortedAscending(int[] xs) {
        for (int i = 0; i < xs.length - 2; i++) {
            if (xs[i] > xs[i + 1]) return false;
        }

        return true;
    }

}
