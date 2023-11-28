package Sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[]{5, 4, 3, 2, 1})));
    }

	//unstable
    // find the minimum element and put it the beginning
    private static int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
            System.out.println("Iteration " + i + " = " + Arrays.toString(arr));
        }
        return arr;
    }

}
