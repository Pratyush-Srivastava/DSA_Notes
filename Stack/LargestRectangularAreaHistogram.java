package Stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangularAreaHistogram {
    public static void main(String[] args) {
        System.out.println(largestHistogramArea(new int[]{60, 10, 20, 15, 35, 50}));
        System.out.println(largestHistogramArea(new int[]{13, 15, 12, 14, 16, 8, 6, 4, 10, 30}));
        System.out.println(largestHistogramArea(new int[]{6, 2, 5, 4, 1, 5, 6}));
        System.out.println(largestHistogramArea(new int[]{2, 5, 1}));
    }

    private static int largestHistogramArea(int[] arr) {
        int maxArea = 0;
        int[] previousSmaller = previousSmaller(arr);
        int[] nextSmaller = nextSmaller(arr);
        for (int i = 0; i < arr.length; i++) {
            int currArea = (nextSmaller[i] - previousSmaller[i] - 1) * arr[i];
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }

    private static int[] previousSmaller(int[] arr) {
        int[] previousSmaller = new int[arr.length];
        Stack<Integer> indices = new Stack<>();
        indices.push(0);
        previousSmaller[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            while (!indices.isEmpty() && arr[i] <= arr[indices.peek()]) {
                indices.pop();
            }
            if (indices.isEmpty()) {
                previousSmaller[i] = -1;
            } else {
                previousSmaller[i] = indices.peek();
            }
            indices.push(i);
        }
        System.out.println("Previous smaller: " + Arrays.toString(previousSmaller));
        return previousSmaller;
    }

    private static int[] nextSmaller(int[] arr) {
        int[] nextSmaller = new int[arr.length];
        Stack<Integer> indices = new Stack<>();
        indices.push(arr.length - 1);
        nextSmaller[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!indices.isEmpty() && arr[i] <= arr[indices.peek()]) {
                indices.pop();
            }
            if (indices.isEmpty()) {
                nextSmaller[i] = arr.length;
            } else {
                nextSmaller[i] = indices.peek();
            }
            indices.push(i);
        }
        System.out.println("Next smaller: " + Arrays.toString(nextSmaller));
        return nextSmaller;
    }
}

