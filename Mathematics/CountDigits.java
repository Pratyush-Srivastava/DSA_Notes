package Mathematics;

public class CountDigits {
    public static void main(String[] args) {
        System.out.println(countDigits(1572) == 4);
        System.out.println(countDigits(0) == 0);
        System.out.println(countDigits(1) == 1);
        System.out.println(countDigits(10) == 2);
    }

    private static int countDigits(int number) {
        int numberOfDigits = 0;
        while (number > 0) {
            number = number / 10;
            numberOfDigits++;
        }
        return numberOfDigits;
    }
}
