package td.problemsolving.cormen.countingsort;

public class CountingSort {
    public static int[] countingSort(int[] xs, int k) {
        int[] ys = new int[k + 1];
        int[] zs = new int[xs.length];

        for (int x : xs) {
            ys[x]++;
        }

        for (int i = 1; i <= k; i++) {
            ys[i] += ys[i - 1];
        }

        for (int i = xs.length - 1; i >= 0; i--) {
            zs[ys[xs[i]] - 1] = xs[i];
            ys[xs[i]]--;
        }

        return zs;
    }

    public static int[] countingSortInverted(int[] xs, int k) {
        int[] ys = new int[k + 1];
        int[] zs = new int[xs.length];

        for (int x : xs) {
            ys[x]++;
        }

        for (int i = 1; i <= k; i++) {
            ys[i] += ys[i - 1];
        }

        for (int i = 0; i < xs.length; i++) {
            zs[ys[xs[i]] - 1] = xs[i];
            ys[xs[i]]--;
        }

        return zs;
    }
}
