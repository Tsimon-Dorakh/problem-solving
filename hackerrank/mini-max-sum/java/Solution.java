import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Mini-Max Sum
 * https://www.hackerrank.com/challenges/one-month-preparation-kit-mini-max-sum/problem
 */
public class Solution {
    public static void miniMaxSum(List<Integer> xs) {
        Collections.sort(xs);

        long lowSum = 0L;
        for (int i = 0; i < 4; i++) {
            lowSum += xs.get(i);
        }

        long highSum = 0L;
        for (int i = 1; i < 5; i++) {
            highSum += xs.get(i);
        }

        System.out.println(lowSum + " " + highSum);
    }

    public static void main(String[] args) {
        miniMaxSum(getTestCase("input-00.txt"));
    }

    private static List<Integer> getTestCase(String name) {
        return convertInput(name);
    }

    private static List<Integer> convertInput(String name) {
        Scanner scanner = new Scanner(new InputStreamReader(Solution.class.getResourceAsStream(name)));

        List<Integer> xs = new ArrayList<>();

        while (scanner.hasNextInt()) {
            xs.add(scanner.nextInt());
        }

        return xs;
    }
}
