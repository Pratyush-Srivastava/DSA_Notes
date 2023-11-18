package Arrays;

import java.util.Arrays;

public class RearrangeWithConstantSpace {
    public static void main(String[] args) {
        rearrange(new int[] {4, 0 ,2, 1, 3});
    }

    //Rearrange array in O(1) such that arr[i] = arr[arr[i]]
    private static void rearrange(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] + (arr[arr[i]] % n) * n;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i]/n;
        }
        System.out.println(Arrays.toString(arr));
    }
}
