package Mathematics;

public class Palindrome {
    //if number is equal to reverse of a number, then it is called palindrome number
    public static void main(String[] args) {
        System.out.println(reverseOfNumber(70726) == 62707);
        System.out.println(reverseOfNumber(12350) == 5321);
        System.out.println(palindrome(909909));
        System.out.println(palindrome(2772));
    }

    private static boolean palindrome(int number) {
        return number == reverseOfNumber(number);
    }

    private static int reverseOfNumber(int number) {
        int lastDigit;
        int reverse = 0;
        while (number > 0) {
            lastDigit = number % 10;
            reverse = reverse * 10 + lastDigit;
            number = number / 10;
        }
        return reverse;
    }
}
