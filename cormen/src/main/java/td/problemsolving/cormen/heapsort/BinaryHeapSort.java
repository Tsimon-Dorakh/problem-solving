package td.problemsolving.cormen.heapsort;

import java.util.Arrays;

import static td.problemsolving.cormen.heapsort.MaxBinaryHeap.buildMaxHeap;
import static td.problemsolving.cormen.heapsort.MaxBinaryHeap.maxHeapify;

public class BinaryHeapSort {
    static int[] sort(int[] xs) {
        MaxBinaryHeap maxBinaryHeap = buildMaxHeap(xs);

        for (int i = maxBinaryHeap.heapSize; i >= 2; i--) {
            swap(maxBinaryHeap.xs, i, 1);
            maxBinaryHeap.heapSize--;
            maxHeapify(maxBinaryHeap, 1);
        }

        return Arrays.copyOfRange(maxBinaryHeap.xs, 1, maxBinaryHeap.xs.length);
    }

    private static void swap(int[] xs, int i, int j) {
        int tmp = xs[i];
        xs[i] = xs[j];
        xs[j] = tmp;
    }
}
