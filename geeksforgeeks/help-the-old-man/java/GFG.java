import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Help the Old Man!!!
 * https://practice.geeksforgeeks.org/problems/help-the-old-man/0
 */
public class GFG {
    private static String nthTurn = null;

    private static int hanoiTurn(int stopAt, int turns,
                                  int n, int from, int to, int aux) {
        if (n == 1) {
            if (stopAt == turns) {
                if (nthTurn == null)  nthTurn = String.format("%d %d", from, to);

                return turns;
            }

            return turns + 1;
        } else {
            turns = hanoiTurn(stopAt, turns, n - 1, from, aux, to);

            if (stopAt == turns) {
                if (nthTurn == null)  nthTurn = String.format("%d %d", from, to);

                return turns;
            }

            turns++;

            return hanoiTurn(stopAt, turns, n - 1, aux, to, from);
        }
    }

    private static void hanoi(List<String> turns,
                              int n, int from, int to, int aux) {
        if (n == 1) {
            turns.add(String.format("%d -> %d", from, to));
        } else {
            hanoi(turns, n - 1, from, aux, to);
            turns.add(String.format("%d -> %d", from, to));
            hanoi(turns, n - 1, aux, to, from);
        }
    }

    private static void hanoi(int n) {
        List<String> turns = new ArrayList<>();

        hanoi(turns, n, 1, 3, 2);

        for (String turn : turns) {
            System.out.println(turn);
        }
        System.out.println(turns.size());
    }

    public static void main(String[] args) {
//        int[][] xss = readInput(new FastReader(System.in));
        int[][] xss = readInput(new FastReader("input-00-0.txt"));

        for (int[] xs: xss) {
            hanoi(xs[0]);
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
