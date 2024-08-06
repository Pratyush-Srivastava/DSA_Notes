package Sorting;

import java.util.Arrays;

public class ThreeWayPartition {

    public static void main(String[] args) {
        int[] arr = {10, 5, 6, 3, 20, 9, 40};
        System.out.println("Before segregating " + Arrays.toString(arr));
        threeWayPartition(arr, 5, 10);
        System.out.println("After segregating " + Arrays.toString(arr));
        System.out.println();

        arr = new int[]{0, 1, 0, 2, 1, 2};
        System.out.println("Before segregating " + Arrays.toString(arr));
        threeWayPartition(arr, 1, 1);
        System.out.println("After segregating " + Arrays.toString(arr));
        System.out.println();

        arr = new int[]{2, 1, 2, 20, 10, 20, 1};
        System.out.println("Before segregating " + Arrays.toString(arr));
        threeWayPartition(arr, 2, 2);
        System.out.println("After segregating " + Arrays.toString(arr));
        System.out.println();

    }

    private static void threeWayPartition(int[] arr, int lowRange, int highRange) {
        int n = arr.length;
        int lowerThanRange = -1;
        int higherThanRange = n;
        int j = 0;
        while (j < higherThanRange) {
            if (arr[j] >= lowRange && arr[j] <= highRange) {
                j++;
            } else if (arr[j] < lowRange) {
                lowerThanRange++;
                swap(arr, lowerThanRange, j);
                j++;
            } else {
                higherThanRange--;
                swap(arr, higherThanRange, j);
            }
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
