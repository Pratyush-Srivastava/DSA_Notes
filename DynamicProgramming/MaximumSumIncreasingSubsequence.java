package DynamicProgramming;

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(maxSumIncreasingSubsequence(new int[]{3, 20, 4, 6, 7, 30}) == 53);
    }

    private static int maxSumIncreasingSubsequence(int[] a) {
        int[] sum = new int[a.length];
        int[] lis = new int[a.length]; // We don't need this. just finding lis for better understanding
        lis[0] = 1;
        sum[0] = a[0];
        int maxLis = 1;
        int maxSum = a[0];
        for (int i = 1; i < a.length; i++) {
            int maxLisSmallerThanCurrent = 0;
            int maxSumSmallerThanCurrent = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    maxLisSmallerThanCurrent = Math.max(maxLisSmallerThanCurrent, lis[j]);
                    maxSumSmallerThanCurrent = Math.max(maxSumSmallerThanCurrent, sum[j]);
                }
            }
            lis[i] = maxLisSmallerThanCurrent + 1;
            sum[i] = maxSumSmallerThanCurrent + a[i];
            maxSum = Math.max(maxSum, sum[i]);
            maxLis = Math.max(maxLis, lis[i]);
        }
        System.out.println("Max lis length is " + maxLis);
        return maxSum;
    }
}

