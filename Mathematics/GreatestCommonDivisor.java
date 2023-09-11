package Mathematics;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(greatestCommonDivisor(75, 100) == 25);
        System.out.println(greatestCommonDivisor(13, 27) == 1);
        System.out.println(greatestCommonDivisor(20, 60) == 20);
    }

    //greatest common divisor or highest common factor
    protected static int greatestCommonDivisor(int first, int second) {
        int remainder = 1;
        while (remainder != 0) {
            remainder = first % second;
            first = second;
            second = remainder;
        }
        return first;
    }
}
