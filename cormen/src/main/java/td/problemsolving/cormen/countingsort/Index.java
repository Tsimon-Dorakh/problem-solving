package td.problemsolving.cormen.countingsort;

public class Index {
    private int[] index;

    static Index create(int[] xs, int k) {
        Index index = new Index();

        index.index = new int[k + 1];

        for (int x : xs) {
            index.index[x]++;
        }

        for (int i = 1; i <= k; i++) {
            index.index[i] += index.index[i - 1];
        }

        return index;
    }

    int query(int a, int b) {
        if (a == 0) {
            return index[b];
        } else {
            return index[b] - index[a - 1];
        }
    }
}
