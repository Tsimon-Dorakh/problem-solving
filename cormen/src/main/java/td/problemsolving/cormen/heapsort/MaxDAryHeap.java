package td.problemsolving.cormen.heapsort;

public class MaxDAryHeap extends DAryHeap {
    public MaxDAryHeap(int d) {
        super(d);
    }

    void insert(int key) {
        heapSize++;
        xs = concat(xs, new int[]{Integer.MIN_VALUE});
        increaseKey(this, heapSize, key);
    }

    private static void increaseKey(MaxDAryHeap heap, int i, int key) {
        if (key < heap.xs[i]) {
            throw new IllegalArgumentException();
        }

        heap.xs[i] = key;

        while (i > 1 && heap.xs[heap.parent(i)] < heap.xs[i]) {
            swap(heap.xs, heap.parent(i), i);
            i = heap.parent(i);
        }
    }

    static int extractMax(DAryHeap dAryHeap) {
        if (dAryHeap.heapSize < 1) {
            throw new IndexOutOfBoundsException();
        }

        int max = dAryHeap.xs[1];
        dAryHeap.xs[1] = dAryHeap.xs[dAryHeap.heapSize];
        dAryHeap.heapSize--;
        maxHeapify(dAryHeap, 1);

        return max;
    }

    static void maxHeapify(DAryHeap dAryHeap, int i) {
        int largest = i;

        for (int j = dAryHeap.child(i, 1); j <= Math.min(dAryHeap.child(i, dAryHeap.d), dAryHeap.heapSize); j++) {
            if (dAryHeap.xs[j] > dAryHeap.xs[largest]) {
                largest = j;
            }
        }

        if (i != largest) {
            swap(dAryHeap.xs, i, largest);
            maxHeapify(dAryHeap, largest);
        }
    }

    static MaxDAryHeap buildMaxHeap(int[] xs, int d) {
        MaxDAryHeap heap = new MaxDAryHeap(d);
        heap.xs = concat(new int[]{0}, xs);
        heap.heapSize = xs.length;

        for (int i = (int) Math.ceil(1. * (heap.heapSize - 1) / d); i >= 1; i--) {
            maxHeapify(heap, i);
        }

        return heap;
    }

    private static void swap(int[] xs, int i, int j) {
        int tmp = xs[i];
        xs[i] = xs[j];
        xs[j] = tmp;
    }

    private static int[] concat(int[] x, int[] y) {
        int[] xs = new int[x.length + y.length];
        System.arraycopy(x, 0, xs, 0, x.length);
        System.arraycopy(y, 0, xs, x.length, y.length);

        return xs;
    }


}
