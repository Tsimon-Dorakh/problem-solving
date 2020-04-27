import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Cube Change
 * https://www.hackerearth.com/practice/algorithms/sorting/heap-sort/practice-problems/algorithm/cube-change-qualifier2/
 */
public class TestClass {
    static BigInteger solve(long x) {
        if (x == 1) return BigInteger.valueOf(1);

        BigInteger bigInteger = BigInteger.valueOf(x - 2);
        bigInteger = bigInteger.pow(2);
        bigInteger = bigInteger.multiply(BigInteger.valueOf(6));

        bigInteger = bigInteger.add(BigInteger.valueOf(x - 2).multiply(BigInteger.valueOf(12)));
        bigInteger = bigInteger.add(BigInteger.valueOf(8));

        return bigInteger;
/*
        return
                6 * (long) Math.pow(x - 2, 2) +
                6 * 2 * (x - 2) +
                2 * 4;
*/
    }

    public static void main(String args[]) {
//            FastReader fastReader = new FastReader("input-00.txt");
//            FastReader fastReader = new FastReader("input-01.txt");
        FastReader fastReader = new FastReader(System.in);

        int c = fastReader.nextInt();
        while (c-- > 0) {
            System.out.println(solve(fastReader.nextLong()));
        }
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
