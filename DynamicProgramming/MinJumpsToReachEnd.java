package DynamicProgramming;

public class MinJumpsToReachEnd {

    public static void main(String[] args) throws Exception {
        System.out.println("Greedy solutions: ");
        System.out.println(minJumpsUsingGreedyAlgorithm(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
        System.out.println(minJumpsUsingGreedyAlgorithm(new int[]{1, 4, 3, 2, 6, 7}));
        System.out.println(minJumpsUsingGreedyAlgorithm(new int[]{0, 10, 20}));
        System.out.println(minJumpsUsingGreedyAlgorithm(new int[]{10, 14, 29, 21, 17, 4, 18, 20, 18, 22, 21, 14, 27, 12, 3, 28, 17, 0, 2, 18, 8, 20, 26, 16, 9, 23, 25, 20, 7, 27, 5, 7, 16, 5, 25, 11, 3, 7, 2, 17, 14, 6, 12, 14, 23, 25, 26, 5, 18, 1, 6, 10, 9, 12, 2, 25, 29, 12, 19, 4, 8, 5, 8, 30, 2, 22, 24, 30, 7, 24, 8, 15, 16, 2, 11, 20}));

        System.out.println("Dynamic programming solutions: ");
        System.out.println(minJumpsUsingDynamicProgramming(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
        System.out.println(minJumpsUsingDynamicProgramming(new int[]{1, 4, 3, 2, 6, 7}));
        System.out.println(minJumpsUsingDynamicProgramming(new int[]{0, 10, 20}));
        System.out.println(minJumpsUsingDynamicProgramming(new int[]{10, 14, 29, 21, 17, 4, 18, 20, 18, 22, 21, 14, 27, 12, 3, 28, 17, 0, 2, 18, 8, 20, 26, 16, 9, 23, 25, 20, 7, 27, 5, 7, 16, 5, 25, 11, 3, 7, 2, 17, 14, 6, 12, 14, 23, 25, 26, 5, 18, 1, 6, 10, 9, 12, 2, 25, 29, 12, 19, 4, 8, 5, 8, 30, 2, 22, 24, 30, 7, 24, 8, 15, 16, 2, 11, 20}));
    }

    /**
     * This solution will take O(N) time complexity
     */
    private static int minJumpsUsingGreedyAlgorithm(int[] a) {
        int i = 0;
        int n = a.length;
        int jumps = 0;
        while (i < n) {
            int currentFarthest = a[i];
            if (i == n - 1) {
                return jumps;
            }
            int maxValueWithinRange = Integer.MIN_VALUE;
            int indexWithMaxValue = Integer.MIN_VALUE;
            if (i + currentFarthest >= n - 1) {
                return ++jumps;
            }
            for (int j = 1; j <= currentFarthest; j++) {
                if (a[i + j] + (i + j) > maxValueWithinRange) {
                    maxValueWithinRange = a[i + j] + (i + j);
                    indexWithMaxValue = i + j;
                }
            }
            if (indexWithMaxValue != Integer.MIN_VALUE) {
                i = indexWithMaxValue;
                jumps++;
            } else {
                return -1;
            }
        }
        return -1;
    }

    /**
     * This solution will take O(N^2) time complexity
     */
    static int minJumpsUsingDynamicProgramming(int[] arr) {
        // your code here
        int n = arr.length;
        int[] minJumps = new int[n];
        minJumps[n - 1] = 0;
        for (int index = n - 2; index >= 0; index--) {
            int steps = arr[index];
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= steps; i++) {
                if (i + index < n) {
                    if (minJumps[i + index] != -1) {
                        min = Math.min(min, minJumps[i + index]);
                    }
                } else {
                    break;
                }
            }
            if (min == Integer.MAX_VALUE) {
                minJumps[index] = -1;
            } else {
                minJumps[index] = min + 1;
            }
        }
        return minJumps[0];
    }


}
