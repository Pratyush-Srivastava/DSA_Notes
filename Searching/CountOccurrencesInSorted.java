package Searching;

public class CountOccurrencesInSorted {
    public static void main(String[] args) {
        System.out.println(firstOccurrencesInSorted(new int[]{1, 2, 3, 4, 5, 5, 6}, 5) == 4);
        System.out.println(firstOccurrencesInSorted(new int[]{10, 10, 10}, 10) == 0);
        System.out.println(firstOccurrencesInSorted(new int[]{2, 2, 3, 4, 5, 5, 6}, 3) == 2);
        System.out.println(lastOccurrencesInSorted(new int[]{1, 2, 3, 4, 5, 5, 6}, 5) == 5);
        System.out.println(lastOccurrencesInSorted(new int[]{10, 10, 10}, 10) == 2);
        System.out.println(lastOccurrencesInSorted(new int[]{2, 2, 3, 4, 5, 5, 6}, 3) == 2);

        System.out.println(countOccurrencesInSorted(new int[]{10, 10, 10}, 10) == 3);
        System.out.println(countOccurrencesInSorted(new int[]{1, 2, 3, 4, 5, 5, 6}, 5) == 2);
        System.out.println(countOccurrencesInSorted(new int[]{1, 2, 3, 4, 5, 5, 6}, 7) == 0);
    }

    private static int countOccurrencesInSorted(int[] a, int search) {
        int last = lastOccurrencesInSorted(a, search);
        int first = firstOccurrencesInSorted(a, search);
        if (last != -1) {
            return last - first + 1;
        } else {
            return 0;
        }
    }

    private static int firstOccurrencesInSorted(int[] a, int search) {
        int middle;
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            middle = start + (end - start) / 2;
            if (search == a[middle]) {
                if (middle == 0 || a[middle] != a[middle - 1]) {
                    return middle;
                } else {
                    end = middle - 1;
                }
            } else if (search < a[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    private static int lastOccurrencesInSorted(int[] a, int search) {
        int middle;
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            middle = start + (end - start) / 2;
            if (search == a[middle]) {
                if (middle == a.length - 1 || a[middle] != a[middle + 1]) {
                    return middle;
                } else {
                    start = middle + 1;
                }
            } else if (search < a[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
}
