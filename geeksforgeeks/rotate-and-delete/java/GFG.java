import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static void runFromStdIn() {
        int[][] xss = readInput();

        for (int[] xs : xss) {
            println(runTestCase(xs));
        }
    }

    public static void main(String[] args) {
        runFromStdIn();

//        print(xss);
//        int[] xs = new int[]{1, 2, 3, 4, 5, 6};

//        print(rotateClockwiseByOneM1(xs));

//        int[] xs = new int[]{1, 2, 3, 4};
//        xs = rotateClockwiseByOne(xs);
//        println(runTestCase(xs));
//        xs = deleteElement(xs, 4);
//        print(xs);
    }

    static int runTestCase(int[] xs) {
        for (int i = 0; i < xs.length - 1; i++) {
            xs = deleteElement(rotateClockwiseByOneM1(xs), i + 1);
        }

        return xs[0];
    }

    static int[] deleteElement(int[] xs, int k) {
        int yi = 0;
        int[] ys = new int[xs.length - 1];

        for (int xi = 0; xi < xs.length; xi++) {
            if (xi != getDeletingIndex(xs, k)) {
                ys[yi++] = xs[xi];
            }
        }

        return ys;
    }

    static int getDeletingIndex(int[] xs, int k) {
        return Math.max(0, xs.length - k);
    }

    static int[] rotateClockwiseByOneM1(int[] xs) {
        int l = xs[xs.length - 1];

        for (int i = xs.length - 1; i > 0; i--) {
            xs[i] = xs[i - 1];
        }

        xs[0] = l;

        return xs;
    }

    static int[] rotateClockwiseByOne(int[] xs) {
        int[] ys = new int[xs.length];
        ys[0] = xs[xs.length - 1];

        System.arraycopy(xs, 0, ys, 1, xs.length - 1);

        return ys;
    }

    static void println(int x) {
        System.out.println(x);
    }

    static void print(int[] xs) {
        for (int x : xs) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static void print(int[][] xss) {
        for (int[] xs : xss) {
            print(xs);
        }
    }

    static int[][] readInput() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[][] xss = new int[t][];

        for (int i = 0; i < t; i++) {
            xss[i] = new int[scanner.nextInt()];

            for (int j = 0; j < xss[i].length; j++) {
                xss[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        return xss;
    }
}
