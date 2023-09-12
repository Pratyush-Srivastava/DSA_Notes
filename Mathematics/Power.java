package Mathematics;

public class Power {
    public static void main(String[] args) {
        System.out.println(power(2, 5) == 32);
        System.out.println(power(3, 2) == 9);
        System.out.println(power(20, 0) == 1);
        System.out.println(power(4, 3) == 64);

        System.out.println(powerIterative(2, 5) == 32);
        System.out.println(powerIterative(3, 2) == 9);
        System.out.println(powerIterative(20, 0) == 1);
        System.out.println(powerIterative(4, 3) == 64);
    }

    //recursive solution with time complexity O(log exponent) and auxiliary space complexity O(exponent)
    private static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent % 2 == 0) {
            return power(base, exponent / 2) * power(base, exponent / 2);
        } else {
            return base * power(base, exponent - 1);
        }
    }

    //iterative solution with time complexity O(log exponent) and auxiliary space complexity O(1)
    private static int powerIterative(int base, int exponent) {
        int result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = result * base;
            }
            base = base * base;
            exponent = exponent / 2;
        }
        return result;
    }
}
