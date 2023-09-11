package Mathematics;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        System.out.println(leastCommonMultiple(12, 15) == 60);
        System.out.println(leastCommonMultiple(2, 8) == 8);
        System.out.println(leastCommonMultiple(7, 3) == 21);
    }

    private static int leastCommonMultiple(int first, int second) {
        return (first * second) / GreatestCommonDivisor.greatestCommonDivisor(first, second);
    }
}
