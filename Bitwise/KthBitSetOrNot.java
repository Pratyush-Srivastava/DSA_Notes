package Bitwise;

public class KthBitSetOrNot {
    public static void main(String[] args) {
        System.out.println(isKthBitSet(5, 1));
        System.out.println(!isKthBitSet(8, 2));
        System.out.println(!isKthBitSet(0, 3));
    }

    private static boolean isKthBitSet(int number, int k) {
        return (number & (int) Math.pow(2, k-1)) != 0;
    }
}
