package Recursion;

public class Print1ToN {
    public static void main(String[] args) {
        print1ToN(10);
        System.out.println();
        print1ToN(3);
    }

    private static void print1ToN(int n) {
        if (n == 0) {
            return;
        }
        print1ToN(n - 1);
        System.out.print(n + " ");
    }
}
