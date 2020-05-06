package td.problemsolving.cormen.youngtableaus;

public class YoungTableausFn {
    static YoungTableaus createEmpty(int m, int n) {
        YoungTableaus youngTableaus = new YoungTableaus();
        youngTableaus.m = m;
        youngTableaus.n = n;
        youngTableaus.xss = new int[youngTableaus.m][];

        for (int i = 0; i < youngTableaus.m; i++) {
            youngTableaus.xss[i] = new int[youngTableaus.n];

            for (int j = 0; j < youngTableaus.n; j++) {
                youngTableaus.xss[i][j] = YoungTableaus.INFINITY;
            }
        }

        return youngTableaus;
    }

    static YoungTableaus create(int[][] xss) {
        YoungTableaus youngTableaus = createEmpty(xss.length, xss[0].length);

        for (int[] xs : xss) {
            for (int x : xs) {
                insert(youngTableaus, x);
            }
        }

        return youngTableaus;
    }

    static boolean hasValues(YoungTableaus youngTableaus) {
        return youngTableaus.xss[0][0] != YoungTableaus.INFINITY;
    }

    static boolean isFull(YoungTableaus youngTableaus) {
        return youngTableaus.xss[youngTableaus.xss.length - 1][youngTableaus.xss[0].length - 1] != YoungTableaus.INFINITY;
    }

    static boolean hasValue(YoungTableaus youngTableaus, int value) {
        for (int i = 0; i < youngTableaus.xss.length; i++) {
            for (int j = 0; j < youngTableaus.xss[0].length; j++) {
                if (youngTableaus.xss[i][j] == value) {
                    return true;
                }
            }
        }

        return false;
    }

    static void insert(YoungTableaus youngTableaus, int value) {
        if (isFull(youngTableaus)) {
            throw new IllegalArgumentException();
        }

        youngTableaus.xss[youngTableaus.xss.length - 1][youngTableaus.xss[0].length - 1] = value;

        bubbleValue(youngTableaus, youngTableaus.xss.length - 1, youngTableaus.xss[0].length - 1);
    }

    private static void bubbleValue(YoungTableaus youngTableaus, int i, int j) {
        int maxI = i;
        int maxJ = j;

        if (i - 1 >= 0 && youngTableaus.xss[i - 1][j] > youngTableaus.xss[maxI][maxJ]) {
            maxI = i - 1;
            maxJ = j;
        }
        if (j - 1 >= 0 && youngTableaus.xss[i][j - 1] > youngTableaus.xss[maxI][maxJ]) {
            maxI = i;
            maxJ = j - 1;
        }

        if (i != maxI || j != maxJ) {
            int tmp = youngTableaus.xss[i][j];
            youngTableaus.xss[i][j] = youngTableaus.xss[maxI][maxJ];
            youngTableaus.xss[maxI][maxJ] = tmp;

            bubbleValue(youngTableaus, maxI, maxJ);
        }
    }

    static int extractMin(YoungTableaus youngTableaus) {
        if (!hasValues(youngTableaus)) {
            throw new IllegalArgumentException();
        }

        int min = youngTableaus.xss[0][0];

        youngTableaus.xss[0][0] = YoungTableaus.INFINITY;
        keepYoungTableaus(youngTableaus, 0, 0);

        return min;
    }

    private static void keepYoungTableaus(YoungTableaus youngTableaus, int i, int j) {
        int smallestI = i;
        int smallestJ = j;

        if (i + 1 < youngTableaus.xss.length && youngTableaus.xss[smallestI][smallestJ] > youngTableaus.xss[i + 1][j]) {
            smallestI = i + 1;
            smallestJ = j;
        }
        if (j + 1 < youngTableaus.xss[i].length && youngTableaus.xss[smallestI][smallestJ] > youngTableaus.xss[i][j + 1]) {
            smallestI = i;
            smallestJ = j + 1;
        }

        if (i != smallestI || j != smallestJ) {
            int tmp = youngTableaus.xss[smallestI][smallestJ];
            youngTableaus.xss[smallestI][smallestJ] = youngTableaus.xss[i][j];
            youngTableaus.xss[i][j] = tmp;

            keepYoungTableaus(youngTableaus, smallestI, smallestJ);
        }
    }
}
