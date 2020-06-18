package td.problemsolving.hackerearth.bucketsort.tutorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Bucket Sort. Tutorial
 * https://www.hackerearth.com/practice/algorithms/sorting/bucket-sort/tutorial/
 */
public class TestClass {
    Stream<String> solve(int[] xs) {
        int bucketCount = 0;

        for (int x : xs) {
            bucketCount = Math.max(bucketCount, Integer.bitCount(x));
        }

        List<Integer>[] xss = new ArrayList[bucketCount + 1];
        for (int i = 1; i < xss.length; i++) {
            xss[i] = new ArrayList<>();
        }

        for (int x : xs) {
            xss[Integer.bitCount(x)].add(x);
        }

        Stream.Builder<String> builder = Stream.builder();

        for (int i = 1; i < xss.length; i++) {
            xss[i].sort(Comparator.comparingInt(a -> a));

            String row = xss[i].stream().map(String::valueOf).collect(Collectors.joining(" "));
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
