package Arrays;

import java.util.Arrays;

public class RearrangeSortedWithConstantSpace {
    public static void main(String[] args) {
        rearrange(new int[] {1,2,3,4,5,6});
    }

    private static void rearrange(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        max = max + 1; //any element greater than all elements
        int currMax = n - 1;
        int currMin = 0;
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                arr[i] = arr[i] + (arr[currMax] % max) * max;
                currMax--;
            } else {
                arr[i] = arr[i] + (arr[currMin] % max) * max;
                currMin++;
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / max;
        }
        System.out.println(Arrays.toString(arr));
    }
}
