package Bitwise;

public class CountSetBits {
    public static void main(String[] args) {
        System.out.println(countSetBits(5) == 2);
        System.out.println(countSetBits(7) == 3);
        System.out.println(countSetBits(13) == 3);
        System.out.println(countSetBits(0) == 0);
        System.out.println(countSetBits(1) == 1);

        System.out.println(countSetBitsBrian(5) == 2);
        System.out.println(countSetBitsBrian(7) == 3);
        System.out.println(countSetBitsBrian(13) == 3);
        System.out.println(countSetBitsBrian(0) == 0);
        System.out.println(countSetBitsBrian(1) == 1);

        int[] setBitsIn8bit = setBitsIn8bitPreprocessing();
        System.out.println(countSetBitsFastest(5, setBitsIn8bit) == 2);
        System.out.println(countSetBitsFastest(7, setBitsIn8bit) == 3);
        System.out.println(countSetBitsFastest(13, setBitsIn8bit) == 3);
        System.out.println(countSetBitsFastest(0, setBitsIn8bit) == 0);
        System.out.println(countSetBitsFastest(1, setBitsIn8bit) == 1);
    }

    //time complexity = O(number of bits)
    private static int countSetBits(int number) {
        int count = 0;
        int bits = 31;
        //Iterate 31 bits instead of checking number != 0 because of negative numbers
        while(bits-- >= 0) {
            if((number & 1) == 1) {
                count++;
            }
            number = number >> 1;
        }
        return count;
    }

    //Brian Kernighan's algorithm. time complexity = O(number of set bits)
    private static int countSetBitsBrian(int number) {
        int result = 0;
        while (number != 0) {
            number = number & (number - 1);
            result++;
        }
        return result;
    }

    //Most effective algorithm. time complexity = O(1)
    private static int countSetBitsFastest(int number, int[] setBitsIn8bit) {
        int result = 0;
        while (number > 0) {
            result += setBitsIn8bit[number & 255];
            number = number >> 8;
        }
        return result;
    }

    private static int[] setBitsIn8bitPreprocessing() {
        int[] setBits = new int[256];
        for (int iter=0; iter<256; iter++) {
            setBits[iter] = countSetBitsBrian(iter);
        }
        return setBits;
    }
}
