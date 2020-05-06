package td.problemsolving.cormen.heapsort;

import java.util.Arrays;

public class BinaryHeap {
    int heapSize;
    int[] xs;

    static int parent(int i) {
        return i >> 1;
    }

    static int left(int i) {
        return 2 * i;
    }

    static int right(int i) {
        return 2 * i + 1;
    }

    @Override
    public String toString() {
        return "BinaryHeap{" +
                "heapSize=" + heapSize +
                ", xs=" + Arrays.toString(xs) +
                '}';
    }

    void print() {
        for (int i = 1; i < xs.length; i++) {
            System.out.print(xs[i] + " ");
        }

        System.out.println();
    }
}
