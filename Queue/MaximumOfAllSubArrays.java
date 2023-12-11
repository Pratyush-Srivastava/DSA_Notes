package Queue;

import java.util.*;

public class MaximumOfAllSubArrays {
    public static void main(String[] args) {
        System.out.println(maxOfAllSubArraysOfSizeK(new int[]{10, 8, 5, 12, 15, 7, 6}, 3));
        System.out.println(maxOfAllSubArraysOfSizeK(new int[]{10, 9, 8, 7, 6, 5, 4}, 3));
        System.out.println(maxOfAllSubArraysOfSizeK(new int[]{20, 40, 30, 10, 60}, 3));
        System.out.println(maxOfAllSubArraysOfSizeK(new int[]{10, 1, 2, 3, 4, 5, 6}, 3));
    }

    private static List<Integer> maxOfAllSubArraysOfSizeK(int[] arr, int k) {
        List<Integer> maxOfSubArrays = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[i] > arr[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        maxOfSubArrays.add(arr[Optional.ofNullable(deque.peekFirst()).orElse(-1)]);
        System.out.println(deque);

        for (int i = k; i < arr.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && arr[i] > arr[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i
            );
            maxOfSubArrays.add(arr[Optional.ofNullable(deque.peekFirst()).orElse(-1)]);
            System.out.println(deque);
        }
        return maxOfSubArrays;
    }


}
