package Searching;

public class PeakElement {
    public static void main(String[] args) {
        System.out.println(peakElement(new int[]{5, 10, 20, 15, 7}));
        System.out.println(peakElement(new int[]{10, 20, 15, 5, 23, 90, 67}));
        System.out.println(peakElement(new int[]{80, 70, 60}));
    }

    private static int peakElement(int[] a) {
        int low = 0;
        int high = a.length - 1;
        if (high == low) {
            return a[low];
        }
        while (low <= high) {
            int middle = (high + low) / 2;
            if ((middle == 0 && a[middle] >= a[middle + 1]) || (middle == a.length - 1 && a[middle] >= a[middle - 1]) || a[middle] >= a[middle - 1] && a[middle] >= a[middle + 1]) {
                return a[middle];
            } else if (a[middle] <= a[high]) {
                low = middle + 1;
            } else if (a[middle] <= a[low]) {
                high = middle - 1;
            }
        }
        return -1;
    }
}
