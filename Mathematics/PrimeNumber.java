package Mathematics;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(!isPrimeNumber(1));
        System.out.println(isPrimeNumber(2));
        System.out.println(isPrimeNumber(3));
        System.out.println(!isPrimeNumber(4));
        System.out.println(isPrimeNumber(5));
        System.out.println(isPrimeNumber(101));
    }

    //validating only till square root of n because factors exist in pairs, and they end at square root. example: 1X36, 2X18, 3X12, 4X9, 6X6
    private static boolean isPrimeNumber(int number) {
        int iter = 2;
        if (number == 1) {
            return false;
        }
        while (iter <= Math.sqrt(number)) {
            if (number % iter == 0) {
                return false;
            }
            iter++;
        }
        return true;
    }
}
