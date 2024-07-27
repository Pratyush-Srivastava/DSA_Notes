package DynamicProgramming;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequenceUsingNLogNTimeComplexity(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}) == 6);
        System.out.println(longestIncreasingSubsequenceUsingN2TimeComplexity(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}) == 6);
    }

    private static int longestIncreasingSubsequenceUsingNLogNTimeComplexity(int[] a) {
        int n = a.length;
        int[] tail = new int[n];
        tail[0] = a[0];
        int len = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > tail[len - 1]) {
                tail[len] = a[i];
                len++;
            } else {
                int ceilIndex = ceil(tail, 0, len - 1, a[i]);
                tail[ceilIndex] = a[i];
            }
        }
        return len;
    }

    private static int ceil(int[] a, int l, int r, int num) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (num == a[mid]) {
                return mid;
            } else if (num > a[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private static int longestIncreasingSubsequenceUsingN2TimeComplexity(int[] a) {
        int n = a.length;
        int[] lis = new int[n];
        lis[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    max = Math.max(max, lis[j]);
                }
            }
            lis[i] = max + 1;
            maxLength = Math.max(maxLength, lis[i]);
        }
        return maxLength;
    }
}
