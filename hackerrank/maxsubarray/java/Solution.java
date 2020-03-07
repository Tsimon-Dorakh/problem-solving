import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.StringTokenizer;

public class Solution {
    private static int maxSubsequenceSum(int[] xs) {
        int max = Integer.MIN_VALUE;

        boolean hasNaturalOrZero = false;
        int sum = 0;

        for (int x: xs) {
            if (!hasNaturalOrZero && x < 0) {
                max = Math.max(max, x);
            } else if (x >= 0) {
                hasNaturalOrZero = true;
                sum += x;
                max = sum;
            }
        }

        return max;
    }

    private static int getMaxMidSum(int[] xs, int l, int r) {
        int m = (l + r) / 2;

        int i = m - 1;
        int lsum = xs[m];
        int lmax = lsum;
        while (i >= l) {
            lsum += xs[i--];
            lmax = Math.max(lmax, lsum);
        }

        i = m + 1;
        int rsum = xs[m];
        int rmax = rsum;
        while (i <= r) {
            rsum += xs[i++];
            rmax = Math.max(rmax, rsum);
        }

        return lmax + rmax - xs[m];
    }

    private static int maxSumArrayOnLogn(int[] xs, int l, int r) {
        if (l == r) return xs[l];

        int m = (l + r) / 2;
        int lSum = maxSumArrayOnLogn(xs, l, m);
        int rSum = maxSumArrayOnLogn(xs, m + 1, r);
        int mSum = getMaxMidSum(xs, l, r);

        if (lSum > rSum && lSum > mSum) return lSum;
        else if (rSum > lSum && rSum > mSum) return rSum;
        else return mSum;
    }

    private static int maxSumArrayOnLogn(int[] xs) {
        return maxSumArrayOnLogn(xs, 0, xs.length - 1);
    }

    /**
     * Kadane's algorithm
     */
    private static int maxSumArrayOn(int[] xs) {
        int max = xs[0];
        int cmax = xs[0];

        for (int i = 1; i < xs.length; i++) {
            cmax = Math.max(cmax + xs[i], xs[i]);
            max = Math.max(max, cmax);
        }

        return max;
    }

    private static int maxSumArrayOn2(int[] xs) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < xs.length; i++) {
            int sum = xs[i];
            max = Math.max(max, sum);

            for (int j = i + 1; j < xs.length; j++) {
                sum += xs[j];
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    private static int[] maxSubarray(int[] xs) {
        return new int[]{maxSumArrayOn(xs), maxSubsequenceSum(xs)};
    }

    public static void main(String[] args) {
        int[][] xss = readInput(new FastReader("input-00-2.txt"));
//        int[][] xss = readInput(new FastReader("input00.txt"));
//        int[][] xss = readInput(new FastReader(System.in));

        for (int[] xs: xss) {
            print(maxSubarray(xs));
        }

//        int[] xs = new int[]{2, -1, 3, -6, 5};
//        print(getMaxMidSum(xs, 0, xs.length - 1));
    }

    private static void println(int x) {
        System.out.println(x);
    }

    private static void println(long x) {
        System.out.println(x);
    }

    private static void print(Collection xs) {
        StringBuilder stringBuilder = new StringBuilder(xs.size() * 2);

        xs.forEach(x -> stringBuilder.append(x).append(" "));

        System.out.println(stringBuilder.toString());
    }

    private static void print(int x) {
        System.out.println(x);
    }

    private static void print(int[] xs) {
        for (int x : xs) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    private static void print(int[][] xss) {
        for (int[] xs : xss) {
            print(xs);
        }
    }

    static int[][] readInput(FastReader fastReader) {
        int[][] xss = new int[fastReader.nextInt()][];

        for (int i = 0; i < xss.length; i++) {
            xss[i] = new int[fastReader.nextInt()];

            for (int j = 0; j < xss[i].length; j++) {
                xss[i][j] = fastReader.nextInt();
            }
        }

        return xss;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        public FastReader(InputStream inputStream) {
            br = new BufferedReader(new
                    InputStreamReader(inputStream));
        }

        public FastReader(String filename) {
            br = new BufferedReader(new
                    InputStreamReader(Solution.class.getResourceAsStream(filename)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }
    }
}
