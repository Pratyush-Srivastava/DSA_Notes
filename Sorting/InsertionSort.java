package Sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{5, 4, 3, 2, 1})));
    }

    //stable. inplace. Used for small inputs
    //imagine a partition of sorted and unsorted array and keep inserting the first element of unsorted into sorted array.
    private static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                while (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            System.out.println("Iteration " + i + " = " + Arrays.toString(arr));
        }
        return arr;
    }

}
