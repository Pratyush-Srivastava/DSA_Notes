package Arrays;

import java.util.List;

import static java.util.Arrays.asList;

public class LeftRotateByDTimes {
    public static void main(String[] args) {
        System.out.println(leftRotateByDTimes(asList(1, 2, 3, 4, 5), 2));
        System.out.println(leftRotateByDTimes(asList(1, 2, 3, 4, 5), 3));
        System.out.println(leftRotateByDTimes(asList(10, 5, 30, 15), 3));
    }

    private static List<Integer> leftRotateByDTimes(List<Integer> input, int d) {
        reverse(input, 0, d - 1);
        reverse(input, d, input.size() - 1);
        reverse(input, 0, input.size() - 1);
        return input;
    }

    private static void reverse(List<Integer> input, int low, int high) {
        while (low < high) {
            int temp = input.get(low);
            input.set(low, input.get(high));
            input.set(high, temp);
            low++;
            high--;
        }
    }
}