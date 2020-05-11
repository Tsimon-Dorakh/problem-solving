package td.problemsolving.cormen.utils;

public class Print {
    public static void print(int[] xs) {
        for (int x : xs) {
            System.out.print(x + ", ");
        }

        System.out.println();
    }
}
