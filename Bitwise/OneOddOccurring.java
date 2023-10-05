package Bitwise;

public class OneOddOccurring {
    public static void main(String[] args) {
        System.out.println(findOneOddOccurring(new int[]{1, 2, 3, 3, 2}) == 1);
        System.out.println(findOneOddOccurring(new int[]{2, 2, 3, 3, 2}) == 2);
        System.out.println(findOneOddOccurring(new int[]{1, 2, 3, 5, 2, 3, 1}) == 5);
        System.out.println(findOneOddOccurring(new int[]{1}) == 1);
        System.out.println(findOneOddOccurring(new int[]{0, 0, 0, 1, 1}) == 0);
    }

    //Best use of XOR operator
    //time complexity = O(n) //auxiliary space complexity = O(1)
    private static int findOneOddOccurring(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result = result ^ number;
        }
        return result;
    }
}
