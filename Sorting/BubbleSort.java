package Sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(bubbleSort(new int[]{1, 2, 3, 4, 5})));
    }

    //swap if you find a larger element first. In each iteration, the largest element is bubbled to the last
    private static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("Iteration " + i + " = " + Arrays.toString(arr));
        }
        return arr;
    }
}