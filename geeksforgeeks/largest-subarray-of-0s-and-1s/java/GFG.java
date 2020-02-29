import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Largest subarray of 0's and 1's
 * https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1
 */
public class GFG {
    int maxLenOn3(int[] xs) {
        int max = 0;

        for (int i = 0; i < xs.length; i++) {
            for (int j = 0; j < xs.length; j++) {
                int c0 = 0;
                int c1 = 0;

                for (int k = i; k <= j; k++) {
                    if (xs[k] == 0) c0++;
                    else c1++;
                }

                if (c0 == c1) max = Math.max(max, c0 * 2);
            }
        }

        return max;
    }

    int maxLenOn2(int[] xs) {
        int max = 0;

        for (int i = 0; i < xs.length; i++) {
            int c0 = 0;
            int c1 = 0;
            for (int j = i; j < xs.length; j++) {
                if (xs[j] == 0) c0++;
                else c1++;

                if (c0 == c1) max = Math.max(max, c0 * 2);
            }
        }

        return max;
    }

    int maxLenOn(int[] xs) {
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] == 0) xs[i] = -1;
        }
        int maxLen = 0;
        int cSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < xs.length; i++) {
            cSum += xs[i];

            if (cSum == 0) {
                maxLen = i + 1;
            } else if (!map.containsKey(cSum)) {
                map.put(cSum, i);
            } else {
                maxLen = Math.max(maxLen, i - map.get(cSum));
            }
        }

        return maxLen;
    }

    int maxLen(int[] xs) {
        return maxLenOn(xs);
    }

    public static void main(String[] args) {
        int[][] xss = readInput(new FastReader("input-00-0.txt"));
//        int[][] xss = readInput(new FastReader(System.in));

//        print(xss);

        for (int[] xs : xss) {
            print(new GFG().maxLen(xs));
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
