package td.problemsolving.cormen.quicksort;

public class QuickSortRandomized {
    static void quicksort(int[] xs) {
        quicksort(xs, 0, xs.length - 1);
    }

    static void quicksort(int[] xs, int p, int r) {
        if (p < r) {
            int q = partition(xs, p, r);
            quicksort(xs, p, q - 1);
            quicksort(xs, q + 1, r);
        }
    }

    static int partition(int[] xs, int lo, int hi) {
        int i = random(lo, hi + 1);
        swap(xs, i, hi);
        return QuickSort.partition(xs, lo, hi);
    }

    static int quicksort_(int[] xs) {
        return quicksort_(xs, 0, xs.length - 1, 0);
    }

    static int quicksort_(int[] xs, int p, int r, int level) {
        if (p < r) {
            int[] idxs = partition_(xs, p, r);

            level = Math.max(
                    quicksort_(xs, p, idxs[0] - 1, level + 1),
                    quicksort_(xs, idxs[1] + 1, r, level + 1)
            );
        }

        return level;
    }

    static int[] partition_(int[] xs, int lo, int hi) {
        int i = random(lo, hi + 1);
        swap(xs, i, hi);
        return QuickSort.partition_(xs, lo, hi);
    }

    private static void swap(int[] xs, int i, int j) {
        int tmp = xs[i];
        xs[i] = xs[j];
        xs[j] = tmp;
    }

    private static int random(int a, int b) {
        return a + (int) (Math.random() * (b - a));
    }
}
