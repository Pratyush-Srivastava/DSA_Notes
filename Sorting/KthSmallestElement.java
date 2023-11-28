package Sorting;

public class KthSmallestElement {
    public static void main(String[] args) {
        System.out.println(kthSmallestElement(new int[]{10, 34, 64, 9, 5, 1, 3}, 3));
        System.out.println(kthSmallestElement(new int[]{10, 34, 64, 9, 5, 1, 3}, 7));
    }

    //lomuto finds the correct index of last element. Here we need to find the kth index
    private static int kthSmallestElement(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int p = lomutoPartition(arr, low, high);
            if (p == k - 1) {
                return arr[p];
            } else if (p > k - 1) {
                high = p - 1;
            } else {
                low = p + 1;
            }
        }
        return -1;
    }

    private static int lomutoPartition(int[] arr, int low, int high) {
        //last element is pivot
        int pivot = high;
        int smallElementWindow = low - 1;
        for (int iterator = low; iterator <= high - 1; iterator++) {
            if (arr[iterator] < arr[pivot]) {
                smallElementWindow++;
                swap(arr, smallElementWindow, iterator);
            }
        }
        swap(arr, smallElementWindow + 1, pivot);
        return smallElementWindow + 1;
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
