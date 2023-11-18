package Bitwise;

public class CountSetBitsTillN {
    public static void main(String[] args) {
        System.out.println(countSetBits(100000000) == 1314447116);
        System.out.println(countSetBits(17) == 35);
    }

    public static int countSetBits(int n) {
        // Your code here
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int largestPowerOfTwo = (int) (Math.log(n) / Math.log(2));
        int setBits = 0;
        //counting setBits till (largest power of 2) - 1
        setBits += largestPowerOfTwo * Math.pow(2, largestPowerOfTwo - 1);
        //counting MSB of numbers after (largest power of 2) - 1
        setBits += n - Math.pow(2, largestPowerOfTwo) + 1;
        //counting setBits after removing MSB of numbers after (largest power of 2) - 1
        setBits += countSetBits(n - (int) Math.pow(2, largestPowerOfTwo));
        return setBits;
    }
}
