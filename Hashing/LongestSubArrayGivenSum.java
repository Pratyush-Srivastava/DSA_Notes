package Hashing;

import java.util.HashMap;

public class LongestSubArrayGivenSum {
    public static void main(String[] args) {
        System.out.println(maxLengthSubArrayWithGivenSum(new int[]{5, 8, -4, -4, 9, -2, 2}, 0));
        System.out.println(maxLengthSubArrayWithGivenSum(new int[]{3, 1, 0, 1, 8, 2, 3, 6}, 5));
    }

    private static int maxLengthSubArrayWithGivenSum(int[] arr, int givenSum) {
        int maxLengthOfSubArray = 0;
        int prefixSum = 0;
        int lengthOfSubArray = 0;
        HashMap<Integer, Integer> prefixSumWithIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == givenSum) {
                lengthOfSubArray = i + 1;
            } else if (prefixSumWithIndex.containsKey(prefixSum - givenSum)) {
                lengthOfSubArray = i - prefixSumWithIndex.get(prefixSum - givenSum);
            }
            if (!prefixSumWithIndex.containsKey(prefixSum)) {
                prefixSumWithIndex.put(prefixSum, i);
            }
            maxLengthOfSubArray = Math.max(lengthOfSubArray, maxLengthOfSubArray);
        }
        return maxLengthOfSubArray;
    }
}
