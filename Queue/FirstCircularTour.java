package Queue;

import java.util.Arrays;

public class FirstCircularTour {
    public static void main(String[] args) {
        System.out.println(firstCircularTour(new int[]{4, 8, 7, 4}, new int[]{6, 5, 3, 5}));
        System.out.println(firstCircularTour(new int[]{4, 8}, new int[]{5, 6}));
        System.out.println(firstCircularTour(new int[]{8, 9, 4}, new int[]{5, 10, 12}));
        System.out.println(firstCircularTour(new int[]{50, 10, 60, 100}, new int[]{30, 20, 100, 10}));
    }

    private static int firstCircularTour(int[] petrol, int[] dist) {
        int[] diff = new int[petrol.length];
        for (int i = 0; i < petrol.length; i++) {
            diff[i] = petrol[i] - dist[i];
        }
        System.out.println(Arrays.toString(diff));
        return firstCircularTour(diff);
    }

    private static int firstCircularTour(int[] arr) {
        for (int start = 0; start < arr.length; start++) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                int j = (i + start) % arr.length;
                sum += arr[j];
                System.out.println("start=" + start + " i=" + i + " j=" + j + " sum=" + sum);
                if (sum < 0) {
                    start = j;
                    break;
                }
            }
            if (sum >= 0) {
                return start + 1;
            }
        }
        return -1;
    }
}
