import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Sequence of Sequence
 * https://practice.geeksforgeeks.org/problems/sequence-of-sequence/0
 */
public class GFG {
    private static int solve(int l, int r, int n) {
        int total = 0;

        if (n == 1) {
            return r - l + 1;
        } else {
            while (l * Math.pow(2, n - 1) <= r) {
                total += solve(l * 2, r, n - 1);
                l++;
            }
        }

        return total;
    }

    private static int solve(int m, int n) {
        return solve(1, m, n);
    }

    public static void main(String[] args) {
        int[][] xss = readInput(new FastReader("input-00-0.txt"));
//        int[][] xss = readInput(new FastReader(System.in));

//        print(xss);

        for (int[] xs : xss) {
            print(solve(xs[0], xs[1]));
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
