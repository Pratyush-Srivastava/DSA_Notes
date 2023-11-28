package Sorting;

import java.util.*;

public class HeapSort {

    public static void main(String[] args) {
        buildHeap(new int[]{10, 15, 50, 4, 20});
        buildHeap(new int[]{1, 2, 3, 4, 5, 6, 7});
        heapSort(new int[]{10, 15, 50, 4, 20});
        heapSort(new int[]{90, 80, 60, 50, 35, 22, 3});
    }

    private static void heapSort(int[] arr) {
        System.out.println("Before Sorting: " + Arrays.toString(arr));
        buildHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, 0);
            maxHeapify(arr, 0, 0, i - 1);
        }
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }


    private static void buildHeap(int[] arr) {
        int lastLeaf = arr.length - 1;
        int lastInternalNode = (lastLeaf - 1) / 2;
        for (int internalNode = lastInternalNode; internalNode >= 0; internalNode--) {
            maxHeapify(arr, internalNode, 0, arr.length - 1);
        }
    }

    //formula for left child is 2i+1 and right child is 2i+2
    //formula for parent is (i-1)/2
    private static void maxHeapify(int[] arr, int i, int low, int high) {

        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild <= high && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild <= high && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, low, high);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
