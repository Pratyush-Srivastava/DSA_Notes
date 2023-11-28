package Sorting;

import java.util.Arrays;

public class CountInversions {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(countInversions(arr));
        System.out.println(Arrays.toString(arr));
        int[] brr = {4, 3, 2, 1};
        System.out.println(countInversions(brr));
        System.out.println(Arrays.toString(brr));
    }

    private static int countInversions(int[] arr) {
        return countInversions(arr, 0, arr.length - 1);
    }

    private static int countInversions(int[] arr, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = (low + high) / 2;
        int countLeft = countInversions(arr, low, mid);
        int countRight = countInversions(arr, mid + 1, high);
        int countWhileMerging = countInversionsWhileMerging(arr, low, mid, mid + 1, high);
        return countLeft + countRight + countWhileMerging;
    }

    private static int countInversionsWhileMerging(int[] arr, int low1, int high1, int low2, int high2) {
        int countInversions = 0;
        int n1 = high1 - low1 + 1;
        int n2 = high2 - low2 + 1;

        int i1 = low1;
        int i2 = low2;
        int destination = 0;
        int[] temp = new int[n1 + n2];
        while (i1 <= high1 && i2 <= high2) {
            if (arr[i1] > arr[i2]) {
                temp[destination] = arr[i2];
                countInversions += (high1 - i1 + 1);
                i2++;
                destination++;
            } else if (arr[i1] < arr[i2]) {
                temp[destination] = arr[i1];
                i1++;
                destination++;
            } else {
                temp[destination] = arr[i1];
                i1++;
                destination++;
                temp[destination] = arr[i2];
                i2++;
                destination++;
            }
        }
        while (i1 <= high1) {
            temp[destination] = arr[i1];
            i1++;
            destination++;
        }

        while (i2 <= high2) {
            temp[destination] = arr[i2];
            i2++;
            destination++;
        }

        i1 = low1;
        destination = 0;
        while (i1 <= high1) {
            arr[i1] = temp[destination];
            i1++;
            destination++;
        }
        i2 = low2;
        while (i2 <= high2) {
            arr[i2] = temp[destination];
            i2++;
            destination++;
        }
        return countInversions;
    }
}
