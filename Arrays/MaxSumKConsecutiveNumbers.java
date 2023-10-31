package Arrays;

import java.util.Arrays;
import java.util.List;

public class MaxSumKConsecutiveNumbers {
    public static void main(String[] args) {
        System.out.println(maximumSumOfKConsecutiveNumbers(Arrays.asList(1, 8, 30, -5, 20, 7), 3));
        System.out.println(maximumSumOfKConsecutiveNumbers(Arrays.asList(5, -10, 6, 90, 3), 2));
    }

    private static int maximumSumOfKConsecutiveNumbers(List<Integer> numbers, int k) {
        int currentSumOfConsecutiveK = 0;
        int i = 0;
        while (i < k) {
            currentSumOfConsecutiveK += numbers.get(i);
            i++;
        }
        int maxSum = currentSumOfConsecutiveK;
        while (i < numbers.size()) {
            currentSumOfConsecutiveK = currentSumOfConsecutiveK + numbers.get(i) - numbers.get(i - k);
            maxSum = Math.max(currentSumOfConsecutiveK, maxSum);
            i++;
        }
        return maxSum;
    }
}
