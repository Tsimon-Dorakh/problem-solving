package td.problemsolving.cormen.quicksort;

import static junit.framework.TestCase.assertTrue;
import static td.problemsolving.cormen.quicksort.FuzzySort.isLessOrEqualInterval;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class FuzzySortProperties {
    @Property
    public void sortedProp(int []@Size(min = 2, max = 2)[] xss) {
        int maxLevel = FuzzySort.sort(normalize(xss));

        System.out.printf("size: %d\nlog2(size): %.2f\nActual recursion level: %d\n",
                xss.length,
                log2(xss.length),
                maxLevel);

        assertTrue(isSortedAscending(xss));
    }

    @Property
    public void sorted_Prop(int[]@Size(min = 2, max = 2)[] xss) {
        int maxLevel = FuzzySort.sort_(normalize(xss));

        System.out.printf("size: %d\nlog2(size): %.2f\nActual recursion level: %d\n",
                xss.length,
                log2(xss.length),
                maxLevel);


        assertTrue(isSortedAscending(xss));
    }

    private boolean isSortedAscending(int[][] xss) {
        for (int i = 0; i < xss.length - 1; i++) {
            if (!isLessOrEqualInterval(xss[i], xss[i + 1])) {
                return false;
            }
        }

        return true;
    }

    private int[][] normalize(int[][] xss) {
        for (int[] xs : xss) {
            if (xs[0] > xs[1]) {
                int tmp = xs[0];
                xs[0] = xs[1];
                xs[1] = tmp;
            }
        }

        return xss;
    }

    private static double log2(int x) {
        return log(x, 2);
    }

    private static double log(int x, int base) {
        return (Math.log(x) / Math.log(base));
    }
}
