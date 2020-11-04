package td.problemsolving.hackerrank.MaximumXor;

/**
 * Maximum Xor
 * https://www.hackerrank.com/challenges/maximum-xor/problem
 */
public class Solution {
    static int[] maxXor(int[] arr, int[] queries) {
        return trieSolution(arr, queries);
    }

    static int[] trieSolution(int[] arr, int[] queries) {
        Node root = new Node();

        for (int x: arr) {
            insert(root, x);
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            result[i] = query(root, queries[i]);
        }

        return result;
    }

    static int query(Node node, int q) {
        int[] xs = toInvertedBinary(q);

        for (int x: xs) {
            if (x == 1 && node.right != null) node = node.right;
            else if (x == 0 && node.left != null) node = node.left;
            else if (node.right != null) node = node.right;
            else node = node.left;
        }

        return node.number ^ q;
    }

    static void insert(Node node, int n) {
        for (int x: toBinary(n)) {
            if (x == 0) {
                Node left = node.left != null ? node.left : new Node();
                node.left = left;
                node = left;
            } else {
                Node right = node.right != null ? node.right : new Node();
                node.right = right;
                node = right;
            }
        }

        node.number = n;
    }

    static int[] toInvertedBinary(int x) {
        int[] xs = toBinary(x);

        for (int i = 0; i < xs.length; i++) {
            xs[i] ^= 1;
        }

        return xs;
    }

    static int[] toBinary(int x) {
        int[] bin = new int[31];

        for (int i = 0; i < 31; i++) {
            bin[30 - i] = (x & (1 << i)) > 0 ? 1 : 0;
        }

        return bin;
    }

    static void printNode(Node node) {
        if (node == null) return;

        printNode(node.left);
        System.out.printf("(%d) ", node.number);
        printNode(node.right);
    }

    static class Node {
        Node left;
        Node right;
        Integer number;

        public String toString() {
            return "(" + number + ")";
        }
    }

    static int[] bruteForce(int[] xs, int[] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int max = Integer.MIN_VALUE;

            for (int x: xs) {
                max = Math.max(max, queries[i] ^ x);
            }

            result[i] = max;
        }

        return result;
    }
}
