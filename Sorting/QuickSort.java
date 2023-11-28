package Sorting;

import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        quickSort(new int[]{5, 4, 1, 2, 3});
        quickSort(new int[]{10, 9, 8, 7, 6});
        quickSort(new int[]{5, 9, 2, 6, 3});
    }

    // best case - O(n log n) worst case - O(n^2)
    private static void quickSort(int[] arr) {
        System.out.println("Before Sort: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After Sort: " + Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int correctPositionOfPivot = lomutoPartition(arr, low, high);
        quickSort(arr, low, correctPositionOfPivot - 1);
        quickSort(arr, correctPositionOfPivot + 1, high);
    }

    //assume last index as pivot
    private static int lomutoPartition(int[] arr, int low, int high) {
        int pivot = high; // assume the last element as pivot always
        int lastSmallElementIndex = low - 1;
        for (int iterator = low; iterator <= pivot - 1; iterator++) {
            if (arr[iterator] < arr[pivot]) {
                lastSmallElementIndex++;
                swap(arr, lastSmallElementIndex, iterator);
            }
        }
        swap(arr, lastSmallElementIndex + 1, pivot);
        System.out.println(Arrays.toString(arr));
        return lastSmallElementIndex + 1;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
