package Searching;

public class MinimizeTheMaxSubArray {
    public static void main(String[] args) {
        System.out.println(leastMaximumSubArraySum(new int[]{10, 20, 10, 30}, 2));
        System.out.println(leastMaximumSubArraySum(new int[]{10, 20, 30, 40}, 2));
        System.out.println(leastMaximumSubArraySum(new int[]{10, 20, 30}, 1));
        System.out.println(leastMaximumSubArraySum(new int[]{10, 5, 30, 1, 2, 5, 10, 10}, 3));
    }

    // k is the given number of subArrays. Find subArrays such that the maximum subArray sum is minimized.
    private static int leastMaximumSubArraySum(int[] a, int k) {
        int totalSum = 0;
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            totalSum += a[i];
            if (a[i] > max) {
                max = a[i];
            }
        }
        int low = max;
        int high = totalSum;
        int result = -1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (isFeasibleSolution(a, k, middle)) {
                result = middle;
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return result;
    }

    private static boolean isFeasibleSolution(int[] a, int k, int sampleSum) {
        int currSum = 0;
        int numberOfSubArrays = 0;
        for (int i = 0; i < a.length; i++) {
            if (currSum + a[i] > sampleSum) {
                currSum = 0;
                numberOfSubArrays++;
            }
            currSum += a[i];
        }
        if (currSum <= sampleSum) {
            numberOfSubArrays++;
        }
        return numberOfSubArrays <= k;
    }
}
