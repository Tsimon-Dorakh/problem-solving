package td.problemsolving.cormen.quicksort;

import static junit.framework.TestCase.assertTrue;
import static td.problemsolving.cormen.quicksort.QuickSortRandomized.quicksort;
import static td.problemsolving.cormen.quicksort.QuickSortRandomized.quicksort_;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class QuickSortRandomizedProperties {
    @Property
    public void sortProperty(int[] xs) {
        quicksort(xs);

        assertTrue(isSortedAscending(xs));
    }

    @Property
    public void sort_Property(int[] xs) {
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
