import java.math.BigInteger;

/**
 * In this programming assignment you will implement one or more of the integer
 * multiplication algorithms described in lecture.
 *
 * To get the most out of this assignment, your program should restrict itself
 * to multiplying only pairs of single-digit numbers. You can implement
 * the grade-school algorithm if you want, but to get the most out of the assignment
 * you'll want to implement recursive integer multiplication
 * and/or Karatsuba's algorithm.
 *
 * So: what's the product of the following two 64-digit numbers?
 *
 * 3141592653589793238462643383279502884197169399375105820974944592
 *
 * 2718281828459045235360287471352662497757247093699959574966967627
 */
public class Main {
    static String javaBasedSolution(String x, String y) {
        return new BigInteger(x).multiply(new BigInteger(y)).toString();
    }

    public static void main(String[] args) {
        System.out.println(javaBasedSolution(
                "3141592653589793238462643383279502884197169399375105820974944592",
                "2718281828459045235360287471352662497757247093699959574966967627"
        ));
    }

}
