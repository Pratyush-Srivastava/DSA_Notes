package Searching;

public class SearchInSortedRotated {
    public static void main(String[] args) {
        System.out.println(searchInSortedRotated(new int[]{10, 20, 30, 40, 50, 8, 9}, 30));
        System.out.println(searchInSortedRotated(new int[]{100, 200, 300, 10, 20}, 40));
        System.out.println(searchInSortedRotated(new int[]{4, 5, 6, 1, 2, 3}, 3));
    }

    private static int searchInSortedRotated(int[] a, int search) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (search == a[middle]) {
                return middle;
            } else if (a[low] < a[middle - 1]) {
                //left sorted, right unsorted
                if (search >= a[low] && search <= a[middle - 1]) {
                    //number is in left
                    high = middle - 1;
                } else {
                    //number is in right
                    low = middle + 1;
                }
            } else {
                // left unsorted, right sorted
                if (search >= a[middle + 1] && search <= a[high]) {
                    //number is in right
                    low = middle + 1;
                } else {
                    //number is in left
                    high = middle - 1;
                }
            }
        }
        return -1;
    }
}
