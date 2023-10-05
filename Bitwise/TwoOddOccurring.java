package Bitwise;

public class TwoOddOccurring {
    public static void main(String[] args) {
        int[] twoOddOccurringNumbers = findTwoOddOccurringNumbers(new int[]{3, 2, 4, 4, 5, 5, 5, 5});
        System.out.println(twoOddOccurringNumbers[0] == 2);
        System.out.println(twoOddOccurringNumbers[1] == 3);

        twoOddOccurringNumbers = findTwoOddOccurringNumbers(new int[]{3, 5});
        System.out.println(twoOddOccurringNumbers[0] == 5);
        System.out.println(twoOddOccurringNumbers[1] == 3);
    }

    //time complexity = O(n) auxiliary space complexity = O(1)
    private static int[] findTwoOddOccurringNumbers(int[] numbers) {
        int result1 = 0;
        int result2 = 0;
        int xorTwoOddOccur = 0;
        for (int number : numbers) {
            xorTwoOddOccur = xorTwoOddOccur ^ number;
        }
        int lastSetBitWithRemainingZeros = lastSetBitWithRemainingZeros(xorTwoOddOccur);
        for (int number : numbers) {
            if ((number & lastSetBitWithRemainingZeros) == 0) {
                result1 = result1 ^ number;
            } else {
                result2 = result2 ^ number;
            }
        }
        return new int[]{result1, result2};
    }

    //last set bit with remaining zeros. 10100 will become 00100
    private static int lastSetBitWithRemainingZeros(int xorTwoOddOccur) {
        // xorTwoOddOccur & ~(xorTwoOddOccur -1);
        return xorTwoOddOccur & -xorTwoOddOccur;
    }
}
