import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Heap Sort - Tutorial
 * https://www.hackerearth.com/practice/algorithms/sorting/heap-sort/tutorial/
 */
public class TestClass {
    private static void solveWithTreeSet(FastReader fastReader) {
        int size = fastReader.nextInt();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            treeSet.add(fastReader.nextInt());

            if (i < 2) {
                System.out.println(-1);
            } else {
                Integer max1 = treeSet.pollLast();
                Integer max2 = treeSet.pollLast();
                Integer max3 = treeSet.pollLast();

                System.out.println("" + max1 + " " + max2 + " " + max3);

                treeSet.add(max1);
                treeSet.add(max2);
                treeSet.add(max3);
            }
        }
    }

    private static void maintainInvariant(int[] xs) {
        if (xs[2] > xs[1]) swap(xs, 2, 1);
        if (xs[1] > xs[0]) swap(xs, 1, 0);
    }

    private static void solveWithVars(FastReader fastReader) {
        int size = fastReader.nextInt();
        int[] xs = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int i = 0; i < size; i++) {
            int x = fastReader.nextInt();

            if (x > xs[2]) {
                xs[2] = x;
                maintainInvariant(xs);
            }

            if (i >= 2) {
                System.out.println("" + xs[0] + " " + xs[1] + " " + xs[2]);
            } else {
                System.out.println(-1);
            }
        }
    }

    private static void solveWithMaxPriorityQueue(FastReader fastReader) {
        int size = fastReader.nextInt();
        MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueue(size);

        for (int i = 0; i < size; i++) {
            maxPriorityQueue.insert(fastReader.nextInt());

            if (i < 2) {
                System.out.println(-1);
            } else {
                int max1 = maxPriorityQueue.extractMax();
                int max2 = maxPriorityQueue.extractMax();
                int max3 = maxPriorityQueue.extractMax();

                System.out.println("" + max1 + " " + max2 + " " + max3);

                maxPriorityQueue.insert(max1);
                maxPriorityQueue.insert(max2);
                maxPriorityQueue.insert(max3);
            }
        }
    }

    public static void main(String args[]) {
//        FastReader fastReader = new FastReader("input-00.txt");
        FastReader fastReader = new FastReader(System.in);

        solveWithMaxPriorityQueue(fastReader);
//        solveWithVars(fastReader);
//        solveWithTreeSet(fastReader);
    }

    static class MaxPriorityQueue extends MaxHeap {
        public MaxPriorityQueue(MaxPriorityQueue maxPriorityQueue) {
            super(maxPriorityQueue);
        }

        public MaxPriorityQueue(int maxSize) {
            super(maxSize);
        }

        int extractMax() {
            if (heapSize < 1) {
                throw new RuntimeException("Heap underflow");
            }

            int max = xs[1];
            xs[1] = xs[heapSize];
            heapSize--;
            maxHeapify(1);

            return max;
        }

        void insert(int x) {
            heapSize++;
            xs[heapSize] = Integer.MIN_VALUE;
            increaseKey(heapSize, x);
        }

        int maximum() {
            return xs[1];
        }

        private void increaseKey(int i, int key) {
            if (key < xs[i]) {
                throw new RuntimeException("New key is smaller than current key");
            }
            xs[i] = key;
            while (i > 1 && xs[parent(i)] < xs[i]) {
                int tmp = xs[i];
                xs[i] = xs[parent(i)];
                xs[parent(i)] = tmp;

                i = parent(i);
            }
        }

        @Override
        public String toString() {
            return super.toString();
        }

        public String toSortedString() {
            StringBuilder output = new StringBuilder();

            MaxPriorityQueue copy = new MaxPriorityQueue(this);
            while (copy.getSize() > 0) {
                output.append(" ").append(copy.extractMax());
            }

            return output.toString();
        }

    }

    static class MaxHeap {
        int[] xs;
        int heapSize = 0;

        public MaxHeap(MaxHeap maxHeap) {
            xs = Arrays.copyOfRange(maxHeap.xs, 0, maxHeap.xs.length);
            heapSize = maxHeap.heapSize;
        }

        public MaxHeap(int maxSize) {
            xs = new int[maxSize + 1];
        }

        void maxHeapify(int i) {
            int l = left(i);
            int r = right(i);

            int largest = i;
            if (l <= heapSize && xs[l] > xs[i]) {
                largest = l;
            }
            if (r <= heapSize && xs[r] > xs[largest]) {
                largest = r;
            }

            if (largest != i) {
                int tmp = xs[i];
                xs[i] = xs[largest];
                xs[largest] = tmp;

                maxHeapify(largest);
            }
        }

        public int getSize() {
            return heapSize;
        }

        private int left(int i) {
            return 2 * i;
        }

        private int right(int i) {
            return 2 * i + 1;
        }

        protected int parent(int i) {
            return (int) Math.floor(i / 2.);
//            return i >> 1;
        }

        @Override
        public String toString() {
            return Arrays.stream(xs).mapToObj(String::valueOf).collect(Collectors.joining(","));
        }
    }

    static int[] readInput(FastReader fastReader) {
        int[] xs = new int[fastReader.nextInt()];

        for (int i = 0; i < xs.length; i++) {
            xs[i] = fastReader.nextInt();
        }

        return xs;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        public FastReader(InputStream inputStream) {
            br = new BufferedReader(new
                    InputStreamReader(inputStream));
        }

        public FastReader(String filename) {
            br = new BufferedReader(new
                    InputStreamReader(TestClass.class.getResourceAsStream(filename)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }
    }

    private static void print(int[] xs) {
        for (int x : xs) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    private static void swap(int[] xs, int i, int j) {
        int tmp = xs[i];
        xs[i] = xs[j];
        xs[j] = tmp;
    }
}
