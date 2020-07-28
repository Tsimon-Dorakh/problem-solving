package td.problemsolving.utils;

import java.util.ArrayList;

public class Print {
    public static void print(ArrayList<Integer> xs) {
        for (Object x : xs) {
            System.out.print(x.toString() + ", ");
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

    public static void print(int[][] xss) {
        for (int[] xs : xss) {
            print(xs);
        }

    }
}
