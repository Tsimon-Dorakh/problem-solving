import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Missing number in array
 * https://practice.geeksforgeeks.org/problems/missing-number-in-array/0
 */
public class GFG {
    private static int xorSolution(int[] xs) {
        int a = xs[0];
        int b = 1;

        for (int i = 1; i < xs.length; i++) {
            a = a ^ xs[i];
        }

        for (int i = 2; i <= xs.length + 1; i++) {
            b = b ^ i;
        }

        return a ^ b;
    }

    private static long sumSolution(int[] xs) {
        long sum = (xs.length + 1) * (xs.length + 2) / 2;

        for (int x : xs) {
            sum -= x;
        }

        return sum;
    }

    private static int setSolution(int[] xs) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= xs.length + 1; i++) {
            set.add(i);
        }

        for (int i = 0; i < xs.length; i++) {
            set.remove(xs[i]);
        }

        return set.iterator().next();
    }

    public static void main(String[] args) {
//        int[][] xss = readInput(new FastReader("input-00-0.txt"));
        int[][] xss = readInput(new FastReader(System.in));

        for (int[] ints : xss) {
            println(xorSolution(ints));
        }
    }

    private static void println(int x) {
        System.out.println(x);
    }

    private static void println(long x) {
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
            xss[i] = new int[fastReader.nextInt() - 1];

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
