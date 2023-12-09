package Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Stock span is defined as the number of consecutive days the stock price is smaller or equal to the current price
 * including this day. The stock span of the first day will always be one. Surprisingly, the order of complexity is O(n)
 */
public class StockSpan {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(stockSpan(new int[]{13, 15, 12, 14, 16, 8, 6, 4, 10, 30})));
        System.out.println(Arrays.toString(stockSpan(new int[]{60, 10, 20, 15, 35, 50})));
    }

    private static int[] stockSpan(int[] arr) {
        int[] span = new int[arr.length];
        span[0] = 1;
        Stack<Integer> indices = new Stack<>();
        indices.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (!indices.isEmpty() && arr[i] >= arr[indices.peek()]) {
                indices.pop();
            }
            if (indices.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - indices.peek();
            }
            indices.push(i);
        }
        return span;
    }
}
