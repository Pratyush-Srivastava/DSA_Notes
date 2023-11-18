package Recursion;

public class IsLuckyNumber {
    public static void main(String[] args) {
        System.out.println(isLuckyNumber(19, 2));
        System.out.println(isLuckyNumber(7, 2));
        System.out.println(isLuckyNumber(23, 2));
    }

    private static boolean isLuckyNumber(int n, int counter) {
        if (n < counter) {
            return true;
        }
        if (n % counter == 0) {
            return false;
        }
        return isLuckyNumber(n - n / counter, counter + 1);
    }
}
