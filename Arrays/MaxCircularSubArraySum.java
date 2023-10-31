package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxCircularSubArraySum {
    public static void main(String[] args) {
        System.out.println(maxCircularSubArraySum(Arrays.asList(5, -2, 3, 4)));
        System.out.println(maxCircularSubArraySum(Arrays.asList(2, 3, -4)));
        System.out.println(maxCircularSubArraySum(Arrays.asList(8, -4, 3, -5, 4)));
        System.out.println(maxCircularSubArraySum(Arrays.asList(-3, 4, 6, -2)));
        System.out.println(maxCircularSubArraySum(Arrays.asList(-8, 7, 6)));
        System.out.println(maxCircularSubArraySum(Arrays.asList(3, -4, 5, 6, -8, 7)));
        System.out.println(maxCircularSubArraySum(Arrays.asList(-2, -3, -4)));
        System.out.println(circularSubArray(Arrays.asList(2, 3, -4)));
    }

    private static int maxCircularSubArraySum(List<Integer> integers) {
        int maxNormalSubArraySum = maxSubArraySum(integers);
        if (maxNormalSubArraySum < 0) {
            return maxNormalSubArraySum;
        }
        int totalSum = 0;
        for (Integer number : integers) {
            totalSum += number;
        }
        int maxCircularSubArrayAlone = totalSum - minSubArraySum(integers);
        return Math.max(maxNormalSubArraySum, maxCircularSubArrayAlone);
    }

    private static int maxSubArraySum(List<Integer> integers) {
        int maxEndingSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for (Integer number : integers) {
            maxEndingHere = Math.max(number, maxEndingHere + number);
            maxEndingSoFar = Math.max(maxEndingHere, maxEndingSoFar);
        }
        return maxEndingSoFar;
    }

    private static int minSubArraySum(List<Integer> integers) {
        int minEndingSoFar = Integer.MAX_VALUE;
        int minEndingHere = 0;
        for (Integer number : integers) {
            minEndingHere = Math.min(number, minEndingHere + number);
            minEndingSoFar = Math.min(minEndingHere, minEndingSoFar);
        }
        return minEndingSoFar;
    }

    private static List<List<Integer>> circularSubArray(List<Integer> integers) {
        List<List<Integer>> circularSubArrays = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {
            for (int j = i; j < integers.size() + i; j++) {
                List<Integer> subArray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subArray.add(integers.get(k % integers.size()));
                }
                circularSubArrays.add(subArray);
            }
        }
        return circularSubArrays;
    }
}
