package td.problemsolving.cormen.quicksort;

import static junit.framework.TestCase.assertTrue;
import static td.problemsolving.cormen.quicksort.QuickSortHoare.quicksort;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class QuickSortHoareProperties {
    @Property
    public void sortProperty(int[] xs) {
        quicksort(xs);

        assertTrue(isSortedAscending(xs));
    }

    private boolean isSortedAscending(int[] xs) {
        for (int i = 0; i < xs.length - 2; i++) {
            if (xs[i] > xs[i + 1]) return false;
        }

        return true;
    }
}
