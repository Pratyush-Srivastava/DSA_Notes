package Searching;

public class MinimizeTheMaxSubArray {
    public static void main(String[] args) {
        System.out.println(leastMaximumSubArraySum(new int[]{10, 20, 10, 30}, 2)); //prints 40
        System.out.println(leastMaximumSubArraySum(new int[]{10, 20, 30, 40}, 2)); //prints 60
        System.out.println(leastMaximumSubArraySum(new int[]{10, 20, 30}, 1)); //prints 60
        System.out.println(leastMaximumSubArraySum(new int[]{10, 5, 30, 1, 2, 5, 10, 10}, 3)); //prints 30
    }

    // k is the given number of subArrays. Find subArrays such that the maximum subArray sum is minimized.
    private static int leastMaximumSubArraySum(int[] a, int k) {
        int max = Integer.MIN_VALUE;
        int totalSum = 0;
        for (Integer current : a) {
            max = Math.max(max, current);
            totalSum += current;
        }
        int low = max;
        int high = totalSum;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int formedWithAllowedMax = numberOfSubArraysFormedWithAllowedMax(a, mid);
            if (formedWithAllowedMax == k) {
                high = mid;
            } else if (formedWithAllowedMax > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private static int numberOfSubArraysFormedWithAllowedMax(int[] a, int allowedMax) {
        int currentSum = 0;
        int numberOfSubArrays = 0;
        for (Integer current : a) {
            if (currentSum + current > allowedMax) {
                currentSum = current;
                numberOfSubArrays++;
            } else {
                currentSum += current;
            }
        }
        return numberOfSubArrays + 1;
    }

}
