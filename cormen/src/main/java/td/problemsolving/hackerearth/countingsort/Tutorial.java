package td.problemsolving.hackerearth.countingsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

/**
 * Counting Sort. Tutorial
 * https://www.hackerearth.com/practice/algorithms/sorting/counting-sort/tutorial/
 */
public class Tutorial {
    int max(int[] xs) {
        int max = xs[0];

        for (int x : xs) {
            if (x > max) max = x;
        }

        return max;
    }

    Stream<String> solve(int[] xs) {
        int[] aux = new int[max(xs) + 1];

        for (int x : xs) {
            aux[x]++;
        }

        Stream.Builder<String> builder = Stream.builder();

        for (int i = 0; i < aux.length; i++) {
            if (aux[i] > 0) {
                builder.add(i + " " + aux[i]);
            }
        }

        return builder.build();
    }

    public static void main(String args[]) throws Exception {
        FastReader fastReader = new FastReader(System.in);

        int[] xs = new int[fastReader.nextInt()];
        for (int i = 0; i < xs.length; i++) {
            xs[i] = fastReader.nextInt();
        }

        new Tutorial().solve(xs).forEach(System.out::println);
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
                    InputStreamReader(Tutorial.class.getResourceAsStream(filename)));
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
