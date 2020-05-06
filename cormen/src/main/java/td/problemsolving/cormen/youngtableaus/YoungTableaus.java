package td.problemsolving.cormen.youngtableaus;

public class YoungTableaus {
    static int INFINITY = Integer.MAX_VALUE;

    int m;
    int n;
    int[][] xss;

    static void print(YoungTableaus youngTableaus) {
        int largestNumberLength = getLargestNumberLength(youngTableaus);

        for (int i = 0; i < youngTableaus.m; i++) {
            for (int j = 0; j < youngTableaus.n; j++) {
                if (youngTableaus.xss[i][j] == INFINITY) {
                    System.out.printf("%" + largestNumberLength + "s ", "Inf");
                } else {
                    System.out.printf("%" + largestNumberLength + "d ", youngTableaus.xss[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static int getLargestNumberLength(YoungTableaus youngTableaus) {
        if (youngTableaus.xss[0][0] == INFINITY) {
            return getInfinityLength();
        }

        int largest = Math.abs(youngTableaus.xss[0][0]);

        for (int i = 0; i < youngTableaus.m; i++) {
            for (int j = 0; j < youngTableaus.n; j++) {
                if (youngTableaus.xss[i][j] != INFINITY) {
                    largest = Math.max(largest, Math.abs(youngTableaus.xss[i][j]));
                }
            }
        }

        return 1 + getNumberLength(largest);
    }

    private static int getNumberLength(int n) {
        if (n < 10) {
            return 1;
        } else {
            return 1 + getNumberLength(n / 10);
        }
    }

    private static int getInfinityLength() {
        return 3;
    }
}
