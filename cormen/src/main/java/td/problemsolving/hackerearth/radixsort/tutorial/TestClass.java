package td.problemsolving.hackerearth.radixsort.tutorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Radix Sort. Tutorial
 * https://www.hackerearth.com/practice/algorithms/sorting/radix-sort/tutorial/
 */
public class TestClass {
    private int getMaxDigits(int[] xs) {
        int max = xs[0];

        for (int x : xs) {
            max = Math.max(x, max);
        }

        return String.valueOf(max).length();
    }

    private int getDthDigit(int x, int d) {
        return (x / (int)Math.pow(10, d - 1)) % 10;
    }

    private int[] radixSort(int[] xs, int d) {
        int[] zs = new int[xs.length];
        int[] aux = new int[10];

        for (int x : xs) {
            aux[getDthDigit(x, d)]++;
        }

        for (int i = 1; i < aux.length; i++) {
            aux[i] += aux[i - 1];
        }

        for (int i = xs.length - 1; i >= 0; i--) {
            zs[aux[getDthDigit(xs[i], d)] - 1] = xs[i];
            aux[getDthDigit(xs[i], d)]--;
        }

        return zs;
    }

    Stream<String> solve(int[] xs) {
        int d = getMaxDigits(xs);

        Stream.Builder<String> builder = Stream.builder();

        for (int i = 1; i <= d; i++) {
            xs = radixSort(xs, i);
            String row = Arrays.stream(xs).boxed().map(String::valueOf).collect(Collectors.joining(" "));

            builder.add(row);
        }

        return builder.build();
    }

    public static void main(String args[]) throws Exception {
        FastReader fastReader = new FastReader(System.in);

        int[] xs = new int[fastReader.nextInt()];
        for (int i = 0; i < xs.length; i++) {
            xs[i] = fastReader.nextInt();
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
