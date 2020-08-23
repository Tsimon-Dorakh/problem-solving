package td.problemsolving.interviewbit.Flip;

import java.util.ArrayList;

/**
 * Flip
 * https://www.interviewbit.com/problems/flip/
 */
public class Solution {
    public ArrayList<Integer> flip(String s) {
        return nSolutionKadane(s);
    }

    ArrayList<Integer> nSolutionKadane(String s) {
        int[] xs = new int[s.length()];
        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '1') xs[i] = -1;
            else xs[i] = 1;
        }

        int max = 0;
        int maxCurr = 0;
        int r = 0;
        for (int i = 0; i < xs.length; i++) {
            maxCurr = Math.max(0, maxCurr + xs[i]);

            if (maxCurr > max) {
                r = i;
                max = maxCurr;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        if (max == 0) return result;

        int l = r;
        for (int i = r; i >=0; i--) {
            max += -xs[i];

            if (max == 0) l = i;
        }

        result.add(l + 1);
        result.add(r + 1);

        return result;
    }

    ArrayList<Integer> nSolution(String s) {
        char[] xs = s.toCharArray();
        ArrayList<Integer> result = new ArrayList<>();
        int max = 0;

        int current = 0;
        int maxPos = -1;
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] == '0') current++;
            else current = Math.max(0, current - 1);
            if (current > max) {
                max = current;
                maxPos = i;
            }
        }

        if (maxPos == -1) return result;

        int i;
        int minPos = maxPos;
        for (i = maxPos; i >= 0; i--) {
            if (xs[i] == '0') max--;
            else max++;

            if (max == 0) minPos = i;
        }

        result.add(minPos + 1);
        result.add(maxPos + 1);

        return result;
    }

    ArrayList<Integer> n2Solution(String s) {
        char[] xs = s.toCharArray();
        int max = countOnes(xs);
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < xs.length; i++) {
            for (int j = 0; j < xs.length; j++) {
                char[] ys = doFlip(xs, i, j);
                int count = countOnes(ys);

                if (count > max) {
                    max = count;

                    result = new ArrayList<>();
                    result.add(i + 1);
                    result.add(j + 1);
                }
            }
        }

        return result;
    }


    char[] doFlip(char[] xs, int start, int end) {
        char[] ys = new char[xs.length];

        for (int i = 0; i < xs.length; i++) {
            if (i >= start && i <= end) {
                if (xs[i] == '0') ys[i] = '1';
                else ys[i] = '0';
            } else {
                ys[i] = xs[i];
            }
        }

        return ys;
    }

    int countOnes(char[] xs) {
        int count = 0;

        for (char x : xs) {
            if (x == '1') count++;
        }

        return count;
    }
}
