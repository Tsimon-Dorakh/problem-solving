package td.problemsolving.cormen.quicksort;

public class QuickSortHoare {
    static void quicksort(int[] xs) {
        quicksort(xs, 0, xs.length - 1);
    }

    static void quicksort(int[] xs, int lo, int hi) {
        if (lo < hi) {
            int q = partition(xs, lo, hi);
            quicksort(xs, lo, q);
            quicksort(xs, q + 1, hi);
        }
    }

    private static int partition(int[] xs, int lo, int hi) {
        int pivot = xs[lo];
        int l = lo - 1;
        int r = hi + 1;

        while (true) {
            do {
                l += 1;
            } while (xs[l] < pivot);

            do {
                r -= 1;
            } while (xs[r] > pivot);


            if (l < r) {
                swap(xs, l, r);
            } else {
                return r;
            }
        }
    }

    private static void swap(int[] xs, int i, int j) {
        int tmp = xs[i];
        xs[i] = xs[j];
        xs[j] = tmp;
    }

}
