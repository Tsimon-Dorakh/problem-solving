import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Majority Element
 * https://practice.geeksforgeeks.org/problems/majority-element/0
 */
public class GFG {
    private static int mooresVotingAlgorithm(int[] xs) {
        int a_pos = 0;
        int count = 1;

        for (int i = 1; i < xs.length; i++) {
            if (xs[i] == xs[a_pos]) {
                count++;
            } else {
                count--;

                if (count == 0) {
                    a_pos = i;
                    count = 1;
                }
            }
        }

        count = 0;
        for (int x: xs) {
            if (x == xs[a_pos]) count++;
        }

        return count > xs.length / 2 ? xs[a_pos] : -1;
    }

    private static int solve(int[] xs) {
        int max = Arrays.stream(xs).max().getAsInt();
        int[] ys = new int[max + 1];

        for (int x: xs) {
            ys[x]++;

            if (ys[x] > xs.length / 2) {
                return x;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[][] xss = readInput(new FastReader("input-00-0.txt"));
        int[][] xss = readInput(new FastReader(System.in));

        for (int[] ints : xss) {
            println(mooresVotingAlgorithm(ints));
//            println(solve(ints));
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
