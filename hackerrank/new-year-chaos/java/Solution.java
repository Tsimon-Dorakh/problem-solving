import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/new-year-chaos/problem
 */
public class Solution {
    static void minimumBribesOn2(int[] xs) {
        int total = 0;

        for (int i = 0; i < xs.length; i++) {
            if (xs[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, xs[i] - 2); j < i; j++) {
                if (xs[j] > xs[i]) total++;
            }
        }

        System.out.println(total);
    }

    static void minimumBribesOn(int[] xs) {
        int total = 0;

        for (int i = xs.length - 1; i >= 0; i--) {
            if (xs[i] != (i + 1)) {
                if (i - 1 >= 0 && xs[i - 1] == i + 1) {
                    xs[i - 1] = xs[i];
                    xs[i] = i + 1;
                    total++;
                } else if (i - 2 >= 0 && xs[i - 2] == i + 1) {
                    xs[i - 2] = xs[i - 1];
                    xs[i - 1] = xs[i];
                    xs[i] = i + 1;
                    total += 2;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }

        System.out.println(total);
    }

    public static void main(String[] args) {
        int[][] xss = getTestCase("input-01.txt");

        for (int[] ints : xss) {
            minimumBribesOn(ints);
        }
    }

    private static int[][] getTestCase(String name) {
        return convertInput(name);
    }

    private static int[][] convertInput(String name) {
        Scanner scanner = new Scanner(new InputStreamReader(Solution.class.getResourceAsStream(name)));

        int[][] xss = new int[scanner.nextInt()][];

        for (int t = 0; t < xss.length; t++) {
            xss[t] = new int[scanner.nextInt()];
            for (int i = 0; i < xss[t].length; i++) {
                xss[t][i] = scanner.nextInt();
            }
        }

        return xss;
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
}
