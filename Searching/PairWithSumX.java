package Searching;

public class PairWithSumX {
    public static void main(String[] args) {
        //given a sorted array
        System.out.println(doesPairWithSumXExists(new int[]{2, 5, 8, 12, 30}, 17));
        System.out.println(doesPairWithSumXExists(new int[]{3, 8, 13, 18}, 14));
    }

    private static boolean doesPairWithSumXExists(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        while (low < high) {
            int sum = a[low] + a[high];
            if (sum == x) {
                return true;
            } else if (sum > x) {
                high--;
            } else {
                low++;
            }
        }
        return false;
    }
}
