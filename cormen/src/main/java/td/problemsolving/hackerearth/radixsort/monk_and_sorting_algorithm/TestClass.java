package td.problemsolving.hackerearth.radixsort.monk_and_sorting_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Monk and Sorting Algorithm
 * https://www.hackerearth.com/practice/algorithms/sorting/radix-sort/practice-problems/algorithm/monk-and-sorting-algorithm/
 */
public class TestClass {
    private int getNthPart(long x, int n) {
        x = x / (int)Math.pow(10, 5 * (n - 1));
        int y = 0;

        for (int i = 0; i < 5; i++) {
            long d = (x % 10);
            x = x / 10;

            y += d * Math.pow(10, i);
        }

        return y;
    }

    private long[] radixSortChunk(long[] xs, int n) {
        long[] zs = new long[xs.length];
        int[] aux = new int[100000];

        for (long x : xs) {
            aux[getNthPart(x, n)]++;
        }

        for (int i = 1; i < aux.length; i++) {
            aux[i] += aux[i - 1];
        }

        for (int i = xs.length - 1; i >= 0; i--) {
            zs[aux[getNthPart(xs[i], n)] - 1] = xs[i];
            aux[getNthPart(xs[i], n)]--;
        }

        return zs;
    }

    long getMax(long[] xs) {
        long max = Long.MIN_VALUE;

        for (long x : xs) {
            max = Math.max(x, max);
        }

        return max;
    }

    private int getChunkCount(long x) {
        return (int)Math.ceil(String.valueOf(x).length() / 5.);
    }

    Stream<String> solve(long[] xs) {
        Stream.Builder<String> builder = Stream.builder();

        int chunkCount = getChunkCount(getMax(xs));
        for (int i = 1; i <= chunkCount; i++) {
            xs = radixSortChunk(xs, i);

            String row = Arrays.stream(xs).boxed().map(String::valueOf).collect(Collectors.joining(" "));
            builder.add(row);
        }
        return builder.build();
    }

    public static void main(String args[]) throws Exception {
        TestClass.FastReader fastReader = new TestClass.FastReader(System.in);

        long[] xs = new long[fastReader.nextInt()];
        for (int i = 0; i < xs.length; i++) {
            xs[i] = fastReader.nextLong();
        }

        new TestClass().solve(xs).forEach(System.out::println);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(InputStream inputStream) {
            br = new BufferedReader(new
                    InputStreamReader(inputStream));
        }

        public FastReader(String filename) {
            br = new BufferedReader(new
                    InputStreamReader(TestClass.class.getResourceAsStream(filename)));
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
