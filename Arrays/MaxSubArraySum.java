package Arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Kadane's Algorithm (modified for both positive and negative numbers)
 */
public class MaxSubArraySum {
    public static void main(String[] args) {
        System.out.println(maxSubArraySum(Arrays.asList(2, 3, -8, 7, -1, 2, 3)));
        System.out.println(maxSubArraySum(Arrays.asList(5, 8, 3)));
        System.out.println(maxSubArraySum(Arrays.asList(-6, -1, -8)));
        System.out.println(maxSubArraySum(Arrays.asList(-3, 8, -2, 4, -5, 6)));
    }

    private static int maxSubArraySum(List<Integer> integers) {
        int maxEndingHere = 0;
        int maxEndingSoFar = integers.get(0);
        for (Integer number : integers) {
            maxEndingHere = Math.max(number, maxEndingHere + number);
            maxEndingSoFar = Math.max(maxEndingHere, maxEndingSoFar);
        }
        return maxEndingSoFar;
    }
}
