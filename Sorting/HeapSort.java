package Sorting;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        buildHeap(new int[]{10, 15, 50, 4, 20});
        buildHeap(new int[]{1, 2, 3, 4, 5, 6, 7});
        heapSort(new int[]{10, 15, 50, 4, 20});
        heapSort(new int[]{90, 80, 60, 50, 35, 22, 3});
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;
        buildHeap(arr);
        //max heap is created
        for (int i = n - 1; i >= 1; i--) {
            swap(arr, 0, i);
            maxHeapify(0, arr, i);
        }
        System.out.println("Sorted: " + Arrays.toString(arr));
    }

    private static void buildHeap(int[] arr) {
        //arr is a complete graph where n - 1 is the last node. To get its parent, do (i-1)/2
        //Note children are 2 * parent + 1 and 2 * parent + 2
        //Note parent is (children - 1)/2
        //For n-1, the parent will be (n-2)/2
        int n = arr.length;
        for (int i = (n - 2) / 2; i >= 0; i--) {
            maxHeapify(i, arr, n);
        }
        System.out.println("After building heap: " + Arrays.toString(arr));
    }

    private static void maxHeapify(int parent, int[] arr, int size) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int largest = parent;
        if (left < size && arr[largest] < arr[left]) {
            largest = left;
        }
        if (right < size && arr[largest] < arr[right]) {
            largest = right;
        }
        if (largest != parent) {
            swap(arr, parent, largest);
            //largest will now have the smaller element which got swapped
            maxHeapify(largest, arr, size);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
