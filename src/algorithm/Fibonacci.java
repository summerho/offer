package algorithm;

/**
 * 斐波那契数列
 */
public class Fibonacci {

    public static long fibonacci(int n) {
        long firstNum = 0;
        long secondNum = 1;
        long fibNum = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            fibNum = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = fibNum;
        }
        return fibNum;
    }

    public static void main(String[] args) {
        System.out.print(fibonacci(30));
    }
}
