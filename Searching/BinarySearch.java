package Searching;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {1,2,3,4}, 5, 0, 3));
        System.out.println(binarySearch(new int[] {1}, 5, 0, 0));
        System.out.println(binarySearch(new int[] {1,2,3,4,5,6}, 6, 0, 5));
        System.out.println(binarySearch(new int[] {1,2}, 5, 0, 1));
        System.out.println(binarySearch(new int[] {5,5,5,5}, 5, 0, 3));
    }

    private static int binarySearch(int[] a, int search, int start, int end) {
        int middle = start + (end - start + 1) / 2;
        if (start > end) {
            return -1;
        } else if (search == a[middle]) {
            return middle;
        } else if (search > a[middle]) {
            return binarySearch(a, search, middle + 1, end);
        } else {
            return binarySearch(a, search, start, middle - 1);
        }
    }
}
