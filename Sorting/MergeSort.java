package Sorting;

import java.util.*;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{7, 6, 5, 4, 3, 2, 1};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
        int[] b = new int[]{4, 3, 2, 1};
        mergeSort(b);
        System.out.println(Arrays.toString(b));
        int[] c = new int[]{4, 4, 2, 1};
        mergeSort(c);
        System.out.println(Arrays.toString(c));
    }

    private static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        System.out.println("Iteration " + "low = " + low + " high = " + high + " " + Arrays.toString(arr));
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        mergeSortedArrays(arr, low, mid, mid + 1, high);
    }

    private static void mergeSortedArrays(int[] arr, int low1, int high1, int low2, int high2) {
        int n1 = high1 - low1 + 1;
        int n2 = high2 - low2 + 1;
        int[] temp = new int[n1 + n2];
        int i1 = low1;
        int i2 = low2;
        int destination = 0;
        while (i1 <= high1 && i2 <= high2) {
            if (arr[i1] < arr[i2]) {
                temp[destination] = arr[i1];
                destination++;
                i1++;
            } else if (arr[i1] > arr[i2]) {
                temp[destination] = arr[i2];
                destination++;
                i2++;
            } else {
                temp[destination] = arr[i1];
                destination++;
                i1++;
                temp[destination] = arr[i2];
                destination++;
                i2++;
            }
        }
        while (i1 <= high1) {
            temp[destination] = arr[i1];
            destination++;
            i1++;
        }
        while (i2 <= high2) {
            temp[destination] = arr[i2];
            destination++;
            i2++;
        }
        i1 = low1;
        i2 = low2;
        destination = 0;
        while (i1 <= high1) {
            arr[i1] = temp[destination];
            destination++;
            i1++;
        }
        while (i2 <= high2) {
            arr[i2] = temp[destination];
            destination++;
            i2++;
        }
    }
}
