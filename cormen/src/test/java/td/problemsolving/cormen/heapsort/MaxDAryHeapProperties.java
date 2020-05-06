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
import static td.problemsolving.cormen.heapsort.MaxDAryHeap.extractMax;

@RunWith(JUnitQuickcheck.class)
public class MaxDAryHeapProperties {
    @Property
    public void buildMaxHeapProp(@Size(max = 100) List<@InRange(minInt = 0, maxInt = 1000) Integer> xs) {
        MaxDAryHeap heap = MaxDAryHeap.buildMaxHeap(toIntArray(xs), generateRandomD(xs.size()));

        assertTrue(isMaxHeap(heap, Math.min(heap.heapSize, 1)));
    }

    @Property
    public void extractMaxSize(@From(MaxDAryHeapGenerator.class)
                               @Size(min = 1, max = 100)
                               @InRange(minInt = 0, maxInt = 1000) MaxDAryHeap maxDAryHeap) {
        int sizeBeforeExtractMax = maxDAryHeap.heapSize;
        extractMax(maxDAryHeap);
        int sizeAfterExtractMax = maxDAryHeap.heapSize;

        assertEquals(sizeBeforeExtractMax, sizeAfterExtractMax + 1);
    }

    @Property
    public void extractMaxSortedDescending(@From(MaxDAryHeapGenerator.class)
                                           /*@InRange(minInt = 0, maxInt = 1000)*/ MaxDAryHeap maxDAryHeap) {
        int[] xs = new int[maxDAryHeap.heapSize];

        int i = 0;
        while (maxDAryHeap.heapSize > 0) {
            xs[i++] = MaxDAryHeap.extractMax(maxDAryHeap);
        }

        assertTrue(isSortedDescending(xs));
    }

    @Property
    public void insertSize(@From(MaxDAryHeapGenerator.class) MaxDAryHeap maxDAryHeap,
                           int key) {
        int sizeBeforeInsert = maxDAryHeap.heapSize;
        maxDAryHeap.insert(key);
        int sizeAfterInsert = maxDAryHeap.heapSize;

        assertEquals(sizeBeforeInsert + 1, sizeAfterInsert);
    }

    @Property
    public void maxHeapPropAfterInsert(@From(MaxDAryHeapGenerator.class) MaxDAryHeap maxDAryHeap,
                                       int key) {
        maxDAryHeap.insert(key);

        assertTrue(isMaxHeap(maxDAryHeap, Math.min(1, maxDAryHeap.heapSize)));
    }

    private boolean isSortedDescending(int[] xs) {
        for (int i = 0; i < xs.length - 2; i++) {
            if (xs[i] < xs[i + 1]) return false;
        }

        return true;
    }

    private boolean isMaxHeap(MaxDAryHeap dAryHeap, int i) {
        if (i > dAryHeap.heapSize) {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }

        if (dAryHeap.heapSize == 0) {
            return true;
        }

        boolean result = true;

        for (int j = dAryHeap.child(i, 1); j <= Math.min(dAryHeap.child(i, dAryHeap.d), dAryHeap.heapSize); j++) {
            result = result && dAryHeap.xs[i] >= dAryHeap.xs[j] && isMaxHeap(dAryHeap, j);
        }

        return result;
    }


    private int[] toIntArray(List<Integer> list) {
        return list.stream().mapToInt(i -> i).toArray();
    }

    private int generateRandomD(int heapSize) {
        return 1 + (int) (Math.random() * heapSize);
    }
}
