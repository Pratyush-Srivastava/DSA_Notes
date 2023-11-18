package Arrays;

public class MaxIndexDifference {
    public static void main(String[] args) {
        System.out.println(maxIndexDifference(new int[]{65, 6, 74, 94, 56, 89, 9, 63, 75, 25, 34, 68, 93, 48, 16}));
        System.out.println(maxIndexDifference(new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1}));
    }

    private static int maxIndexDifference(int[] positiveNumbers) {
        int maxIndexDiff = -1;
        int[] leftMin = new int[positiveNumbers.length];
        int[] rightMax = new int[positiveNumbers.length];
        int leftMinimum = positiveNumbers[0];
        int rightMaximum = positiveNumbers[positiveNumbers.length - 1];
        for (int i = 0; i < positiveNumbers.length; i++) {
            if (positiveNumbers[i] < leftMinimum) {
                leftMinimum = positiveNumbers[i];
            }
            leftMin[i] = leftMinimum;
        }
        for (int i = positiveNumbers.length - 1; i >= 0; i--) {
            if (positiveNumbers[i] > rightMaximum) {
                rightMaximum = positiveNumbers[i];
            }
            rightMax[i] = rightMaximum;
        }
        int i = 0;
        int j = 0;
        while (i < leftMin.length && j < rightMax.length) {
            if (leftMin[i] <= rightMax[j]) {
                maxIndexDiff = Math.max(maxIndexDiff, j - i);
                j++;
            } else {
                i++;
            }
        }
        return maxIndexDiff;
    }
}
