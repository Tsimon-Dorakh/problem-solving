package td.problemsolving.cormen.heapsort;

public class MaxBinaryHeap extends BinaryHeap {
    static int MIN_KEY = Integer.MIN_VALUE + 1;
    static int MAX_KEY = Integer.MAX_VALUE;

    static void insert(MaxBinaryHeap heap, int key) {
        heap.heapSize++;
        heap.xs = concat(heap.xs, new int[]{Integer.MIN_VALUE});
        increaseKey(heap, heap.heapSize, key);
    }

    private static void increaseKey(MaxBinaryHeap heap, int i, int key) {
        if (key < heap.xs[i]) {
            throw new IllegalArgumentException();
        }

        heap.xs[i] = key;

        while (i > 1 && heap.xs[parent(i)] < heap.xs[i]) {
            swap(heap.xs, i, parent(i));
            i = parent(i);
        }
    }

    static int extractMax(MaxBinaryHeap maxBinaryHeap) {
        if (maxBinaryHeap.heapSize < 1) {
            throw new IndexOutOfBoundsException();
        }

        int max = maxBinaryHeap.xs[1];
        maxBinaryHeap.xs[1] = maxBinaryHeap.xs[maxBinaryHeap.heapSize];
        maxBinaryHeap.heapSize--;
        maxHeapify(maxBinaryHeap, 1);

        return max;
    }

    static void maxHeapify(BinaryHeap binaryHeap, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;

        if (l <= binaryHeap.heapSize && binaryHeap.xs[l] > binaryHeap.xs[largest]) {
            largest = l;
        }
        if (r <= binaryHeap.heapSize && binaryHeap.xs[r] > binaryHeap.xs[largest]) {
            largest = r;
        }

        if (i != largest) {
            swap(binaryHeap.xs, i, largest);
            maxHeapify(binaryHeap, largest);
        }
    }

    static MaxBinaryHeap buildMaxHeap(int[] xs) {
        MaxBinaryHeap heap = new MaxBinaryHeap();
        heap.xs = concat(new int[]{0}, xs);
        heap.heapSize = xs.length;

        for (int i = xs.length >> 1; i >= 1; i--) {
            maxHeapify(heap, i);
        }

        return heap;
    }

    static void swap(int[] xs, int i, int j) {
        int tmp = xs[i];
        xs[i] = xs[j];
        xs[j] = tmp;
    }

    static int[] concat(int[] x, int[] y) {
        int[] xs = new int[x.length + y.length];
        System.arraycopy(x, 0, xs, 0, x.length);
        System.arraycopy(y, 0, xs, x.length, y.length);

        return xs;
    }
}
