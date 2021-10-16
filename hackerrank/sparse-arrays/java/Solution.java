import java.io.InputStreamReader;
import java.util.*;

/**
 * Sparse Arrays
 * https://www.hackerrank.com/challenges/sparse-arrays/problem
 */
public class Solution {
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        Map<String, Integer> map = new HashMap<>();

        for (String s: strings) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (String q: queries) {
            result.add(map.getOrDefault(q, 0));
        }

        return result;
    }

    public static void main(String[] args) {
        List<String>[] testCase = getTestCase("input-00.txt");
        System.out.println(matchingStrings(testCase[0], testCase[1]));

        testCase = getTestCase("input-01.txt");
        System.out.println(matchingStrings(testCase[0], testCase[1]));

        testCase = getTestCase("input-02.txt");
        System.out.println(matchingStrings(testCase[0], testCase[1]));
    }

    private static List<String>[] getTestCase(String name) {
        Scanner scanner = new Scanner(new InputStreamReader(Solution.class.getResourceAsStream(name)));

        int n = scanner.nextInt();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings.add(scanner.next());
        }

        int q = scanner.nextInt();
        List<String> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            queries.add(scanner.next());
        }

        return new List[]{strings, queries};
//        return convertInput(name);
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
