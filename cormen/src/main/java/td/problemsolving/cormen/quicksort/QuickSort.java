package td.problemsolving.cormen.quicksort;

public class QuickSort {
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

    static int partition(int[] xs, int p, int r) {
        int x = xs[r];
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (xs[j] <= x) {
                i += 1;

                swap(xs, i, j);
            }
        }

        swap(xs, i + 1, r);

        return i + 1;
    }

    static void quicksort_(int[] xs) {
        quicksort_(xs, 0, xs.length - 1);
    }

    static void quicksort_(int[] xs, int p, int r) {
        if (p < r) {
            int[] idxs = partition_(xs, p, r);
            quicksort_(xs, p, idxs[0] - 1);
            quicksort_(xs, idxs[1] + 1, r);
        }
    }

    static int[] partition_(int[] xs, int p, int r) {
        int x = xs[r];
        int low = p - 1;
        int high = p - 1;

        for (int j = p; j < r; j++) {
            if (xs[j] == x) {
                high += 1;

                swap(xs, high, j);
            } else if (xs[j] < x) {
                low += 1;
                high += 1;

                swap(xs, high, j);
                swap(xs, low, high);
            }
        }

        swap(xs, high + 1, r);

        return new int[]{low + 1, high + 1};
    }

    private static void swap(int[] xs, int i, int j) {
        int tmp = xs[i];
        xs[i] = xs[j];
        xs[j] = tmp;
    }
}
