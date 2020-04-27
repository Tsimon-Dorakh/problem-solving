import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Raghu Vs Sayan
 * https://www.hackerearth.com/practice/algorithms/sorting/heap-sort/practice-problems/algorithm/raghu-vs-sayan/description/
 */
public class TestClass {
    static void solveTestCase(TestCase testCase) {
        testCase.dishes = heapSort(testCase.dishes);

        for (int i = 0; i < testCase.dishes.length; i++) {
            if (testCase.RaghuAmount >= testCase.dishes[i]) {
                testCase.RaghuAmount -= testCase.dishes[i];
                testCase.RaghuAte++;
            }
            if (testCase.SayanAmount >= testCase.dishes[i]) {
                testCase.SayanAmount -= testCase.dishes[i];
                testCase.SayanAte++;
            }
        }

        if (testCase.RaghuAte > testCase.SayanAte) {
            System.out.println("Raghu Won");
        } else if (testCase.SayanAte > testCase.RaghuAte) {
            System.out.println("Sayan Won");
        } else {
            System.out.println("Tie");
        }
    }

    public static void main(String args[]) {
//        FastReader fastReader = new FastReader("input-00.txt");
        FastReader fastReader = new FastReader(System.in);

        readTestCases(fastReader).forEach(TestClass::solveTestCase);
    }

    static int[] heapSort(int[] xs) {
        MaxHeap maxHeap = buildMaxHeap(xs);

        for (int i = maxHeap.size; i >= 2; i--) {
            swap(maxHeap.xs, i, 1);
            maxHeap.size--;
            maxHeap.maxHeapify(1);
        }

        return Arrays.copyOfRange(maxHeap.xs, 1, maxHeap.xs.length);
    }

    static MaxHeap buildMaxHeap(int[] xs) {
        MaxHeap maxHeap = new MaxHeap();

        maxHeap.size = xs.length;
        maxHeap.xs = new int[maxHeap.size + 1];
        System.arraycopy(xs, 0, maxHeap.xs, 1, maxHeap.size);

        for (int i = maxHeap.size >> 1; i >= 1; i--) {
            maxHeap.maxHeapify(i);
        }

        return maxHeap;
    }

    static class MaxHeap {
        private int size;
        private int[] xs;

        void maxHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int largest = i;

            if (l <= size && xs[l] > xs[largest]) {
                largest = l;
            }
            if (r <= size && xs[r] > xs[largest]) {
                largest = r;
            }
            if (largest != i) {
                swap(xs, largest, i);
                maxHeapify(largest);
            }
        }

        int left(int i) {
            return 2 * i;
        }

        int right(int i) {
            return 2 * i + 1;
        }

        int parent(int i) {
            return i >> 1;
        }

        @Override
        public String toString() {
            return Arrays.stream(xs).mapToObj(String::valueOf).collect(Collectors.joining(","));
        }
    }

    static void print(int[] xs) {
        System.out.println(Arrays.stream(xs).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    private static void swap(int[] xs, int i, int j) {
        int tmp = xs[i];
        xs[i] = xs[j];
        xs[j] = tmp;
    }

    static List<TestCase> readTestCases(FastReader fastReader) {
        List<TestCase> testCases = new ArrayList<>();

        int count = fastReader.nextInt();
        while (count-- > 0) {
            testCases.add(readTestCase(fastReader));
        }

        return testCases;
    }

    static TestCase readTestCase(FastReader fastReader) {
        TestCase testCase = new TestCase();

        testCase.RaghuAmount = fastReader.nextInt();
        testCase.SayanAmount = fastReader.nextInt();
        testCase.dishes = new int[fastReader.nextInt()];

        for (int i = 0; i < testCase.dishes.length; i++) {
            testCase.dishes[i] = fastReader.nextInt();
        }

        return testCase;
    }

    static class TestCase {
        int RaghuAte = 0;
        int SayanAte = 0;

        int RaghuAmount;
        int SayanAmount;
        int[] dishes;
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
}
