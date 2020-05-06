package td.problemsolving.cormen.heapsort;

import org.junit.Test;

public class MaxBinaryHeapTest {
    @Test
    public void buildMaxHeap() {
        MaxBinaryHeap maxBinaryHeap = MaxBinaryHeap.buildMaxHeap(new int[]{1, 2, 3, 4, 5});

        maxBinaryHeap.print();
    }
}
