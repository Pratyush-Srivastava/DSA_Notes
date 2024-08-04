package Searching;

public class MedianOfTwoSorted {

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 4, 9, 16};
        int[] a2 = new int[]{2, 8, 15, 20, 25, 28};
        System.out.println(findMedian(a1, a2)); //prints 12

        a1 = new int[]{1, 4, 9, 16};
        a2 = new int[]{2, 8, 15, 20, 25};
        System.out.println(findMedian(a1, a2)); //prints 9

        a1 = new int[]{1, 2, 3, 4, 5};
        a2 = new int[]{6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        System.out.println(findMedian(a1, a2)); //prints 9

        a1 = new int[]{4};
        a2 = new int[]{0, 1, 2, 3};
        System.out.println(findMedian(a1, a2)); //prints 2
    }

    static double findMedian(int[] a, int[] b) {
        if (a.length <= b.length) {
            return getMedian(a, b);
        } else {
            return getMedian(b, a);
        }
    }

    private static double getMedian(int[] a1, int[] a2) {
        int n1 = a1.length, n2 = a2.length;

        int low1 = 0;
        int high1 = n1; //Note it is not n1 - 1
        while (low1 <= high1) {
            int mid1 = (low1 + high1)/2;
            int mid2 = (n1 + n2 + 1)/2 - mid1;
            int maxLeft1 = (mid1 == 0) ? Integer.MIN_VALUE: a1[mid1 - 1];
            int minRight1 = (mid1 == n1)? Integer.MAX_VALUE: a1[mid1];

            int maxLeft2 = (mid2 == 0) ? Integer.MIN_VALUE: a2[mid2 - 1];
            int minRight2 = (mid2 == n2)? Integer.MAX_VALUE: a2[mid2];
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if((n1 + n2) % 2 == 0) {
                    return ((double) (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2))) / 2;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                high1 = mid1 - 1;
            } else {
                low1 = mid1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}
