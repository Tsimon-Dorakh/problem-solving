package td.problemsolving.interviewbit.largest_number;

/**
 * Largest Number
 * https://www.interviewbit.com/problems/largest-number/
 */
public class LargestNumber {
    private void mergeSort(int[] xs, int lo, int hi) {
        if (lo >= hi) return;

        int mid = (lo + hi) / 2;
        mergeSort(xs, lo, mid);
        mergeSort(xs, mid + 1, hi);

        int[] ys = new int[xs.length];
        for (int i = lo; i <= hi; i++) {
            ys[i] = xs[i];
        }

        int i = lo;
        int l = lo;
        int r = mid + 1;

        while (l <= mid && r <= hi) {
            if (compareCustom(ys[l], ys[r]) > 0) {
                xs[i++] = ys[l++];
            } else {
                xs[i++] = ys[r++];
            }
        }

        while (l <= mid) xs[i++] = ys[l++];
        while (r <= hi) xs[i++] = ys[r++];
    }

    public String largestNumber(final int[] xs) {
        mergeSort(xs, 0, xs.length - 1);

        StringBuilder stringBuilder = new StringBuilder();

        for (int x : xs) {
            if (x != 0 || stringBuilder.length() != 0) {
                stringBuilder.append(x);
            }
        }

        return stringBuilder.length() > 0 ? stringBuilder.toString() : "0";
    }

    private int compareCustom(int x, int y) {
        String o1 = x + String.valueOf(y);
        String o2 = y + String.valueOf(x);

        return o1.compareTo(o2);
    }
}
