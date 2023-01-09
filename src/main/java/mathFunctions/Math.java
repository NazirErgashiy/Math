package mathFunctions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This Math class has a basic math functions
 */
public class Math {

    private Map<Long, Long> factorialMap = new HashMap();
    private Map<Long, Long> fibonacciMap = new HashMap();

    /**
     * Basic factorial function
     *
     * @param n is input
     * @return is factorial of n
     */
    public long factorial(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Ожидается положительный параметр!");
        }

        if (n == 0) return 1;

        if (factorialMap.containsKey(n)) {
            return factorialMap.get(n);
        }

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        factorialMap.put(n, result);
        return result;
    }
    /**
     * Fibonacci function
     *
     * @param n is input
     * @return is result of fibonacci function
     */
    public long fibonacci(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Ожидается положительный параметр!");
        }

        if (fibonacciMap.containsKey(n)) {
            return fibonacciMap.get(n);
        }

        long num0 = 1;
        long num1 = 1;
        long num2 = 1;
        for (int i = 3; i <= n; i++) {
            num2 = num0 + num1;
            num0 = num1;
            num1 = num2;
        }
        fibonacciMap.put(n, num2);
        return num2;
    }

    /**
     * Can we build a Triangle
     *
     * @param a length of the first side of Triangle
     * @param b length of the second side of Triangle
     * @param c length of the third side of Triangle
     * @return boolean if true we can build triangle with these sides
     */
    public boolean isTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }

        if (a + b > c && a + c > b && b + c > a) {
            return true;
        }

        return false;
    }

    /**
     * read the same in both directions
     * @param str input string
     * @return boolean
     * example{
     * Anna -> true
     * Law -> false
     * }
     */
    public boolean isPalindrome(String str) {

        if (str == null) {
            throw new IllegalArgumentException("Недопустим пустой параметр!");
        }

        str = str.toLowerCase();

        char[] charInput = str.toCharArray();
        for (int i = 0; i < charInput.length; i++) {
            if (charInput[i] != charInput[charInput.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * squared array
     * @param arr input integers
     * @return arr²
     */
    public int[] powerOfTwo(int[] arr) {
        int[] tempArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i] * arr[i];
        }

        Arrays.sort(tempArr);

        return tempArr;
    }

    /**
     * squared array using streamAPI
     * @param arr input integers
     * @return arr²
     */
    public Integer[] powerOfTwoStream(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .map(integer -> integer * integer)
                .sorted()
                .collect(Collectors.toList())
                .toArray(new Integer[0]);
    }
}
