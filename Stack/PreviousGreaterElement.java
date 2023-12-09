package Stack;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreaterElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(previousGreaterElement(new int[]{13, 15, 12, 14, 16, 8, 6, 4, 10, 30})));
        System.out.println(Arrays.toString(previousGreaterElement(new int[]{60, 10, 20, 15, 35, 50})));
    }

    private static int[] previousGreaterElement(int[] arr) {
        int[] prevGreater = new int[arr.length];
        prevGreater[0] = -1;
        Stack<Integer> prevStack = new Stack<>();
        prevStack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while (!prevStack.isEmpty() && arr[i] >= prevStack.peek()) {
                prevStack.pop();
            }
            if (prevStack.isEmpty()) {
                prevGreater[i] = -1;
            } else {
                prevGreater[i] = prevStack.peek();
            }
            prevStack.push(arr[i]);
        }
        return prevGreater;
    }
}
