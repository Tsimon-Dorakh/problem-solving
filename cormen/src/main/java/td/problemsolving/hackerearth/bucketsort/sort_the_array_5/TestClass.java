package td.problemsolving.hackerearth.bucketsort.sort_the_array_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * Descending Weights
 * https://www.hackerearth.com/practice/algorithms/sorting/bucket-sort/practice-problems/algorithm/sort-the-array-5/
 */
public class TestClass {
    String solve(int[] xs, int k) {
        StringBuilder stringBuilder = new StringBuilder();

        List<Integer>[] xss = new ArrayList[k];
        for (int i = 0; i < xss.length; i++) {
            xss[i] = new ArrayList<>();
        }

        for (int x : xs) {
            xss[x % k].add(x);
        }

        for (int i = xss.length - 1; i >= 0; i--) {
            xss[i].sort(Comparator.comparingInt(a -> a));

            stringBuilder.append(xss[i].stream().map(String::valueOf).collect(Collectors.joining(" "))).append(" ");
        }

        return stringBuilder.toString().trim();
    }

    public static void main(String args[]) throws Exception {
        TestClass.FastReader fastReader = new TestClass.FastReader(System.in);

        int[] xs = new int[fastReader.nextInt()];
        int k = fastReader.nextInt();
        for (int i = 0; i < xs.length; i++) {
            xs[i] = fastReader.nextInt();
        }

        System.out.println(new TestClass().solve(xs, k));
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
