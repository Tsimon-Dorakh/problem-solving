import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Plus Minus
 * https://www.hackerrank.com/challenges/three-month-preparation-kit-plus-minus/problem
 */
public class Solution {
    public static void plusMinus(List<Integer> xs) {
        int posN = 0;
        int negN = 0;
        int zerN = 0;

        for (Integer x : xs) {
            if (x > 0) posN++;
            if (x < 0) negN++;
            if (x == 0) zerN++;
        }

        System.out.printf("%.6f\n", 1. * posN / xs.size());
        System.out.printf("%.6f\n", 1. * negN / xs.size());
        System.out.printf("%.6f\n", 1. * zerN / xs.size());
    }

    public static void main(String[] args) {
        plusMinus(getTestCase("input-00.txt"));
    }

    private static List<Integer> getTestCase(String name) {
        return convertInput(name);
    }

    private static List<Integer> convertInput(String name) {
        Scanner scanner = new Scanner(new InputStreamReader(Solution.class.getResourceAsStream(name)));

        List<Integer> xs = new ArrayList<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            xs.add(scanner.nextInt());
        }

        return xs;
    }
}
