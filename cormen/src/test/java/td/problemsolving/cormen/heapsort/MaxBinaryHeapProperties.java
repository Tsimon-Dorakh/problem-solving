package td.problemsolving.cormen.heapsort;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static td.problemsolving.cormen.heapsort.BinaryHeap.left;
import static td.problemsolving.cormen.heapsort.BinaryHeap.right;
import static td.problemsolving.cormen.heapsort.MaxBinaryHeap.extractMax;
import static td.problemsolving.cormen.heapsort.MaxBinaryHeap.insert;

@RunWith(JUnitQuickcheck.class)
public class MaxBinaryHeapProperties {
    @Property(/*trials = 5*/)
    public void buildMaxHeapProp(@Size(max = 100) List<@InRange(minInt = 0, maxInt = 1000) Integer> xs) {
        MaxBinaryHeap maxBinaryHeap = MaxBinaryHeap.buildMaxHeap(toIntArray(xs));
//        MaxHeap maxHeap = MaxHeap.buildMaxHeap(new int[]{659, 659, 81, 734, 11});

        assertTrue(isMaxHeap(maxBinaryHeap, Math.min(maxBinaryHeap.heapSize, 1)));
    }

    @Property
    public void extractMaxSize(@From(MaxBinaryHeapGenerator.class)
                               @Size(min = 1, max = 100)
                               @InRange(minInt = 0, maxInt = 1000) MaxBinaryHeap maxBinaryHeap) {
        int sizeBeforeExtractMax = maxBinaryHeap.heapSize;
        extractMax(maxBinaryHeap);
        int sizeAfterExtractMax = maxBinaryHeap.heapSize;

        assertEquals(sizeBeforeExtractMax, sizeAfterExtractMax + 1);
    }

    @Property
    public void extractMaxSortedDescending(@From(MaxBinaryHeapGenerator.class)
                                           @Size(min = 1, max = 100)
                                           @InRange(minInt = 0, maxInt = 1000) MaxBinaryHeap maxBinaryHeap) {
        int[] xs = new int[maxBinaryHeap.heapSize];

        int i = 0;
        while (maxBinaryHeap.heapSize > 0) {
            xs[i++] = extractMax(maxBinaryHeap);
        }

        assertTrue(isSortedDescending(xs));
    }

    @Property
    public void insertSize(@From(MaxBinaryHeapGenerator.class) MaxBinaryHeap maxBinaryHeap,
                           int key) {
        int sizeBeforeInsert = maxBinaryHeap.heapSize;
        insert(maxBinaryHeap, key);
        int sizeAfterInsert = maxBinaryHeap.heapSize;

        assertEquals(sizeBeforeInsert, sizeAfterInsert - 1);
    }

    @Property
    public void maxHeapPropAfterInsert(@From(MaxBinaryHeapGenerator.class) MaxBinaryHeap maxBinaryHeap,
                                       int key) {
        insert(maxBinaryHeap, key);

        assertTrue(isMaxHeap(maxBinaryHeap, Math.min(maxBinaryHeap.heapSize, 1)));
    }

    private boolean isSortedDescending(int[] xs) {
        for (int i = 0; i < xs.length - 2; i++) {
            if (xs[i] < xs[i + 1]) return false;
        }

        return true;
    }

    private boolean isMaxHeap(MaxBinaryHeap maxBinaryHeap, int i) {
        if (i > maxBinaryHeap.heapSize) {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        if (maxBinaryHeap.heapSize == 0) {
            return true;
        }

        boolean result = true;

        if (left(i) <= maxBinaryHeap.heapSize) {
            result = maxBinaryHeap.xs[i] >= maxBinaryHeap.xs[left(i)] && isMaxHeap(maxBinaryHeap, left(i));
        }
        if (right(i) <= maxBinaryHeap.heapSize) {
            result = result && maxBinaryHeap.xs[i] >= maxBinaryHeap.xs[right(i)] && isMaxHeap(maxBinaryHeap, right(i));
        }

        return result;
    }

    private int[] toIntArray(List<Integer> list) {
        return list.stream().mapToInt(i -> i).toArray();
    }
}
