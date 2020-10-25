package td.problemsolving.hackerrank.ArrayManipulation;

import java.util.Scanner;

/**
 * Array Manipulation
 * https://www.hackerrank.com/challenges/crush/problem
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        Range[] xs = new Range[n + 1];

        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();

            if (xs[a] == null) xs[a] = new Range();
            if (xs[b] == null) xs[b] = new Range();

            xs[a].start += k;
            xs[b].end += k;
        }
        in.close();

        long max = 0;
        long curr = 0;

        for (Range x: xs) {
            if (x == null) continue;

            curr += x.start;
            max = Math.max(max, curr);
            curr -= x.end;

        }

        System.out.println(max);
    }

    static class Range {
        int start = 0;
        int end = 0;
    }
}
