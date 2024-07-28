package DynamicProgramming;

public class MaxCutsInRod {
    public static void main(String[] args) {
        System.out.println("Recursive solution: ");
        System.out.println(maxCutsInARod(5, new int[]{1, 2, 3}));
        System.out.println(maxCutsInARod(23, new int[]{12, 11, 13}));
        System.out.println(maxCutsInARod(3, new int[]{2, 4, 2}));

        System.out.println("Iterative solution: ");
        System.out.println(maxCutsInARodIterative(5, new int[]{1, 2, 3}));
        System.out.println(maxCutsInARodIterative(23, new int[]{12, 11, 13}));
        System.out.println(maxCutsInARodIterative(3, new int[]{2, 4, 2}));
    }

    private static int maxCutsInARod(int totalLength, int[] allowedLengths) {
        return maxCutsInARod(totalLength, allowedLengths, allowedLengths.length);
    }

    private static int maxCutsInARod(int totalLength, int[] allowedLengths, int size) {
        if (totalLength == 0) {
            return 0;
        }
        if (totalLength < 0) {
            return -1;
        }
        if (size == 0) {
            return -1;
        }

        int includeThatLength = maxCutsInARod(totalLength - allowedLengths[size - 1], allowedLengths, size);
        if (includeThatLength != -1) {
            includeThatLength = 1 + includeThatLength;
        }
        int excludeThatLength = maxCutsInARod(totalLength, allowedLengths, size - 1);
        return Math.max(excludeThatLength, includeThatLength);
    }

    private static int maxCutsInARodIterative(int totalLength, int[] allowedLengths) {
        int size = allowedLengths.length;
        int[][] maxCuts = new int[size + 1][totalLength + 1];
        for (int i = 0; i < size + 1; i++) {
            maxCuts[i][0] = 0;
        }
        for (int j = 1; j < totalLength + 1; j++) {
            maxCuts[0][j] = -1;
        }
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < totalLength + 1; j++) {
                int includeThatLength = -1;
                if (j - allowedLengths[i - 1] >= 0) {
                    includeThatLength = maxCuts[i][j - allowedLengths[i - 1]];
                }
                if (includeThatLength != -1) {
                    includeThatLength = includeThatLength + 1;
                }
                int excludeThatLength = maxCuts[i - 1][j];
                maxCuts[i][j] = Math.max(includeThatLength, excludeThatLength);
            }
        }
        return maxCuts[size][totalLength];
    }

}
