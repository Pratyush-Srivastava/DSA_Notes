package Recursion;

public class PalindromeRecursion {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abba", 0));
        System.out.println(isPalindrome("a", 0));
        System.out.println(!isPalindrome("ba", 0));
    }

    private static boolean isPalindrome(String input, int iter) {
        if (iter > input.length() - iter - 1) {
            return true;
        }
        return input.charAt(iter) == input.charAt(input.length() - iter - 1) && isPalindrome(input, iter + 1);
    }
}
