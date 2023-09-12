package Bitwise;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(4));
        System.out.println(!isPowerOfTwo(6));
        System.out.println(isPowerOfTwo(8));
        System.out.println(!isPowerOfTwo(0));

    }

    //time complexity = O(1)
    private static boolean isPowerOfTwo(int number) {
        if (number == 0) {
            return false;
        }
        return (number & (number - 1)) == 0;
    }
}
