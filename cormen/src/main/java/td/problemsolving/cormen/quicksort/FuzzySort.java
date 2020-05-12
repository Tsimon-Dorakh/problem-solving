package td.problemsolving.cormen.quicksort;

import static td.problemsolving.utils.Print.print;

public class FuzzySort {
    public static int sort(int[][] xss) {
        return sort(xss, 0, xss.length - 1, 0);
    }

    static int sort(int[][] xss, int lo, int hi, int level) {
        level += 1;

        if (lo < hi) {
            swap(xss, random(lo, hi), hi);

            int q = partition(xss, lo, hi);
            level = Math.max(
                sort(xss, lo, q - 1, level),
                sort(xss, q + 1, hi, level)
            );
        }

        return level;
    }

    static int partition(int[][] xss, int lo, int hi) {
        int i = lo - 1;

        for (int j = lo; j < hi; j++) {
            if (isLessOrEqualInterval(xss[j], xss[hi])) {
                i += 1;

                swap(xss, i, j);
            }
        }

        swap(xss, i + 1, hi);

        return i + 1;
    }

    static int sort_(int[][] xss) {
        return sort_(xss, 0, xss.length - 1, 0);
    }

    static int sort_(int[][] xss, int lo, int hi, int level) {
        if (lo < hi) {
            swap(xss, random(lo, hi), hi);
            int[] intersection = findIntersection(xss, lo, hi);
            int[] idxs = partition_(xss, intersection, lo, hi);

            level = Math.max(
                    sort_(xss, lo, idxs[0] - 1, level + 1),
                    sort_(xss, idxs[1] + 1, hi, level + 1)
            );
        }

        return level;
    }

    static int[] partition_(int[][] xss, int[] intersection, int lo, int hi) {
        int i = lo - 1;
        int k = lo - 1;

        for (int j = lo; j < hi; j++) {
            if (isIntersect(xss[j], intersection)) {
                k += 1;

                swap(xss, k, j);
            } else if (isLessOrEqualInterval(xss[j], intersection)) {
                i += 1;
                k += 1;

                swap(xss, k, j);
                swap(xss, i, k);
            }
        }

        swap(xss, k + 1, hi);

        return new int[]{i + 1, k + 1};
    }

    private static int[] findIntersection(int[][] xss, int lo, int hi) {
        int a = xss[hi][0];
        int b = xss[hi][1];

        for (int i = lo; i < hi; i++) {
            if (xss[i][0] <= b && xss[i][1] >= a) {
                if (xss[i][0] > a) {
                    a = xss[i][0];
                }
                if (xss[i][1] < b) {
                    b = xss[i][1];
                }
            }
        }

        return new int[]{a, b};
    }

    private static boolean isIntersect(int[] a, int[] b) {
        return (a[0] >= b[0] && a[0] <= b[1]) ||
                (a[1] >= b[0] && a[1] <= b[1]);
    }

    static boolean isLessOrEqualInterval(int[] a, int[] b) {
        return b[1] >= a[0];
    }

    private static void swap(int[][] xss, int i, int j) {
        int[] tmp = xss[i];
        xss[i] = xss[j];
        xss[j] = tmp;
    }

    private static int random(int a, int b) {
        return a + (int) (Math.random() * (b - a));
    }
}
