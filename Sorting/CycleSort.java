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

    private static void cycleSort(int[] arr, int random) {
        int n = arr.length;
        for (int cycleStart = 0; cycleStart < n; cycleStart++) {
            int item = arr[cycleStart];
            int pos = cycleStart;
            for (int i = cycleStart + 1; i < n; i++) {
                if(arr[i] < item) {
                    pos++;
                }
            }
            int newItem = arr[pos];
            arr[pos] = item;
            while (pos != cycleStart) {
                newItem = arr[pos];
                pos = cycleStart;
                for (int i = cycleStart + 1; i < n; i++) {
                    if(arr[i] < newItem) {
                        pos++;
                    }
                }

            }


        }
        System.out.println(Arrays.toString(arr));
    }









    // average case - O(n^2)
    // the advantage of cycle sort is that it has minimum swaps or minimum writes while sorting
    // the logic is start a cycle by swapping the current element with its correct position and then keep doing until you reach the start again. This is one cycle.
    // complete all cycles. count the swaps for writes.
    public static void cycleSort(int[] arr) {
        int n = arr.length;

        // Traverse the array to find cycles to be rotated.
        for (int cycleStart = 0; cycleStart < n - 1; cycleStart++) {
            int item = arr[cycleStart];

            // Find the position where we put the element.
            int pos = cycleStart;
            for (int i = cycleStart + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }

            // If the item is already in the correct position.
            if (pos == cycleStart) {
                continue;
            }

            // Otherwise, put the item in the right position.
            while (item == arr[pos]) {
                pos++;
            }
            int temp = arr[pos];
            arr[pos] = item;
            item = temp;

            // Rotate the rest of the cycle.
            while (pos != cycleStart) {
                pos = cycleStart;

                // Find the position where we put the element.
                for (int i = cycleStart + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }

                // Put the item in the right position.
                while (item == arr[pos]) {
                    pos++;
                }
                temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
