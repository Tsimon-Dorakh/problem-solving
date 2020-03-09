import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Find the element that appears once in sorted array
 * https://practice.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array/0
 */
public class GFG {
    private static String solve(String[] xs, int l, int r) {
        if (l == r) return xs[l];

        int m = (l + r) / 2;

        if (m % 2 == 0) {
            if (xs[m].equals(xs[m + 1])) return solve(xs, m + 2, r);
            else return solve(xs, l, m);
        } else {
            if (xs[m].equals(xs[m + 1])) return solve(xs, l, m - 1);
            else return solve(xs, m + 1, r);
        }
    }

    private static String solve(String[] xs) {
        return solve(xs, 0, xs.length - 1);
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader("input-00-0.txt");
//        FastReader reader = new FastReader(System.in);
//        int[][] xss = readInput(new FastReader("input-00-0.txt"));
//        int[][] xss = readInput(new FastReader(System.in));

//        print(xss);

        int t = reader.nextInt();
        while (t-- > 0) {
            print(solve(readCase(reader)));
        }
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

    private static void print(String x) {
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

    static String[] readCase(FastReader fastReader) {
        String[] xs = new String[fastReader.nextInt()];

        for (int i = 0; i < xs.length; i++) {
            xs[i] = fastReader.next();
        }

        return xs;
    }

    static int[][] readInput(FastReader fastReader) {
        int[][] xss = new int[fastReader.nextInt()][];

        for (int i = 0; i < xss.length; i++) {
            xss[i] = new int[2];

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
                    InputStreamReader(GFG.class.getResourceAsStream(filename)));
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
