package Arrays;

import java.util.Arrays;
import java.util.List;

public class MaxSubArraySum {
    public static void main(String[] args) {
        System.out.println(maxSubArraySum(Arrays.asList(2, 3, -8, 7, -1, 2, 3)));
        System.out.println(maxSubArraySum(Arrays.asList(5, 8, 3)));
        System.out.println(maxSubArraySum(Arrays.asList(-6, -1, -8)));
        System.out.println(maxSubArraySum(Arrays.asList(-3, 8, -2, 4, -5, 6)));
    }

    private static int maxSubArraySum(List<Integer> integers) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int min = 0;
        for (Integer number : integers) {
            sum += number;
            int res = sum - min;
            if (res > maxSum) {
                maxSum = res;
            }
            if (sum < min) {
                min = sum;
            }
        }
        return maxSum;
    }
}
