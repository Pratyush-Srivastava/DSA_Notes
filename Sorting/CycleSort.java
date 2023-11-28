package Sorting;

import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        cycleSort(new int[]{9, 8, 6, 4, 2, 1});
        cycleSort(new int[]{20, 40, 50, 10, 30});
        cycleSort(new int[]{20, 40, 50, 10, 40});
        cycleSort(new int[]{1, 6, 5, 1, 5, 6});
        cycleSort(new int[]{1, 1, 1, 1});
    }

    // average case - O(n^2)
    // the advantage of cycle sort is that it has minimum swaps or minimum writes while sorting
    // the logic is start a cycle by swapping the current element with its correct position and then keep doing until you reach the start again. This is one cycle.
    // complete all cycles. count the swaps for writes.
    private static void cycleSort(int[] arr) {
        for (int cycleStart = 0; cycleStart < arr.length - 1; cycleStart++) {
            int position = cycleStart;
            for (int i = cycleStart + 1; i < arr.length; i++) {
                if (arr[i] < arr[cycleStart]) {
                    position++;
                }
            }
            while (position != cycleStart && arr[position] == arr[cycleStart]) {
                position++;
            }
            swap(arr, position, cycleStart);
            while (position != cycleStart) {
                position = cycleStart;
                for (int i = cycleStart + 1; i < arr.length; i++) {
                    if (arr[i] < arr[cycleStart]) {
                        position++;
                    }
                }
                while (position != cycleStart && arr[position] == arr[cycleStart]) {
                    position++;
                }
                swap(arr, position, cycleStart);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
