package Arrays;

import java.util.Arrays;
import java.util.List;

public class MaxEvenOddLength {
    public static void main(String[] args) {
        System.out.println(maxEvenOddLength(Arrays.asList(10, 12, 14, 7, 8)));
        System.out.println(maxEvenOddLength(Arrays.asList(7, 10, 13, 14)));
        System.out.println(maxEvenOddLength(Arrays.asList(10, 12, 8, 4)));
    }

    private static int maxEvenOddLength(List<Integer> integers) {
        int maxEvenOddLength = 1;
        for (int i = 0; i < integers.size() - 1; i++) {
            if (integers.get(i) % 2 != integers.get(i + 1) % 2) {
                int evenOddLength = 1;
                while (i < integers.size() - 1 && integers.get(i) % 2 != integers.get(i + 1) % 2) {
                    evenOddLength++;
                    i++;
                }
                maxEvenOddLength = Math.max(evenOddLength, maxEvenOddLength);
            }
        }
        return maxEvenOddLength;
    }
}
