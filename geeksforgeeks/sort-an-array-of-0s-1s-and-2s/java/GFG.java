import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Sort an array of 0s, 1s and 2s
 * https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s/0
 */
public class GFG {
    private static int[] sortJava(int[] xs) {
        Arrays.sort(xs);

        return xs;
    }

    private static int[] sortOn(int[] xs) {
        int[] c = new int[3];

        for (int x : xs) {
            c[x]++;
        }

        for (int i = 0; i < xs.length; i++) {
            xs[i] =
                    c[0]-- > 0 ? 0 :
                            c[1]-- > 0 ? 1 : 2;
        }

        return xs;
    }

    static private void swap(int[] xs, int i, int j) {
        int t = xs[i];
        xs[i] = xs[j];
        xs[j] = t;
    }

    private static int[] sortOnDutchNationalFlagAlgorithm(int[] xs) {
        int l = 0;
        int m = 0;
        int h = xs.length - 1;

        while (m <= h) {
            if (xs[m] == 0) {
                swap(xs, l++, m++);
            } else if (xs[m] == 1) {
                m++;
            } else {
                swap(xs, m, h--);
            }
        }

        return xs;
    }

    public static void main(String[] args) {
//        int[][] xss = readInput(new FastReader("input-00-0.txt"));
        int[][] xss = readInput(new FastReader(System.in));

//        print(xss);

        for (int[] xs : xss) {
            print(sortOnDutchNationalFlagAlgorithm(xs));
//            print(new GFG().maxLen(xs));
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
