import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/minimum-swaps-2/problem
public class Solution {
    static int minimumSwapsOn(int[] xs) {
        Boolean[] visited = new Boolean[xs.length];
        Arrays.fill(visited, false);

        int swaps = 0;

        for (int i = 0; i < xs.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            if (xs[i] != i - 1) {
                int next = xs[i] - 1;
                while (!visited[next]) {
                    swaps++;
                    visited[next] = true;
                    next = xs[next] - 1;
                }
            }
        }

        return swaps;
    }

    static int minimumSwapsOn2(int[] xs) {
        int swaps = 0;

        for (int i = 0; i < xs.length - 1; i++) {
            if (xs[i] != i + 1) {
                for (int j = i + 1; j < xs.length; j++) {
                    if (xs[j] == i + 1) {
                        xs[j] = xs[i];
                        xs[i] = i + 1;
                        swaps++;
                    }
                }
            }
        }

        return swaps;
    }

    static int minimumSwaps(int[] xs) {
        return minimumSwapsOn(xs);
    }

    public static void main(String[] args) {
        int[] xs = getTestCase("input-00-2.txt");

        print(minimumSwaps(xs));
    }

    private static int[] getTestCase(String name) {
        return convertInput(name);
    }

    private static int[] convertInput(String name) {
        Scanner scanner = new Scanner(new InputStreamReader(Solution.class.getResourceAsStream(name)));

        int[] xs = new int[scanner.nextInt()];

        for (int i = 0; i < xs.length; i++) {
            xs[i] = scanner.nextInt();
        }

        return xs;
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
