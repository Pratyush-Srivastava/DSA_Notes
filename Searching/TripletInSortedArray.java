package Searching;

import java.util.HashSet;
import java.util.Set;

public class TripletInSortedArray {
    public static void main(String[] args) {
        System.out.println(tripletInSortedArray(new int[]{2, 3, 4, 8, 9, 20, 40}, 32));
        System.out.println(tripletInSortedArray(new int[]{1, 2, 5, 6}, 32));
        System.out.println(tripletInSortedArray(new int[]{1, 2, 3}, 6));
    }

    private static boolean tripletInSortedArray(int[] a, int requiredSum) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            numbers.add(i);
        }
        int low = 0;
        int high = a.length - 1;
        while (low < high) {
            int sum = a[low] + a[high];
            if (numbers.contains(requiredSum - sum)) {
                return true;
            } else if (sum > requiredSum) {
                high--;
            } else {
                low++;
            }
        }
        return false;
    }
}
