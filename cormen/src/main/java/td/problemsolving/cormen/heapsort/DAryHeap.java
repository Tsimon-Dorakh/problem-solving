package td.problemsolving.cormen.heapsort;

import java.util.Arrays;

public class DAryHeap {
    int d;
    int heapSize;
    int[] xs;

    public DAryHeap(int d) {
        if (d < 1) {
            throw new IllegalArgumentException();
        }

        this.d = d;
    }

    int parent(int i) {
        return (int) Math.floor(1. * (i - 2) / d + 1);
    }

    int child(int i, int j) {
        return d * (i - 1) + j + 1;
    }

    @Override
    public String toString() {
        return "DAryHeap{" +
                "d=" + d +
                ", heapSize=" + heapSize +
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
