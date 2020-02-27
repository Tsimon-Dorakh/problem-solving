import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem
 */
public class Solution {
    static int sum(int[][] xss, int x, int y) {
        return
                xss[x - 1][y - 1] + xss[x - 1][y] + xss[x - 1][y + 1] +
                xss[x][y] +
                xss[x + 1][y - 1] + xss[x + 1][y] + xss[x + 1][y + 1];
    }

    static int hourglassSum(int[][] xss) {
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < xss.length - 1; i++) {
            for (int j = 1; j < xss.length - 1; j++) {
                max = Math.max(max, sum(xss, i, j));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        print(hourglassSum(getTestCase00()));
    }

    private static int[][] getTestCase00() {
        return convertInput(readResource("input-00.txt"));
    }

    private static int[][] convertInput(String input) {
        String[] rows = input.split("\n");

        int[][] xss = new int[rows.length][];

        Arrays.stream(rows)
                .map(s ->
                        Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray()
                ).collect(Collectors.toList()).toArray(xss);

        return xss;
    }

    private static String readResource(String name) {
        return new BufferedReader(new InputStreamReader(Solution.class.getResourceAsStream(name)))
                .lines().collect(Collectors.joining("\n"));
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
