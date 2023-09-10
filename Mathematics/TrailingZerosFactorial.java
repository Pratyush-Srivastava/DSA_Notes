package Mathematics;

public class TrailingZerosFactorial {
    public static void main(String[] args) {
        System.out.println(trailingZerosInFactorialOfNumber(56) == 13);
        System.out.println(trailingZerosInFactorialOfNumber(50) == 12);
        System.out.println(trailingZerosInFactorialOfNumber(5) == 1);
        System.out.println(trailingZerosInFactorialOfNumber(4) == 0);
        System.out.println(trailingZerosInFactorialOfNumber(10) == 2);
        System.out.println(trailingZerosInFactorialOfNumber(251) == 62);
    }

    //time complexity: O(log n)
    //space complexity: O(1)
    private static int trailingZerosInFactorialOfNumber(int n) {
        int trailingZeros = 0;
        while(n > 0) {
            n = (int) Math.floor(n / 5.0);
            trailingZeros = trailingZeros + n;
        }
        return trailingZeros;
    }
}
