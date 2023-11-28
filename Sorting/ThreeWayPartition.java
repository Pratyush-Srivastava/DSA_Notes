package Sorting;

import java.util.Arrays;

public class ThreeWayPartition {

    public static void main(String[] args) {
        threeWayPartition(new int[]{10, 5, 6, 3, 20, 9, 40}, 5, 10);
    }

    private static void threeWayPartition(int[] arr, int lowRange, int highRange) {
        int startOfRange = lomutoPartition(arr, 0, arr.length - 1, lowRange);
        System.out.println(Arrays.toString(arr));
        System.out.println("start of range = " + startOfRange);
        lomutoPartition(arr, startOfRange, arr.length - 1, highRange + 1);
        System.out.println(Arrays.toString(arr));
    }

    //worst case - O(n)
    private static int lomutoPartition(int[] arr, int low, int high, int pivot) {
        //last element as pivot
        int smallWindowIndex = low - 1;
        for (int iterator = low; iterator <= high; iterator++) {
            if (arr[iterator] < pivot) {
                smallWindowIndex++;
                swap(arr, smallWindowIndex, iterator);
            }
        }
        return smallWindowIndex + 1;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
