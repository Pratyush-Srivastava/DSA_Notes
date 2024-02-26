package Bitwise;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596) == 964176192);
    }
    // you need treat n as an unsigned value
    private static int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int lsb = n & 1;
            res += (lsb == 1)? (1 << (31 - i )): 0;//Basically you are adding 2^31 for last bit and so on
            n = n >> 1;
        }
        return res;
    }
}
