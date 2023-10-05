package Recursion;

public class SumOfDigitsRecursive {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(213));
        System.out.println(sumOfDigits(0));
        System.out.println(sumOfDigits(10000000));
    }

    private static int sumOfDigits(int number) {
        if (number == 0) {
            return 0;
        }
        return (number % 10) + sumOfDigits(number / 10);
    }
}
