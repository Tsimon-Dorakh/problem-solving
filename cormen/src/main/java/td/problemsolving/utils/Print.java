package td.problemsolving.utils;

import java.util.ArrayList;

public class Print {
    public static void print(ArrayList<Integer> xs) {
        for (Object x : xs) {
            System.out.print(x.toString() + ", ");
        }

        System.out.println();
    }

    public static void printXss(ArrayList<ArrayList<Integer>> xss) {
        for (ArrayList<Integer> xs : xss) {
            print(xs);
        }
    }

    public static void print(char[] xs) {
        for (char x : xs) {
            System.out.print(x + ", ");
        }

        System.out.println();
    }

    public static void print(boolean[] xs) {
        for (boolean x : xs) {
            System.out.print((x ? 't' : 'f') + ", ");
        }

        System.out.println();
    }

    public static void print(int[] xs) {
        for (int x : xs) {
            System.out.print(x + ", ");
        }

        System.out.println();
    }

    public static void print(Integer[] xs) {
        for (int x : xs) {
            System.out.print(x + ", ");
        }

        System.out.println();
    }

    public static void print(long[] xs) {
        for (long x : xs) {
            System.out.print(x + ", ");
        }

        System.out.println();
    }

    public static void print(int[][] xss) {
        for (int[] xs : xss) {
            print(xs);
        }

    }
}
