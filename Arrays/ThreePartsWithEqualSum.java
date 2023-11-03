package Arrays;

import java.util.Arrays;
import java.util.List;

public class ThreePartsWithEqualSum {
    public static void main(String[] args) {
        System.out.println(hasThreePartsWithEqualSum(Arrays.asList(5, 2, 6, 1, 1, 1, 1, 4)));
        System.out.println(hasThreePartsWithEqualSum(Arrays.asList(3, 2, 5, 1, 1, 5)));
        System.out.println(hasThreePartsWithEqualSum(Arrays.asList(3, 3, 2, 1)));
    }

    private static boolean hasThreePartsWithEqualSum(List<Integer> integers) {
        int totalSum = 0;
        for (Integer number : integers) {
            totalSum += number;
        }
        if (totalSum % 3 != 0) {
            return false;
        }
        int targetSum = totalSum / 3;
        int numberOfSubArrays = 0;
        int currentSum = 0;
        for (Integer number : integers) {
            currentSum += number;
            if (currentSum == targetSum) {
                numberOfSubArrays++;
                currentSum = 0;
            }

        }
        return numberOfSubArrays == 3;

    }
}
